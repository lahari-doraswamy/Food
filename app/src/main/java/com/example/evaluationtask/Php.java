package com.example.evaluationtask;

public class Php
{
    private final String strCategory;
    private final String strCategoryThumb;
    private final String strCategoryDescription;

    public Php(String strCategory, String strCategoryThumb, String strCategoryDescription) {
        this.strCategory = strCategory;
        this.strCategoryThumb = strCategoryThumb;
        this.strCategoryDescription = strCategoryDescription;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }
}