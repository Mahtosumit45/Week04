package com.ExtractionProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extractLinks(text);

        for (String link : links) {
            System.out.println(link);
        }
    }

    public static List<String> extractLinks(String text) {
        List<String> linkList = new ArrayList<>();

        String regex = "\\bhttps?://(www\\.)?[a-zA-Z0-9]+\\.[a-z]{2,}\\b";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            linkList.add(matcher.group());
        }

        return linkList;
    }
}
