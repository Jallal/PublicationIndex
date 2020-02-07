package com.example.springboot;

import com.example.springboot.category.ProgrammingLanguages;
import com.example.springboot.category.RefactoringLifeCycle;
import com.example.springboot.category.TargetOfRefactoring;
import com.opencsv.CSVReader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.springboot.category.RefactoringLifeCycle.isRefactoringLifeCycleCategory;
import static com.example.springboot.category.TargetOfRefactoring.isTargetOfRefactoringCategory;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String loginMessage() throws IOException {
        return "index";
    }


    public String[][] getTheGraphData(List<PublisherInfo> data) {

        Map<String, Long> counters = data.stream().collect(Collectors.groupingBy(p -> p.getYear(), Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size();
        String[][] pebPerYear = new String[arraySize][2];
        pebPerYear[0][0] = "year";
        pebPerYear[0][1] = "Publication";
        int count = 1;
        for (Map.Entry<String, Long> entry : countersSorted.entrySet()) {
            if (count < arraySize) {
                pebPerYear[count][0] = entry.getKey();
                pebPerYear[count][1] = String.valueOf(entry.getValue());
            }
            count++;

        }

        return pebPerYear;
    }


   /* public String[][] getTheChartData(List<PublisherInfo> newdata) {

        List<String> allCategories = new ArrayList<>();
        for (PublisherInfo element : newdata) {
            for (String category : element.getAuthorKeywordsAsList()) {
                allCategories.add(category.trim());
            }
        }

        Map<String, Long> categoriesMap = allCategories.stream().filter(e -> e != null && !e.isEmpty()).collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        int arraySize = categoriesMap.size();
        String[][] pebPerCategory = new String[arraySize][2];
        pebPerCategory[0][0] = "Task";
        pebPerCategory[0][1] = "Hours per Day";
        int count = 1;
        for (Map.Entry<String, Long> entry : categoriesMap.entrySet()) {
            if (count < arraySize) {
                pebPerCategory[count][0] = entry.getKey();
                pebPerCategory[count][1] = String.valueOf(entry.getValue());
            }
            count++;

        }

        return pebPerCategory;
    }*/

    public List<PublisherInfo> searchByPublicationTitle(List<PublisherInfo> data, String filter) {

        return data.stream().filter(e -> e != null).filter(i -> i.getTitle().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
    }


    public List<PublisherInfo> searchByAuthorName(List<PublisherInfo> data, String filter) {

        return data.stream().filter(e -> e != null).filter(i -> i.getAuthorNameAsAsList().stream().anyMatch(e -> e.toLowerCase().contains(filter.toLowerCase()))).collect(Collectors.toList());
    }

    public List<PublisherInfo> searchByTagName(List<PublisherInfo> data, String filter) {


        return data.stream().filter(e -> e != null).filter(i -> i.getAuthorKeywordsAsList().stream().anyMatch(e -> e.toLowerCase().contains(filter.toLowerCase()))).collect(Collectors.toList());
    }

    public List<PublisherInfo> searchByJournalName(List<PublisherInfo> data, String filter) {

        return data.stream().filter(e -> e != null).filter(i -> i.getPublisher().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
    }

    /*public List<PublisherInfo> filterByTags(List<PublisherInfo> data, String filter) {

        if(isRefactoringLifeCycleCategory(filter)){
            RefactoringLifeCycle refactoringLifeCycle = new RefactoringLifeCycle();
            return  refactoringLifeCycle.getRefactoringByCategory(data,filter);

        }else if(isTargetOfRefactoringCategory(filter)){
            TargetOfRefactoring targetOfRefactoring = new TargetOfRefactoring();
            return targetOfRefactoring.getRefactoringByCategory(data,filter);

        }

    }*/

    public List<PublisherInfo> fetchTheSearchData(SearchCriteria search) {
        List<PublisherInfo> data = new ArrayList<>();
        String filename = "papersPreprocessed.csv";
        try {
            data = this.readTheDataFromVCS(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //data.get(0).setPublicationsPerCategory(pebPerYear);
		/*String[][] pebPerYear = new String[5][2];
		pebPerYear[0][0]="year";
		pebPerYear[0][1]="Publication";
		//1
		pebPerYear[1][0]="2014";
		pebPerYear[1][1]="1000";

		//2
		pebPerYear[2][0]="2015";
		pebPerYear[2][1]="1170";

		//3
		pebPerYear[3][0]="2016";
		pebPerYear[3][1]="2010";

		//4
		pebPerYear[4][0]="2017";
		pebPerYear[4][1]="2200";

		//5
		pebPerYear[4][0]="2018";
		pebPerYear[4][1]="2500";


		//publication per category
		//[['Task', 'Hours per Day'], ['Work', 11], ['Eat', 2], ['Commute', 2], ['Watch TV', 2], ['Sleep', 7]]
		String[][] pebPerCategory = new String[6][2];
		pebPerCategory[0][0]="Task";
		pebPerCategory[0][1]="Hours per Day";
		//1
		pebPerCategory[1][0]="Work";
		pebPerCategory[1][1]="11";

		//2
		pebPerCategory[2][0]="EatME";
		pebPerCategory[2][1]="2";

		//3
		pebPerCategory[3][0]="CommuteME";
		pebPerCategory[3][1]="2";

		//4
		pebPerCategory[4][0]="Watch ME";
		pebPerCategory[4][1]="2";

		//5
		pebPerCategory[5][0]="SleepME";
		pebPerCategory[5][1]="7";


		//1st record
		PublisherInfo item = new PublisherInfo();
		item.setCustomerName("Jallal");
		item.setAddress("123 Happy Street");
		item.setCity("Happy City");
		item.setCountry("R1");
		item.setGender("M");
		item.setPostalCode("48108");
		item.setPublicationsPerYear(pebPerYear);
		item.setPublicationsPerCategory(pebPerCategory);

		//2nd record
		PublisherInfo item2 = new PublisherInfo();
		item2.setCustomerName("Jallal");
		item2.setAddress("123 Happy Street");
		item2.setCity("Happy City");
		item2.setCountry("P1");
		item2.setGender("M");
		item2.setPostalCode("48108");
		item2.setPublicationsPerYear(pebPerYear);
		item2.setPublicationsPerCategory(pebPerCategory);

		//3rd record
		PublisherInfo item3 = new PublisherInfo();
		item3.setCustomerName("Jallal");
		item3.setAddress("123 Happy Street");
		item3.setCity("Happy City");
		item3.setCountry("T1");
		item3.setGender("M");
		item3.setPostalCode("48108");
		item3.setPublicationsPerYear(pebPerYear);
		item3.setPublicationsPerCategory(pebPerCategory);

		//4th record
		PublisherInfo item4 = new PublisherInfo();
		item4.setCustomerName("Jallal");
		item4.setAddress("123 Happy Street");
		item4.setCity("Happy City");
		item4.setCountry("D1");
		item4.setGender("M");
		item4.setPostalCode("48108");
		item4.setPublicationsPerYear(pebPerYear);
		item4.setPublicationsPerCategory(pebPerCategory);

		//5th record
		PublisherInfo item5 = new PublisherInfo();
		item5.setCustomerName("Jallal");
		item5.setAddress("123 Happy Street");
		item5.setCity("Happy City");
		item5.setCountry("USA");
		item5.setGender("M");
		item5.setPostalCode("48108");
		item5.setPublicationsPerYear(pebPerYear);
		item5.setPublicationsPerCategory(pebPerCategory);

		//5th record
		PublisherInfo item6 = new PublisherInfo();
		item6.setCustomerName("Jallal");
		item6.setAddress("123 Happy Street");
		item6.setCity("Happy City");
		item6.setCountry("R2");
		item6.setGender("M");
		item6.setPostalCode("48108");
		item6.setPublicationsPerYear(pebPerYear);
		item6.setPublicationsPerCategory(pebPerCategory);

		//6th record
		PublisherInfo item7 = new PublisherInfo();
		item7.setCustomerName("Jallal");
		item7.setAddress("123 Happy Street");
		item7.setCity("Happy City");
		item7.setCountry("D2");
		item7.setGender("M");
		item7.setPostalCode("48108");
		item7.setPublicationsPerYear(pebPerYear);
		item7.setPublicationsPerCategory(pebPerCategory);

		//7th record
		PublisherInfo item8 = new PublisherInfo();
		item8.setCustomerName("Jallal");
		item8.setAddress("123 Happy Street");
		item8.setCity("Happy City");
		item8.setCountry("T2");
		item8.setGender("M");
		item8.setPostalCode("48108");
		item8.setPublicationsPerYear(pebPerYear);
		item8.setPublicationsPerCategory(pebPerCategory);

		//7th record
		PublisherInfo item9 = new PublisherInfo();
		item9.setCustomerName("Jallal");
		item9.setAddress("123 Happy Street");
		item9.setCity("Happy City");
		item9.setCountry("P2");
		item9.setGender("M");
		item9.setPostalCode("48108");
		item9.setPublicationsPerYear(pebPerYear);
		item9.setPublicationsPerCategory(pebPerCategory);

		data.add(item);
		data.add(item2);
		data.add(item3);
		data.add(item4);
		data.add(item5);
		data.add(item6);
		data.add(item7);
		data.add(item8);*/
        return data;
    }

    public List<PublisherInfo> readTheDataFromVCS(String csvFile) throws IOException {

        File file = ResourceUtils.getFile("classpath:" + csvFile);
        CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file)));
        List<PublisherInfo> publishRecords = new ArrayList<>();
        while ((csvReader.readNext()) != null) {

            String[] values = csvReader.readNext();
            List<String> recordsString = Arrays.asList(values);
            PublisherInfo publisherInfo = new PublisherInfo(
                    recordsString.get(0),
                    recordsString.get(1),
                    recordsString.get(2),
                    recordsString.get(3),
                    recordsString.get(4),
                    recordsString.get(5),
                    recordsString.get(6),
                    recordsString.get(7),
                    recordsString.get(8),
                    recordsString.get(9),
                    recordsString.get(10),
                    recordsString.get(11),
                    recordsString.get(12),
                    recordsString.get(13),
                    recordsString.get(14),
                    recordsString.get(15),
                    recordsString.get(16),
                    recordsString.get(17),
                    recordsString.get(18),
                    recordsString.get(19),
                    recordsString.get(20),
                    recordsString.get(21),
                    recordsString.get(22),
                    recordsString.get(23),
                    recordsString.get(24),
                    recordsString.get(25),
                    recordsString.get(26),
                    recordsString.get(27),
                    recordsString.get(28),
                    recordsString.get(29),
                    recordsString.get(30),
                    recordsString.get(31),
                    recordsString.get(32),
                    recordsString.get(33),
                    recordsString.get(34),
                    recordsString.get(35),
                    recordsString.get(36),
                    recordsString.get(37),
                    recordsString.get(38),
                    recordsString.get(39),
                    recordsString.get(40),
                    recordsString.get(41));
            publishRecords.add(publisherInfo);
        }


        return publishRecords;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) throws Exception {

        System.out.print("******************************************************\n");
        System.out.print(search.toString());
        System.out.print("******************************************************\n");
        List<PublisherInfo> data = fetchTheSearchData(search);

        data.sort(
                Comparator.comparing(PublisherInfo::getYear).thenComparing(PublisherInfo::getAuthors).reversed()
        );

        if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("name")) {
            data = searchByAuthorName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("category")) {
            data = searchByTagName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("journal")) {
            data = searchByJournalName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("title")) {
            data = searchByPublicationTitle(data, search.getAuthorName());
        }
        RefactoringLifeCycle refactoringLifeCycle = new RefactoringLifeCycle();
        refactoringLifeCycle.updateTheTagsColumInTheDataSet(data);

        TargetOfRefactoring targetOfRefactoring = new TargetOfRefactoring();
        targetOfRefactoring.updateTheTagsColumInTheDataSet(data);

        ProgrammingLanguages programmingLanguages = new ProgrammingLanguages();
        programmingLanguages.updateTheTagsColumInTheDataSet(data);



        if (null != search.getCategory()) {

            if(isRefactoringLifeCycleCategory(search.getCategory())){

                //filter by the categories
                //RefactoringLifeCycle refactoringLifeCycle = new RefactoringLifeCycle();
                data =  refactoringLifeCycle.getRefactoringByCategory(data,search.getCategory());

                ////put the pie data
                String[][] publicationsPerCategory = refactoringLifeCycle.getTheChartDataForRefactoring(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            }else if(isTargetOfRefactoringCategory(search.getCategory())){

                //filter by the categories
               // TargetOfRefactoring targetOfRefactoring = new TargetOfRefactoring();
                data =  targetOfRefactoring.getRefactoringByCategory(data,search.getCategory());

                //put the pie data
                String[][] publicationsPerCategory = targetOfRefactoring.getTheChartDataForRefactoring(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            }
        }

        //put the graph data
        String[][] pebPerYear = getTheGraphData(data);
        data.get(0).setPublicationsPerYear(pebPerYear);

        System.out.print("***************************************************\n");
        for (PublisherInfo info : data) {
            //System.out.print(data.get(0).getPublicationsPerYear()[i][0] + ":::::::::" + data.get(0).getPublicationsPerYear()[i][1] + "\n");
            System.out.println("Publication index :"+info.getPublisher() +"********** List of tags : "+info.getListOfTages().toString());
        }
        System.out.print("***************************************************\n");

        AjaxResponseBody result = new AjaxResponseBody();
        result.setMsg("success");
        result.setResult(data);
        return ResponseEntity.ok(data);
    }
}
