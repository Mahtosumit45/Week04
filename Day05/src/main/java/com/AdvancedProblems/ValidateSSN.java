package com.AdvancedProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static boolean validate(String text){
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return  matcher.find();
    }
    public static void main(String[] args) {
        String text = "My SSN 123-45-6789";
        if(validate(text)){
            System.out.println(text+" is valid");

        }
        else System.out.println(text+" is Invalid");
    }
}
