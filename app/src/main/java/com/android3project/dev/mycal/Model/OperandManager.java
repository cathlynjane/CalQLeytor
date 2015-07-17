package com.android3project.dev.mycal.Model;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Created by Dev on 7/16/2015.
 */
public class OperandManager {
    private String firstNumber;
    private String secondNumber;
    private String operator;

    public OperandManager(String firstNumber, String secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    //Getters
    public String getFirstNumber() {
        return firstNumber;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    //Setters
    public void setFirstNumber(String firstNumber) {
        this.firstNumber = firstNumber;
    }

    public void setSecondNumber(String secondNumber) {
        this.secondNumber = secondNumber;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public static Number getNumFormat(String number) throws ParseException {
        return NumberFormat.getInstance().parse(number);
    }
}
