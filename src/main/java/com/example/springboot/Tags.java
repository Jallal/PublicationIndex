package com.example.springboot;

import java.util.stream.Stream;

public enum Tags {
    REFACTORING("R1","R2","R2"),
    DEBUG("D1","D2","D2"),
    PLANING("P1","P2","P2"),
    TESTING("T1","T2","T2");

    private final String firstCategory;
    private final String secondCategory;
    private final String thirdCategory;

    public String getFirstCategory() {
        return firstCategory;
    }

    public String getSecondCategory() {
        return secondCategory;
    }

    public String getThirdCategory() {
        return thirdCategory;
    }

    private Tags(String first, String second, String third) {

        this.firstCategory = first;
        this.secondCategory = second;
        this.thirdCategory = third;
    }

    public static boolean contains(String appName) {
        return Stream.of(values()).anyMatch(validApp -> validApp.name().equalsIgnoreCase(appName));
    }

    public static boolean isOneOf(String appName, Tags... validApps) {
        return Stream.of(validApps).anyMatch(validApp -> validApp.name().equalsIgnoreCase(appName));
    }

}
