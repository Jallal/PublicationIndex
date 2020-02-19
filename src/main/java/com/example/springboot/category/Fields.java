package com.example.springboot.category;

import com.example.springboot.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Fields {

    private static final String FIRST_ITEM = "data mining";
    private static final String SECOND_ITEM = "Search based";
    private static final String THIRD_ITEM = "Formal Methods";
    private static final String FOURTH_ITEM = "Fuzzy logic";

    public static boolean isFieldsCategory(String category) {

        return category.equalsIgnoreCase(FIRST_ITEM) ||
                category.equalsIgnoreCase(SECOND_ITEM) ||
                category.equalsIgnoreCase(THIRD_ITEM) ||
                category.equalsIgnoreCase(FOURTH_ITEM);
    }


    public List<PublisherInfo> getRefactoringObjectivesByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getFieldsDataMiningSubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getFieldsSearchBaseSubCategory(data);
        } else if (category.equalsIgnoreCase(THIRD_ITEM)) {
            return this.getFieldsFOrmalMethodsSubCategory(data);
        } else if (category.equalsIgnoreCase(FOURTH_ITEM)) {
            return this.getFieldsFuzzyLogicSubCategory(data);
        } else {
            return data;
        }
    }


    public List<PublisherInfo> updateTheTagsColumInTheDataSet(List<PublisherInfo> data) {


        for (PublisherInfo element : data) {
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if (element.getBbstract().toLowerCase().contains(FIRST_ITEM.toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("artificial intelligence".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("machine learning".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("naive bayes".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("decision tree".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("SVM".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("support vector machine".toLowerCase())

                    ) {
                tags.add(FIRST_ITEM);
            }
            if (element.getBbstract().toLowerCase().contains(SECOND_ITEM.toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("search_base".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("sbse".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("genetic".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("fitness".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("simulated annealing".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("tabu search".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("search space".toLowerCase())
                    ) {
                tags.add(SECOND_ITEM);
            }
            if (element.getBbstract().toLowerCase().contains(THIRD_ITEM.toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("model check".toLowerCase())) {
                tags.add(THIRD_ITEM);
            }
            if (element.getBbstract().toLowerCase().contains("fuzzy".toLowerCase())) {
                tags.add(FOURTH_ITEM);
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("Fields", tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }

    public String[][] getTheChartDataForFields(List<PublisherInfo> newdata) {
        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getFieldsDataMiningSubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getFieldsSearchBaseSubCategory(newdata).size()));
        categoriesMap.put(THIRD_ITEM, Long.valueOf(this.getFieldsFOrmalMethodsSubCategory(newdata).size()));
        categoriesMap.put(FOURTH_ITEM, Long.valueOf(this.getFieldsFuzzyLogicSubCategory(newdata).size()));
        int arraySize = categoriesMap.size() + 1;
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


    public List<PublisherInfo> getFieldsDataMiningSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FIRST_ITEM.toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("artificial intelligence".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("machine learning".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("naive bayes".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("decision tree".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("SVM".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("support vector machine".toLowerCase())

        ).collect(Collectors.toList());

    }

    public List<PublisherInfo> getFieldsSearchBaseSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(SECOND_ITEM.toLowerCase()) ||
                element.getBbstract().toLowerCase().contains("search_base".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("sbse".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("genetic".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("fitness".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("simulated annealing".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("tabu search".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("search space".toLowerCase())
        ).collect(Collectors.toList());
    }

    public List<PublisherInfo> getFieldsFOrmalMethodsSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(THIRD_ITEM.toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("model check".toLowerCase())
        ).collect(Collectors.toList());

    }

    public List<PublisherInfo> getFieldsFuzzyLogicSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("fuzzy".toLowerCase())
        ).collect(Collectors.toList());

    }


}
