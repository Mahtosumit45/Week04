package com.ExtractionProblems;

import java.util.regex.*;
import java.util.*;

public class ExtractDates {
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = extractDates(text);

        for (String date : dates) {
            System.out.println(date);
        }
    }

    public static List<String> extractDates(String text) {
        List<String> dateList = new ArrayList<>();

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            dateList.add(matcher.group());
        }

        return dateList;
    }
}