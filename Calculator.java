package com.java.test;

public class Calculator {

    public final String NewLine = "\n";

    private static int addIntegers(int previousSum, String candidate) {
        int sum = previousSum;
        if(Integer.parseInt(candidate) < 1000){
            sum = previousSum + Integer.parseInt(candidate);
        }
        return sum;
    }

    private int calculateSum(String[] inputTokens) {
        int sum = 0;
        for (String candidate: inputTokens) {
            candidate = candidate.trim();
            if(candidate.matches("[0-9]+")){
                sum = addIntegers(sum, candidate);
            }else{
                String temp = "";
                int value= 0;
                if(!candidate.isEmpty()){
                    if(candidate.contains(NewLine)){
                        candidate = candidate.replace(NewLine , "");
                    }else if(candidate.startsWith("-")){
                        throw new NumberFormatException("Negatives not allowed " + candidate);
                    }
                    for (int i = 0; i <candidate.length(); i++) {
                        char ch = candidate.charAt(i);
                        if (Character.isDigit(ch)) {
                          value += Integer.parseInt(String.valueOf(ch));
                    }else{
                            temp = "0";
                        }
                    }
                    temp = String.valueOf(value);
                    sum = addIntegers(sum, temp);
                }
            }
        }
        return sum;
    }

    private String findDelimeter(String input) {
        String delimeter = ",";
        if(input.startsWith("//")) {
            delimeter = "" + input.charAt(2);
            if(delimeter.equalsIgnoreCase(".") || delimeter.equalsIgnoreCase("$") || delimeter.equalsIgnoreCase("*")){
                delimeter = "\\" + delimeter;
            }
        }
        return delimeter;
    }

    private String[] preProcessInput(String input, String delimeter) {
        if(input.startsWith("//")){
            input = input.substring(3).trim();
        }
        return input.split(delimeter);
    }

    public int add(String input){

        // Return if the input string is null or empty
        if(input == null || input.isEmpty() || input.trim().isEmpty()){
            return 0;
        }

        return calculateSum(preProcessInput(input.trim(), findDelimeter(input.trim())));
    }
   
}