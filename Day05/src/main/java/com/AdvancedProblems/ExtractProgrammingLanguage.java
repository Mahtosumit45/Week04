package com.AdvancedProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguage {
    public static List<String> getLanguageList(String text, List<String> languages){

        List<String> ans = new ArrayList<>();
        for (String string : languages) {
            String regex = "(i?)\\b"+string+"\\b";
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(text);
            while(matcher.find()){
                ans.add(matcher.group());
            }

        }
        return ans;

    }
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        languages.add("Go");
        List<String> extractedLanguages = getLanguageList(text,languages);
        System.out.println("List of Extracted languages in the text: "+extractedLanguages);

    }
}
