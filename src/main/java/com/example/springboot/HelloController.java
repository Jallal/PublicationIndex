package com.example.springboot;

import com.example.springboot.category.ProgrammingLanguages;
import com.example.springboot.category.RefactoringEvaluation;
import com.example.springboot.category.RefactoringLifeCycle;
import com.example.springboot.category.TargetOfRefactoring;
import com.opencsv.CSVReader;
import com.sun.org.apache.bcel.internal.generic.Select;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.springboot.category.RefactoringEvaluation.isRefactoringEvaluation;
import static com.example.springboot.category.RefactoringLifeCycle.isRefactoringLifeCycleCategory;
import static com.example.springboot.category.TargetOfRefactoring.isTargetOfRefactoringCategory;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

@Controller
public class HelloController {
    private  List<PublisherInfo> rawData;
    private RefactoringLifeCycle refactoringLifeCycle;
    private TargetOfRefactoring targetOfRefactoring;
    private ProgrammingLanguages programmingLanguages;
    private RefactoringEvaluation refactoringEvaluation;

    @RequestMapping("/index")
    public String loginMessage() throws IOException {
        this.rawData = fetchTheSearchData();
        this.rawData.sort(
                Comparator.comparing(PublisherInfo::getYear).thenComparing(PublisherInfo::getAuthors).reversed()
        );
        this.refactoringLifeCycle = new RefactoringLifeCycle();
        this.targetOfRefactoring = new TargetOfRefactoring();
        this.programmingLanguages = new ProgrammingLanguages();
        this.refactoringEvaluation = new RefactoringEvaluation();

        this.refactoringLifeCycle.updateTheTagsColumInTheDataSet(this.rawData);
        this.targetOfRefactoring.updateTheTagsColumInTheDataSet(this.rawData);
        this.programmingLanguages.updateTheTagsColumInTheDataSet(this.rawData);
        this.refactoringEvaluation.updateRefactoringEvaluation(this.rawData);



        return "index";
    }




    public String[][] getAllTheCategoriesForPieChartFOrGlobalSearch(List<PublisherInfo> newdata) {

         List<String> alltages = new ArrayList<>();
         for(PublisherInfo element : newdata ) {
             for (Map.Entry<String, List<String>> entry : element.getListOfTages().entrySet()) {
                 alltages.add(entry.getKey());
             }
         }

        Map<String, Long> counters =  alltages.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size()+1;
        String[][] pebPerYear = new String[arraySize][2];
        pebPerYear[0][0] = "Task";
        pebPerYear[0][1] = "Hours per Day";
        int count = 1;
        for (Map.Entry<String, Long> entry : countersSorted.entrySet()) {
            if (count <= arraySize) {
                pebPerYear[count][0] = entry.getKey();
                pebPerYear[count][1] = String.valueOf(entry.getValue());
            }
            count++;

        }

        return pebPerYear;
    }


