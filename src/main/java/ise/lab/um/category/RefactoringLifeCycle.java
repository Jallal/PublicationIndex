package ise.lab.um.category;

import ise.lab.um.model.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RefactoringLifeCycle {

    private static final String FIRST_ITEM = "Recommendation";
    private static final String SECOND_ITEM = "Detection";
    private static final String THIRD_ITEM = "Testing";
    private static final String FOURTH_ITEM = "Automation";
    private static final String FIFTH_ITEM = "Prioritization";

    public static boolean isRefactoringLifeCycleCategory(String category){

        return category.equalsIgnoreCase(FIRST_ITEM) ||
                category.equalsIgnoreCase(SECOND_ITEM) ||
                category.equalsIgnoreCase(THIRD_ITEM) ||
                category.equalsIgnoreCase(FOURTH_ITEM) ||
                category.equalsIgnoreCase(FIFTH_ITEM);
    }

    public List<PublisherInfo> updateTheTagsColumInTheDataSet(List<PublisherInfo> data) {


        for(PublisherInfo  element : data){
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if(element.getBbstract().toLowerCase().contains("recommend".toLowerCase())||element.getBbstract().toLowerCase().contains("correction".toLowerCase())||element.getBbstract().toLowerCase().contains("fixing".toLowerCase())) {
                tags.add("recommend");
            } if(element.getBbstract().toLowerCase().contains("detect".toLowerCase())||element.getBbstract().toLowerCase().contains("opportun".toLowerCase())) {
                tags.add("detect");
            } if(element.getBbstract().toLowerCase().contains("test".toLowerCase())) {
                tags.add("test");
            } if(element.getBbstract().toLowerCase().contains("generation".toLowerCase())||element.getBbstract().toLowerCase().contains("automat".toLowerCase())) {
                tags.add("automat");
            } if(element.getBbstract().toLowerCase().contains("schedul".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("sequence".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("next release".toLowerCase()) ||
                            element.getBbstract().toLowerCase().contains("priorit".toLowerCase())) {
                tags.add("priorit");
        }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("RefactoringLifeCycle",tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }


    public String[][] getTheChartDataForRefactoring(List<PublisherInfo> newdata) {
        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getRefactoringRecommendationSubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getRefactoringDetectSubCategory(newdata).size()));
        categoriesMap.put(THIRD_ITEM, Long.valueOf(this.getRefactoringTestingSubCategory(newdata).size()));
        categoriesMap.put(FOURTH_ITEM, Long.valueOf(this.getRefactoringAutomatioSubCategory(newdata).size()));
        categoriesMap.put(FIFTH_ITEM, Long.valueOf(this.getRefactoringPrioritizationSubCategory(newdata).size()));
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

    public List<PublisherInfo> getRefactoringByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getRefactoringRecommendationSubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getRefactoringDetectSubCategory(data);
        } else if (category.equalsIgnoreCase(THIRD_ITEM)) {
            return this.getRefactoringTestingSubCategory(data);
        } else if (category.equalsIgnoreCase(FOURTH_ITEM)) {
            return this.getRefactoringAutomatioSubCategory(data);
        } else if (category.equalsIgnoreCase(FIFTH_ITEM)) {
            return this.getRefactoringPrioritizationSubCategory(data);
        } else {
            return data;
        }
    }

    private List<PublisherInfo> getRefactoringRecommendationSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("recommend".toLowerCase()) ||
                        i.getBbstract().toLowerCase().contains("correction") ||
                        i.getBbstract().toLowerCase().contains("fixing")
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringDetectSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("detect") ||
                        i.getBbstract().toLowerCase().contains("opportun")).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringTestingSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("test".toLowerCase())).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringAutomatioSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("generation".toLowerCase()) ||
                        i.getBbstract().toLowerCase().contains("automat".toLowerCase())).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringPrioritizationSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("schedul".toLowerCase()) ||
                        i.getBbstract().toLowerCase().contains("sequence".toLowerCase()) ||
                        i.getBbstract().toLowerCase().contains("next release".toLowerCase()) ||
                        i.getBbstract().toLowerCase().contains("priorit".toLowerCase())).collect(Collectors.toList());
    }
}
