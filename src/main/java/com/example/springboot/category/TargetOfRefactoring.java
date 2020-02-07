package com.example.springboot.category;

import com.example.springboot.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TargetOfRefactoring {

    private static final String FIRST_ITEM = "Code";
    private static final String SECOND_ITEM = "Architecture";
    private static final String THIRD_ITEM = "UI";
    private static final String FOURTH_ITEM = "Model";
    private static final String FIFTH_ITEM = "Database";

    public static boolean isTargetOfRefactoringCategory(String category) {

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
            if(element.getBbstract().toLowerCase().contains("code".toLowerCase())||element.getBbstract().toLowerCase().contains("java".toLowerCase())
                    ||element.getBbstract().toLowerCase().contains("object orient".toLowerCase())
                    ||element.getBbstract().toLowerCase().contains("code smell".toLowerCase())) {
                tags.add("Code");
            } if(element.getBbstract().toLowerCase().contains("architecture".toLowerCase())||element.getBbstract().toLowerCase().contains("hotspot".toLowerCase())) {
                tags.add("Architecture");
            } if(element.getBbstract().toLowerCase().contains("design_level".toLowerCase())||element.getBbstract().toLowerCase().contains("model".toLowerCase())) {
                tags.add("Model");
            } if(element.getBbstract().toLowerCase().contains("GUI".toLowerCase())||element.getBbstract().toLowerCase().contains("UI".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("user_interface".toLowerCase())) {
                tags.add("GUI");

            } if(element.getBbstract().toLowerCase().contains("relational_schema".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("databse".toLowerCase())) {
                tags.add("database");
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("TargetOfRefactoring",tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }





    public String[][] getTheChartDataForRefactoring(List<PublisherInfo> newdata) {

        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getRefactoringCodeSubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getRefactoringArchitectureSubCategory(newdata).size()));
        categoriesMap.put(THIRD_ITEM, Long.valueOf(this.getRefactoringUISubCategory(newdata).size()));
        categoriesMap.put(FOURTH_ITEM, Long.valueOf(this.getRefactoringModelSubCategory(newdata).size()));
        categoriesMap.put(FIFTH_ITEM, Long.valueOf(this.getRefactoringDatabaseSubCategory(newdata).size()));
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
    }


    public List<PublisherInfo> getRefactoringByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getRefactoringCodeSubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getRefactoringArchitectureSubCategory(data);
        } else if (category.equalsIgnoreCase(THIRD_ITEM)) {
            return this.getRefactoringUISubCategory(data);
        } else if (category.equalsIgnoreCase(FOURTH_ITEM)) {
            return this.getRefactoringModelSubCategory(data);
        } else if (category.equalsIgnoreCase(FIFTH_ITEM)) {
            return this.getRefactoringDatabaseSubCategory(data);
        } else {
            return data;
        }
    }

    private List<PublisherInfo> getRefactoringCodeSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i -> i.getBbstract().toLowerCase().contains("code") ||
                i.getBbstract().toLowerCase().contains("java") ||
                i.getBbstract().toLowerCase().contains("object orient") ||
                i.getBbstract().toLowerCase().contains("code smell")).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringArchitectureSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i -> i.getBbstract().toLowerCase().contains("architecture") ||
                i.getBbstract().toLowerCase().contains("hotspot")).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringUISubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i -> i.getBbstract().toLowerCase().contains("GUI".toLowerCase()) ||
                i.getBbstract().toLowerCase().contains("UI".toLowerCase()) ||
                i.getBbstract().toLowerCase().contains("user_interface".toLowerCase())).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringModelSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i -> i.getBbstract().toLowerCase().contains("design_level".toLowerCase())
                || i.getBbstract().toLowerCase().contains("model".toLowerCase())).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringDatabaseSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i -> i.getBbstract().toLowerCase().contains("Database".toLowerCase()) ||
                i.getBbstract().toLowerCase().contains("relational_schema".toLowerCase())).collect(Collectors.toList());
    }
}
