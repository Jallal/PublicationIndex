package com.example.springboot.category;

import com.example.springboot.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RefactoringEvaluation {

    private static final String FIRST_ITEM = "Industrial";
    private static final String SECOND_ITEM = "Open source";


    public static boolean isRefactoringEvaluation(String category) {

        return category.equalsIgnoreCase(FIRST_ITEM) ||
                category.equalsIgnoreCase(SECOND_ITEM);
    }

    public List<PublisherInfo> updateRefactoringEvaluation(List<PublisherInfo> data) {

        for(PublisherInfo element : data){
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if(element.getBbstract().toLowerCase().contains("proprietary".toLowerCase())||element.getBbstract().toLowerCase().contains("Industrial".toLowerCase())) {
                tags.add(FIRST_ITEM);
            } if(element.getBbstract().toLowerCase().contains("Open source".toLowerCase())) {
                tags.add(SECOND_ITEM);
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("RefactoringEvaluation",tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }

    public String[][] getTheChartDataForRefactoringEvolution(List<PublisherInfo> newdata) {
        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getRefactoringEvolutionIndustrialSubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getRefactoringEvolutionOpenSourceSubCategory(newdata).size()));
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

    public List<PublisherInfo> getRefactoringEvolutionByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getRefactoringEvolutionIndustrialSubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getRefactoringEvolutionOpenSourceSubCategory(data);
        }else {
            return data;
        }
    }

    private List<PublisherInfo> getRefactoringEvolutionIndustrialSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("proprietary".toLowerCase()) ||
                        i.getBbstract().toLowerCase().contains("industrial")
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getRefactoringEvolutionOpenSourceSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(i ->
                i.getBbstract().toLowerCase().contains("open source") ).collect(Collectors.toList());
    }




}
