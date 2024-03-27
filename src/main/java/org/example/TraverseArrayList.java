package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TraverseArrayList {

    private static void traverse(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // iterate using while-loop
//        int i = 0;
//        while(i < list.size()) {
//            System.out.println(list.get(i));
//
//            i++;
//        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        traverse(input);
    }
}
