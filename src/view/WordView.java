package view;

import java.util.List;

public class WordView {
     public void displayMenu() {
        System.out.println("============ Word Program =========");
        System.out.println("1. Count Word In File");
        System.out.println("2. Find File By Word");
        System.out.println("3. Exit");
    }

    public void displayWordCount(int count) {
        System.out.println("Number of occurrences: " + count);
    }

    public void displayFiles(List<String> files) {
        if (files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Found files:");
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}

