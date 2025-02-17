package com.ExtractionProblems;

import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emails = extractEmails(text);

        for (String email : emails) {
            System.out.println(email);
        }
    }

    public static List<String> extractEmails(String text) {
        List<String> emailList = new ArrayList<>();

        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";


        Pattern pattern = Pattern.compile(regex);


        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            emailList.add(matcher.group());
        }

        return emailList;
    }
}

