package com.ExtractionProblems;

import java.util.regex.*;
import java.util.*;

public class ExtractAllCapitalizedWords {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> capitals = extractEmails(text);

        for (String capital : capitals) {
            System.out.println(capital);
        }
    }

    public static List<String> extractEmails(String text) {
        List<String> capitalList = new ArrayList<>();

        String regex = "\\b[A-Z]{1}[a-zA-Z.-]*\\b";



        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            capitalList.add(matcher.group());
        }

        return capitalList;
    }
}
