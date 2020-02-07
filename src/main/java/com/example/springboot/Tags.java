package com.example.springboot;

import java.util.stream.Stream;

public enum Tags {

    TARGET_OF_REFACTORING("Code","Architecture","UI","Model","Database"),
    DEBUG("D1","D2","D2",null,null),
    PLANING("P1","P2","P2",null,null),
    TESTING("T1","T2","T2",null,null);

    private final String firstCategory;
    private final String secondCategory;
    private final String thirdCategory;
    private final String fourthCategory;
    private final String fifthCategory;

    public String getFourthCategory() {
        return fourthCategory;
    }

    public String getFifthCategory() {
        return fifthCategory;
    }



    public String getFirstCategory() {
        return firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public String getThirdCategory() {
        return thirdCategory;
    }

    private Tags(String first, String second, String third,String fourth, String fifth) {

        this.firstCategory = first;
        this.secondCategory = second;
        this.thirdCategory = third;
        this.fourthCategory=fourth;
        this.fifthCategory=fifth;
    }

    public static boolean contains(String appName) {
        return Stream.of(values()).anyMatch(validApp -> validApp.name().equalsIgnoreCase(appName));
    }

    public static boolean isOneOf(String appName, Tags... validApps) {
        return Stream.of(validApps).anyMatch(validApp -> validApp.name().equalsIgnoreCase(appName));
    }

}
