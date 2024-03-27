package org.example;

import java.util.*;

public class CountWords {

    private static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordsCount = new HashMap<>();

        for (String word : words) {
            wordsCount.putIfAbsent(word, 0);
            wordsCount.put(word, wordsCount.get(word) + 1);
        }

        return wordsCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).toList();


        for (Map.Entry<String, Integer> string : countWords(input).entrySet()) {
            System.out.println("Word: " + string.getKey() + " Count: " + string.getValue());
        }
    }
}