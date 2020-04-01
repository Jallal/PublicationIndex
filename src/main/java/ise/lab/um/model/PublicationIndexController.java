package ise.lab.um.model;

import ise.lab.um.category.AppliedParadigm;
import ise.lab.um.category.Fields;
import ise.lab.um.category.ProgrammingLanguages;
import ise.lab.um.category.RefactoringEvaluation;
import ise.lab.um.category.RefactoringLifeCycle;
import ise.lab.um.category.RefactoringObjectives;
import ise.lab.um.category.TargetOfRefactoring;
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

import static ise.lab.um.category.RefactoringLifeCycle.isRefactoringLifeCycleCategory;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

@Controller
public class PublicationIndexController {
    private List<PublisherInfo> rawData;
    private RefactoringLifeCycle refactoringLifeCycle;
    private TargetOfRefactoring targetOfRefactoring;
    private ProgrammingLanguages programmingLanguages;
    private RefactoringEvaluation refactoringEvaluation;
    private RefactoringObjectives refactoringObjectives;
    private Fields fields;
    private AppliedParadigm appliedParadigm;

    @RequestMapping("/summary")
    public String loginMessage() throws IOException {
        this.rawData = fetchTheSearchData();
        this.rawData.sort(
                Comparator.comparing(PublisherInfo::getYear).thenComparing(PublisherInfo::getAuthors).reversed()
        );
        this.refactoringLifeCycle = new RefactoringLifeCycle();
        this.targetOfRefactoring = new TargetOfRefactoring();
        this.programmingLanguages = new ProgrammingLanguages();
        this.refactoringEvaluation = new RefactoringEvaluation();
        this.refactoringObjectives = new RefactoringObjectives();
        this.fields = new Fields();
        this.appliedParadigm = new AppliedParadigm();
        this.refactoringLifeCycle.updateTheTagsColumInTheDataSet(this.rawData);
        this.targetOfRefactoring.updateTheTagsColumInTheDataSet(this.rawData);
        this.programmingLanguages.updateTheTagsColumInTheDataSet(this.rawData);
        this.refactoringEvaluation.updateRefactoringEvaluation(this.rawData);
        this.refactoringObjectives.updateTheTagsColumInTheDataSet(this.rawData);
        this.fields.updateTheTagsColumInTheDataSet(this.rawData);
        this.appliedParadigm.updateTheTagsColumInTheDataSet(this.rawData);

        return "summary";
    }


    public String[][] getAllTheCategoriesForPieChartFOrGlobalSearch(List<PublisherInfo> newdata) {

        List<String> alltages = new ArrayList<>();
        for (PublisherInfo element : newdata) {
            for (Map.Entry<String, List<String>> entry : element.getListOfTages().entrySet()) {
                if(!entry.getValue().isEmpty()) {
                   alltages.add(entry.getKey());
                }
            }
        }

        Map<String, Long> counters = alltages.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size() + 1;
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

        Map<String, Long> counters = data.stream().filter(d->d!=null).filter(i -> i.getYear() != null && (Integer.valueOf(i.getYear()) > 2005) && !i.getYear().isEmpty()).collect(Collectors.groupingBy(p -> p.getYear().trim(), Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size() + 1;
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


        List<String> countries = data.stream().filter(k -> Integer.valueOf(k.getYear()) > 2005).flatMap(i -> i.getCountry().stream().filter(d -> d != null && !d.isEmpty())).collect(Collectors.toList());
        Map<String, Long> counters = countries.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        Map<String, Long> countersSorted = counters
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        int arraySize = countersSorted.size() + 1;
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


    public List<PublisherInfo> searchByAll(List<PublisherInfo> data, String filter) {

        return data.stream().filter(e -> e != null).filter(i -> i.getTitle().toLowerCase().contains(filter.toLowerCase())
                || i.getBbstract().toLowerCase().contains(filter.toLowerCase())
                || i.getAuthors().toLowerCase().contains(filter.toLowerCase())
        ).collect(Collectors.toList());

    }

    public List<PublisherInfo> searchByAny(List<PublisherInfo> data) {

        return data.stream().filter(e -> e != null).collect(Collectors.toList());
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
        String[] values = (csvReader.readNext());
        while (values != null) {
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
            values = csvReader.readNext();
        }
        publishRecords.remove(0);
        return publishRecords;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) throws Exception {

        List<PublisherInfo> data = this.rawData;
        if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("all")) {
            data = searchByAll(data,search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("name")) {
            data = searchByAuthorName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("category")) {
            data = searchByTagName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("journal")) {
            data = searchByJournalName(data, search.getAuthorName());
        } else if (null != search.getAuthorName() && search.getSearch().equalsIgnoreCase("title")) {
            data = searchByPublicationTitle(data, search.getAuthorName());

        }
        if (null != search.getCategory()) {
            if(ProgrammingLanguages.isProgrammingLanguages(search.getCategory())){
                data = this.programmingLanguages.getProgrammingLanguageByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = this.programmingLanguages.getTheChartDataForProgrammingLanguages(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            } else if (AppliedParadigm.isAppliedParadigmCategory(search.getCategory())) {

                data = this.appliedParadigm.getAppliedParadigmByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = this.appliedParadigm.getTheChartDataForAppliedParadim(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            } else if (Fields.isFieldsCategory(search.getCategory())) {

                data = this.fields.getRefactoringObjectivesByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = this.fields.getTheChartDataForFields(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);
            } else if (RefactoringObjectives.isRefactoringObjectivesCategory(search.getCategory())) {

                data = this.refactoringObjectives.getRefactoringObjectivesByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = this.refactoringObjectives.getTheChartDataForRefactoringObjectives(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            } else if (RefactoringEvaluation.isRefactoringEvaluation(search.getCategory())) {

                data = this.refactoringEvaluation.getRefactoringEvolutionByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = this.refactoringEvaluation.getTheChartDataForRefactoringEvolution(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            } else if (isRefactoringLifeCycleCategory(search.getCategory())) {

                data = this.refactoringLifeCycle.getRefactoringByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = refactoringLifeCycle.getTheChartDataForRefactoring(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);

            } else if (TargetOfRefactoring.isTargetOfRefactoringCategory(search.getCategory())) {

                data = this.targetOfRefactoring.getRefactoringByCategory(data, search.getCategory());
                String[][] publicationsPerCategory = targetOfRefactoring.getTheChartDataForRefactoring(data);
                data.get(0).setPublicationsPerCategory(publicationsPerCategory);
            }
        } else {
            data = searchByAny(data);
            String[][] allCategories = getAllTheCategoriesForPieChartFOrGlobalSearch(data);
            data.get(0).setPublicationsPerCategory(allCategories);
        }


        String[][] pebPerYear = getThePublicationPerYearGraphData(data);
        data.get(0).setPublicationsPerYear(pebPerYear);

        //put the map data
        String[][] pebPerCountryMap = getThePublicationPerCountryMapData(data);
        data.get(0).setPublicationsMaps(pebPerCountryMap);
        AjaxResponseBody result = new AjaxResponseBody();
        result.setMsg("success");
        result.setResult(data);
        return ResponseEntity.ok(data);
    }
}
