package com.example.wordcounteroldsch;

public class TextMetricsCounter {

    public static int getWordsCount(String text) {

        if (text == null || text.trim().isEmpty()) {
            return 0;
        }


        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    public static int getCharsCount(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        return text.length();
    }
}

