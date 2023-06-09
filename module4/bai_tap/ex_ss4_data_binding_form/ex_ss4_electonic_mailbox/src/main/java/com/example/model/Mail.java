package com.example.model;

public class Mail {
    private String language;
    private String size;
    private String spam;
    private String signature;

    public Mail() {
    }

    public Mail(String language, String size, String spam, String signature) {
        this.language = language;
        this.size = size;
        this.spam = spam;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpam() {
        return spam;
    }

    public void setSpam(String spam) {
        this.spam = spam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
