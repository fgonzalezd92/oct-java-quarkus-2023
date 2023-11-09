package com.herbalife.dto;

public class CalculatorDto {
    private int number;

    public CalculatorDto() {
    }

    public CalculatorDto(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
