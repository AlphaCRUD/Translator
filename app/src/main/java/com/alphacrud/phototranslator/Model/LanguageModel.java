package com.alphacrud.phototranslator.Model;

public class LanguageModel {
    String text;
    String shortCode;

    public LanguageModel(String text, String shortCode) {
        this.text = text;
        this.shortCode = shortCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
