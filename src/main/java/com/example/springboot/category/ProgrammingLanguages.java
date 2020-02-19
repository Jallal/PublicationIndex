package com.example.springboot.category;

import com.example.springboot.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgrammingLanguages {


    private static final String FIRST_ITEM = "Java";
    private static final String SECOND_ITEM = "C";
    private static final String THIRD_ITEM = "C#";
    private static final String FOURTH_ITEM = "Python";
    private static final String FIFTH_ITEM = "PHP";
    private static final String SIX_ITEM = "COBOL";
    private static final String SEVENTH_ITEM = "CSS";

    public static boolean isProgrammingLanguages(String category) {

        return category.equalsIgnoreCase(FIRST_ITEM) ||
                category.equalsIgnoreCase(SECOND_ITEM) ||
                category.equalsIgnoreCase(THIRD_ITEM) ||
                category.equalsIgnoreCase(FOURTH_ITEM) ||
                category.equalsIgnoreCase(FIFTH_ITEM) ||
                category.equalsIgnoreCase(SIX_ITEM) ||
                category.equalsIgnoreCase(SEVENTH_ITEM);
    }

    public List<PublisherInfo> getProgrammingLanguageByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getJavaSubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getCSubCategory(data);
        } else if (category.equalsIgnoreCase(THIRD_ITEM)) {
            return this.getC_sharpSubCategory(data);
        } else if (category.equalsIgnoreCase(FOURTH_ITEM)) {
            return this.getPythonSubCategory(data);
        } else if (category.equalsIgnoreCase(FIFTH_ITEM)) {
            return this.getPHPSubCategory(data);
        } else if (category.equalsIgnoreCase(SIX_ITEM)) {
            return this.getCOBOLTSubCategory(data);
        } else if (category.equalsIgnoreCase(SEVENTH_ITEM)) {
            return this.getCSSSubCategory(data);
        } else {
            return data;
        }
    }

    public String[][] getTheChartDataForProgrammingLanguages(List<PublisherInfo> newdata) {
        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getJavaSubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getCSubCategory(newdata).size()));
        categoriesMap.put(THIRD_ITEM, Long.valueOf(this.getC_sharpSubCategory(newdata).size()));
        categoriesMap.put(FOURTH_ITEM, Long.valueOf(this.getPythonSubCategory(newdata).size()));
        categoriesMap.put(FIFTH_ITEM, Long.valueOf(this.getPHPSubCategory(newdata).size()));
        categoriesMap.put(SIX_ITEM, Long.valueOf(this.getCOBOLTSubCategory(newdata).size()));
        categoriesMap.put(SEVENTH_ITEM, Long.valueOf(this.getCSSSubCategory(newdata).size()));
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


    private List<PublisherInfo> getJavaSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("Java".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getCSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("C".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("C++".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getC_sharpSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("C_sharp".toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("C#".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getPythonSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("Python".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getPHPSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("PHP".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getCOBOLTSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("COBOL".toLowerCase())
        ).collect(Collectors.toList());
    }

    private List<PublisherInfo> getCSSSubCategory(List<PublisherInfo> data) {

        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains("CSS".toLowerCase())
        ).collect(Collectors.toList());
    }


    public List<PublisherInfo> updateTheTagsColumInTheDataSet(List<PublisherInfo> data) {
        for (PublisherInfo element : data) {
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if (element.getBbstract().toLowerCase().contains("Java".toLowerCase())) {
                tags.add("Java");
            }
            if (element.getBbstract().toLowerCase().contains("C".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("C++".toLowerCase())) {
                tags.add("C/C++");
            }
            if (element.getBbstract().toLowerCase().contains("C_sharp".toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("C#".toLowerCase())) {
                tags.add("C#");
            }
            if (element.getBbstract().toLowerCase().contains("Python".toLowerCase())) {
                tags.add("Python");
            }
            if (element.getBbstract().toLowerCase().contains("PHP".toLowerCase())) {
                tags.add("PHP");
            }
            if (element.getBbstract().toLowerCase().contains("COBOL".toLowerCase())) {
                tags.add("COBOL");
            }
            if (element.getBbstract().toLowerCase().contains("CSS".toLowerCase())) {
                tags.add("CSS");
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("ProgrammingLanguages", tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }
}
