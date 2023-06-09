package com.example.model;

public class Calculator {
    private Integer numberFirst;
    private Integer numberSecond;

    private String button;

    public Calculator() {
    }

    public Calculator(Integer numberFirst, Integer numberSecond, String button) {
        this.numberFirst = numberFirst;
        this.numberSecond = numberSecond;
        this.button = button;
    }

    public Integer getNumberFirst() {
        return numberFirst;
    }

    public void setNumberFirst(Integer numberFirst) {
        this.numberFirst = numberFirst;
    }

    public Integer getNumberSecond() {
        return numberSecond;
    }

    public void setNumberSecond(Integer numberSecond) {
        this.numberSecond = numberSecond;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
}
