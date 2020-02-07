package com.example.springboot.category;

import com.example.springboot.PublisherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgrammingLanguages {


    public List<PublisherInfo> updateTheTagsColumInTheDataSet(List<PublisherInfo> data) {


        for(PublisherInfo  element : data){
            Map<String, List<String>> listOfTags = new HashMap<>();
            List<String> tags = new ArrayList<>();
            if(element.getBbstract().toLowerCase().contains("Java".toLowerCase())) {
                tags.add("Java");
            } if(element.getBbstract().toLowerCase().contains("C".toLowerCase())||element.getBbstract().toLowerCase().contains("C++".toLowerCase())) {
                tags.add("C/C++");
            } if(element.getBbstract().toLowerCase().contains("C_sharp".toLowerCase())||element.getBbstract().toLowerCase().contains("C#".toLowerCase())) {
                tags.add("C#");
            } if(element.getBbstract().toLowerCase().contains("Python".toLowerCase())) {
                tags.add("Python");
            } if(element.getBbstract().toLowerCase().contains("PHP".toLowerCase())){
                tags.add("PHP");
            } if(element.getBbstract().toLowerCase().contains("COBOL".toLowerCase())){
                tags.add("COBOL");
            } if(element.getBbstract().toLowerCase().contains("CSS".toLowerCase())){
                tags.add("CSS");
            }
            tags = tags.stream().distinct().collect(Collectors.toList());
            listOfTags.put("ProgrammingLanguages",tags);
            element.setListOfTages(listOfTags);
        }
        return data;
    }
}
