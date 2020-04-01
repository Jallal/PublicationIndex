package ise.lab.um.category;

import ise.lab.um.model.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RefactoringObjectives {

    private static final String FIRST_ITEM = "External Quality";
    private static final String SECOND_ITEM = "Internal Quality";
    private static final String THIRD_ITEM = "Performance/Parallelism";
    private static final String FOURTH_ITEM = "Migration";
    private static final String FIFTH_ITEM = "Security";

    public static boolean isRefactoringObjectivesCategory(String category){

        return category.equalsIgnoreCase(FIRST_ITEM) ||
                category.equalsIgnoreCase(SECOND_ITEM) ||
                category.equalsIgnoreCase(THIRD_ITEM) ||
                category.equalsIgnoreCase(FOURTH_ITEM) ||
                category.equalsIgnoreCase(FIFTH_ITEM);
    }

    public List<PublisherInfo> getRefactoringObjectivesByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getRefactoringObjectivesExternalQualitySubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getRefactoringObjectivesInternalQualitySubCategory(data);
        } else if (category.equalsIgnoreCase(THIRD_ITEM)) {
            return this.getRefactoringObjectivesPerformenceParallelismSubCategory(data);
        } else if (category.equalsIgnoreCase(FOURTH_ITEM)) {
            return this.getRefactoringObjectivesMigrationSubCategory(data);
        } else if (category.equalsIgnoreCase(FIFTH_ITEM)) {
            return this.getRefactoringObjectivesSecuritySubCategory(data);
        } else {
            return data;
        }
    }

    public List<PublisherInfo> updateTheTagsColumInTheDataSet(List<PublisherInfo> data) {


        for(PublisherInfo  element : data){
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if(element.getBbstract().toLowerCase().contains(FIRST_ITEM.toLowerCase())||
                    element.getBbstract().toLowerCase().contains("analysability".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("changeability".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("time behaviour".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("resource".toLowerCase())) {
                tags.add(FIRST_ITEM);
            } if(element.getBbstract().toLowerCase().contains(SECOND_ITEM.toLowerCase())||
                    element.getBbstract().toLowerCase().contains("maintainability".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("cyclomatic".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("depth of inheritance".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("coupling".toLowerCase())) {
                tags.add(SECOND_ITEM);
            } if(element.getBbstract().toLowerCase().contains("performance".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("parallel".toLowerCase())) {
                tags.add("performance");
            } if(element.getBbstract().toLowerCase().contains(FOURTH_ITEM.toLowerCase())){
                tags.add(FOURTH_ITEM);
            } if(element.getBbstract().toLowerCase().contains(FIFTH_ITEM.toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("secure".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("safety".toLowerCase())) {
                tags.add(FIFTH_ITEM);
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("RefactoringObjectives",tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }

    public String[][] getTheChartDataForRefactoringObjectives(List<PublisherInfo> newdata) {
        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getRefactoringObjectivesExternalQualitySubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getRefactoringObjectivesInternalQualitySubCategory(newdata).size()));
        categoriesMap.put(THIRD_ITEM, Long.valueOf(this.getRefactoringObjectivesPerformenceParallelismSubCategory(newdata).size()));
        categoriesMap.put(FOURTH_ITEM, Long.valueOf(this.getRefactoringObjectivesMigrationSubCategory(newdata).size()));
        categoriesMap.put(FIFTH_ITEM, Long.valueOf(this. getRefactoringObjectivesSecuritySubCategory(newdata).size()));
        int arraySize = categoriesMap.size()+1;
        String[][] pebPerCategory = new String[arraySize][2];
        pebPerCategory[0][0] = "Task";
        pebPerCategory[0][1] = "Hours per Day";
        int count = 1;
        for (Map.Entry<String, Long> entry : categoriesMap.entrySet()) {
            if (count <= arraySize) {
                pebPerCategory[count][0] = entry.getKey();
                pebPerCategory[count][1] = String.valueOf(entry.getValue());
            }
            count++;

        }

        return pebPerCategory;
    }

    private List<PublisherInfo> getRefactoringObjectivesExternalQualitySubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FIRST_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("analysability".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("changeability".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("time behaviour".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("resource".toLowerCase())
        ).collect(Collectors.toList());
    }


    private List<PublisherInfo> getRefactoringObjectivesInternalQualitySubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(SECOND_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("maintainability".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("cyclomatic".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("depth of inheritance".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("coupling".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringObjectivesPerformenceParallelismSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("performance".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("parallel".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringObjectivesMigrationSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FOURTH_ITEM.toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringObjectivesSecuritySubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FIFTH_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("secure".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("safety".toLowerCase())
        ).collect(Collectors.toList());
    }


}
