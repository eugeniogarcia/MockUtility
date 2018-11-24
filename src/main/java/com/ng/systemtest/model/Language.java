package com.ng.systemtest.model;

public enum Language {

    DE("de", "DEU", "Deutsch"),
    EN("en", "ENG", "English"),
    FR("fr", "FRA", "Français"),
    IT("it", "ITA", "Italiano");

    private final String internalCode;
    private final String siebelCode;
    private final String displayValue;

    private Language(final String internalCode, final String siebelCode, final String displayValue) {
        this.internalCode = internalCode;
        this.siebelCode = siebelCode;
        this.displayValue = displayValue;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public String getSiebelCode() {
        return siebelCode;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
