package ise.lab.um.category;

import ise.lab.um.model.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppliedParadigm {

    private static final String FIRST_ITEM = "OO Design";
    private static final String SECOND_ITEM = "Cloud";
    private static final String THIRD_ITEM = "Mobile Apps";
    private static final String FOURTH_ITEM = "Model-driven";
    private static final String FIFTH_ITEM = "Aspect-oriented";

    public static boolean isAppliedParadigmCategory(String category){

        return category.equalsIgnoreCase(FIRST_ITEM) ||
                category.equalsIgnoreCase(SECOND_ITEM) ||
                category.equalsIgnoreCase(THIRD_ITEM) ||
                category.equalsIgnoreCase(FOURTH_ITEM) ||
                category.equalsIgnoreCase(FIFTH_ITEM);
    }

    public List<PublisherInfo> getAppliedParadigmByCategory(List<PublisherInfo> data, String category) {

        if (category.equalsIgnoreCase(FIRST_ITEM)) {
            return this.getOODesignSubCategory(data);
        } else if (category.equalsIgnoreCase(SECOND_ITEM)) {
            return this.getCloudSubCategory(data);
        } else if (category.equalsIgnoreCase(THIRD_ITEM)) {
            return this.getMobileAppsSubCategory(data);
        } else if (category.equalsIgnoreCase(FOURTH_ITEM)) {
            return this.getModelDrivenSubCategory(data);
        } else if (category.equalsIgnoreCase(FIFTH_ITEM)) {
            return this.getAspectOrientedSubCategory(data);
        } else {
            return data;
        }
    }




    public List<PublisherInfo> updateTheTagsColumInTheDataSet(List<PublisherInfo> data) {


        for(PublisherInfo  element : data){
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if(element.getBbstract().toLowerCase().contains(FIRST_ITEM.toLowerCase())||
                    element.getBbstract().toLowerCase().contains("object_orient".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("java".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("C".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("++".toLowerCase())) {
                tags.add(FIRST_ITEM);
            } if(element.getBbstract().toLowerCase().contains(SECOND_ITEM.toLowerCase())||
                    element.getBbstract().toLowerCase().contains("web service".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("wsdl".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("restfull".toLowerCase())) {
                tags.add(SECOND_ITEM);
            } if(element.getBbstract().toLowerCase().contains(THIRD_ITEM.toLowerCase())||
                    element.getBbstract().toLowerCase().contains("android".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("mobile".toLowerCase())) {
                tags.add(THIRD_ITEM);
            } if(element.getBbstract().toLowerCase().contains(FOURTH_ITEM.toLowerCase())||
                    element.getBbstract().toLowerCase().contains("model transform".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("uml".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("reverse engineering".toLowerCase())||
                    element.getBbstract().toLowerCase().contains("diagram".toLowerCase())

                    ){
                tags.add(FOURTH_ITEM);
            } if(element.getBbstract().toLowerCase().contains(FIFTH_ITEM.toLowerCase()) ||
                    element.getBbstract().toLowerCase().contains("aspect".toLowerCase())) {
                tags.add(FIFTH_ITEM);
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("AppliedParadigm",tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }



    public String[][] getTheChartDataForAppliedParadim(List<PublisherInfo> newdata) {
        Map<String, Long> categoriesMap = new HashMap<>();
        categoriesMap.put(FIRST_ITEM, Long.valueOf(this.getOODesignSubCategory(newdata).size()));
        categoriesMap.put(SECOND_ITEM, Long.valueOf(this.getCloudSubCategory(newdata).size()));
        categoriesMap.put(THIRD_ITEM, Long.valueOf(this.getMobileAppsSubCategory(newdata).size()));
        categoriesMap.put(FOURTH_ITEM, Long.valueOf(this.getModelDrivenSubCategory(newdata).size()));
        categoriesMap.put(FIFTH_ITEM, Long.valueOf(this.getAspectOrientedSubCategory(newdata).size()));
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
    public List<PublisherInfo> getOODesignSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FIRST_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("object_orient".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("java".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("C".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("++".toLowerCase())
        ).collect(Collectors.toList());

    }

    public List<PublisherInfo> getCloudSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(SECOND_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("web service".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("wsdl".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("restfull".toLowerCase())
        ).collect(Collectors.toList());
    }

    public List<PublisherInfo> getMobileAppsSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(THIRD_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("android".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("mobile".toLowerCase())
        ).collect(Collectors.toList());
    }

    public List<PublisherInfo> getModelDrivenSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FOURTH_ITEM.toLowerCase())||
                        element.getBbstract().toLowerCase().contains("model transform".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("uml".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("reverse engineering".toLowerCase())||
                        element.getBbstract().toLowerCase().contains("diagram".toLowerCase())
        ).collect(Collectors.toList());
    }

    public List<PublisherInfo> getAspectOrientedSubCategory(List<PublisherInfo> data) {
        return data.stream().filter(element ->
                element.getBbstract().toLowerCase().contains(FIFTH_ITEM.toLowerCase()) ||
                        element.getBbstract().toLowerCase().contains("aspect".toLowerCase())
        ).collect(Collectors.toList());
    }


}