    public String[][] getThePublicationPerYearGraphData(List<PublisherInfo> data) {

        Map<String, Long> counters = data.stream().filter(i->i.getYear()!=null&&(Integer.valueOf(i.getYear())>2005)&&!i.getYear().isEmpty()).collect(Collectors.groupingBy(p -> p.getYear().trim(), Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size()+1;
        String[][] pebPerYear = new String[arraySize][2];
        pebPerYear[0][0] = "year";
        pebPerYear[0][1] = "Publication";
        int count = 1;
        for (Map.Entry<String, Long> entry : countersSorted.entrySet()) {
            if (count <= arraySize) {
                pebPerYear[count][0] = entry.getKey();
                pebPerYear[count][1] = String.valueOf(entry.getValue());
            }
            count++;

        }

        return pebPerYear;
    }


    public String[][] getThePublicationPerCountryMapData(List<PublisherInfo> data) {


        List<String> countries = data.stream().filter(k->Integer.valueOf(k.getYear())>2005).flatMap(i->i.getCountry().stream().filter(d->d!=null &&!d.isEmpty())).collect(Collectors.toList());
        Map<String, Long> counters = countries.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size()+1;
        String[][] pebPerYear = new String[arraySize][2];
        pebPerYear[0][0] = "Country";
        pebPerYear[0][1] = "Publication";
        int count = 1;
        for (Map.Entry<String, Long> entry : countersSorted.entrySet()) {
            if (count <= arraySize) {
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

   public List<PublisherInfo>searchByAny(List<PublisherInfo> data, String filter){

       return data.stream().filter(e -> e != null).filter(i -> i.getTitle().toLowerCase().contains(filter.toLowerCase())
              || i.getBbstract().toLowerCase().contains(filter.toLowerCase())
               || i.getAuthors().toLowerCase().contains(filter.toLowerCase())
       ).collect(Collectors.toList());

   }

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

    public List<PublisherInfo> fetchTheSearchData() {
        List<PublisherInfo> data = new ArrayList<>();
        String filename = "papersPreprocessed.csv";
        try {
            data = this.readTheDataFromVCS(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        List<PublisherInfo> data =this.rawData;

        System.out.print("******************************************************\n");
        System.out.print(search.toString());
        System.out.print("******************************************************\n");


        if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("Select search criteria")) {
            data = searchByAny(data, search.getAuthorName());
        }else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("name")) {
            data = searchByAuthorName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("category")) {
            data = searchByTagName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("journal")) {
            data = searchByJournalName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("title")) {
            data = searchByPublicationTitle(data, search.getAuthorName());

        }


        if (null != search.getCategory()) {

            if(isRefactoringEvaluation(search.getCategory())){
                //filter by the categories
                data = this.refactoringEvaluation.getRefactoringEvolutionByCategory(data,search.getCategory());
                ////put the pie data
                String[][] publicationsPerCategory = this.refactoringEvaluation.getTheChartDataForRefactoringEvolution(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            } else if(isRefactoringLifeCycleCategory(search.getCategory())){

                //filter by the categories
                //RefactoringLifeCycle refactoringLifeCycle = new RefactoringLifeCycle();
                data =  this.refactoringLifeCycle.getRefactoringByCategory(data,search.getCategory());

                ////put the pie data
                String[][] publicationsPerCategory = refactoringLifeCycle.getTheChartDataForRefactoring(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            }else if(isTargetOfRefactoringCategory(search.getCategory())){

                //filter by the categories
                //TargetOfRefactoring targetOfRefactoring = new TargetOfRefactoring();
                data =  this.targetOfRefactoring.getRefactoringByCategory(data,search.getCategory());

                //put the pie data
                String[][] publicationsPerCategory = targetOfRefactoring.getTheChartDataForRefactoring(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            }
        }else {

            //put the pie data
            String[][] allCategories = getAllTheCategoriesForPieChartFOrGlobalSearch(data);
            data.get(0).setPublicationsPerCategory(allCategories);
        }

        //put the publication per year graph data
        String[][] pebPerYear = getThePublicationPerYearGraphData(data);
        data.get(0).setPublicationsPerYear(pebPerYear);

        //put the map data
        String[][] pebPerCountryMap = getThePublicationPerCountryMapData(data);
        data.get(0).setPublicationsMaps(pebPerCountryMap);


        /*System.out.print("***************************************************\n");
        for (int i=0; i< data.get(0).getPublicationsPerYear().length;i++) {
            System.out.print(data.get(0).getPublicationsPerYear()[i][0] + ":::::::::" + data.get(0).getPublicationsPerYear()[i][1] + "\n");
            //System.out.println("Publication index :"+info.getPublicationsMaps().toString() +"\n");
        }
        System.out.print("***************************************************\n");*/




        AjaxResponseBody result = new AjaxResponseBody();
        result.setMsg("success");
        result.setResult(data);
        return ResponseEntity.ok(data);
    }
}
