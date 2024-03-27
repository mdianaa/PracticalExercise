package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DuplicatedSymbols {

    private static Map<Character, Integer> findDuplicatedSymbols(String str) {
        Map<Character, Integer> duplicatedSymbols = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            duplicatedSymbols.putIfAbsent(str.charAt(i), 0);
            duplicatedSymbols.put(str.charAt(i), duplicatedSymbols.get(str.charAt(i)) + 1);
        }

        // collect only the duplicated values
        duplicatedSymbols = duplicatedSymbols.entrySet()
                .stream()
                .filter(c -> !c.getValue().equals(1))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return duplicatedSymbols;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (findDuplicatedSymbols(input).isEmpty()) {
            System.out.println("No duplicated symbols");
            return;
        }

        for (Map.Entry<Character, Integer> character : findDuplicatedSymbols(input).entrySet()) {
            System.out.println("Duplicated Character: " + character.getKey() + " Count: " + character.getValue());
        }
    }
}
