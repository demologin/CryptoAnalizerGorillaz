package com.javarush.regex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

    public static final String NON_RU_CHARS = "[^А-Яа-яёË]+";
    public static final String EMAIL_PATTERN = "([a-z0-9]+)@([-a-z0-9]{3,}\\.[a-z]{2,6})";
    public static final String ANY_RU_WORD = "[А-Яа-яËё]+";

    public static void main(String[] args) {
        splitDemo(Text.content);
        matcherDemo(Text.content);
        emailExtractor(Text.content);
    }

    private static void emailExtractor(String text) {
        Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
        Matcher emailMatcher = emailPattern.matcher(text);
        while (emailMatcher.find()) {
            String email = emailMatcher.group();
            System.out.println(email);
            String login=emailMatcher.group(1);
            String domail=emailMatcher.group(2);
            System.out.printf("login=%s domain=%s%n",login,domail);
        }
    }

    private static void matcherDemo(String data) {
        StringBuilder content = new StringBuilder(data);
        Pattern pattern = Pattern.compile(ANY_RU_WORD);
        Matcher matcher = pattern.matcher(content);
        ArrayList<String> allWords = new ArrayList<>();
        int position=0;
        while (matcher.find(position)){
            String word = matcher.group();
            allWords.add(word);
            if (word.length()>3){
                content.delete(matcher.start(),matcher.end());
                position=matcher.start();
            } else {
                position= matcher.end();
            }
        }
        System.out.println(allWords);
        System.out.println("size="+allWords.size());
        System.out.println(content);
    }

    private static void splitDemo(String content) {
        String[] strings = content.split(NON_RU_CHARS);
        HashSet<String> uniqueWords = new HashSet<>();
        for (String string : strings) {
            uniqueWords.add(string);
            System.out.println(string);
        }
        System.out.println("all "+strings.length);
        System.out.println("unique "+uniqueWords.size());
    }
}
