package com.example.demo;
import java.lang.Math;

public class Calculator {
    float first_operand = 0;
    float answer = 0;
    String last_operator = "plus";
    public String calc(String operand,String operator){
        try {
            if(operand.equals("u")){
                last_operator = operator;
                return String.valueOf(first_operand);
            }
            if (operator.equals("C")) {
                answer = 0;
                first_operand = 0;
                last_operator = "plus";
                return "0";
            }
            if (operator.equals("CE")) {
                answer = 0;
                return "0";
            }
            if (operator.equals("1/X")) {
                if(Float.parseFloat(operand) == 0) {
                    if (first_operand != 0) {
                        operand = String.valueOf(1 / first_operand);
                    }
                    else {
                        first_operand = 0;
                        answer = 0;
                        last_operator = "plus";
                        return "E";
                    }
                }
                else {
                    operand = String.valueOf(1 / Float.parseFloat(operand));

                }
            }
            if (operator.equals("X2")) {
                if(Float.parseFloat(operand) == 0) {
                    operand = String.valueOf((first_operand * first_operand));
                }
                else {
                    operand = String.valueOf((Float.parseFloat(operand) * Float.parseFloat(operand)));

                }
            }
            if (operator.equals("perc")) {
                if(Float.parseFloat(operand) == 0) {
                    operand = String.valueOf((first_operand/100));
                }
                else {
                    operand = String.valueOf((Float.parseFloat(operand)/100));

                }
            }
            if (operator.equals("sqrt(X)")) {
                if(Float.parseFloat(operand) == 0) {
                    float temp;float sr = first_operand / 2;
                    do {
                        temp = sr;sr = (temp + (first_operand / temp)) / 2;
                    } while ((temp - sr) != 0);
                    operand = String.valueOf(sr);
                }
                else {
                    float temp;
                    float sr = Float.parseFloat(operand) / 2;
                    do {
                        temp = sr;
                        sr = (temp + (Float.parseFloat(operand) / temp)) / 2;
                    } while ((temp - sr) != 0);
                    operand = String.valueOf(sr);

                }
            }
            if (last_operator.equals("plus")) {
                answer = Float.parseFloat(operand) + first_operand;
                first_operand = answer;
                last_operator = operator;
                return String.valueOf(answer);
            }
            if (last_operator.equals("minus")) {
                answer = first_operand - Float.parseFloat(operand);
                first_operand = answer;
                last_operator = operator;
                return String.valueOf(answer);
            }
            if (last_operator.equals("times")) {
                answer = Float.parseFloat(operand) * first_operand;
                first_operand = answer;
                last_operator = operator;
                return String.valueOf(answer);
            }
            if (last_operator.equals("div")) {
                if (Float.parseFloat(operand) == 0) {
                    first_operand = 0;
                    answer = 0;
                    last_operator = "plus";
                    return "E";
                }
                answer = first_operand / Float.parseFloat(operand);
                first_operand = answer;
                last_operator = operator;
                return String.valueOf(answer);
            }
            if (last_operator.equals("mod")) {
                answer = first_operand % Float.parseFloat(operand);
                first_operand = answer;
                last_operator = operator;
                return String.valueOf(answer);
            }
        }
        catch (Exception e){
            last_operator = "plus";
            first_operand = 0;
            answer = 0;
            return "E";
        }
        last_operator = operator;
        first_operand = Float.parseFloat(operand);
        answer = first_operand;
        return operand;
    }
}
