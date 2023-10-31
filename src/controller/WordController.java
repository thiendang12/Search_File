package controller;

import java.util.List;
import java.util.Scanner;

import model.WordModel;
import view.WordView;

public class WordController {
    
    private WordModel model;
    private WordView view;

    public WordController(WordModel model, WordView view) {
        this.model = model;
        this.view = view;
    }

    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            view.displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    System.out.print("Enter word to count: ");
                    String wordToCount = scanner.nextLine();
                    try {
                        int count = model.countWordInFile(filePath, wordToCount);
                        view.displayWordCount(count);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter folder path: ");
                    String folderPath = scanner.nextLine();
                    System.out.print("Enter word to search: ");
                    String wordToSearch = scanner.nextLine();
                    try {
                        List<String> files = model.getFileNameContainsWordInDirectory(folderPath, wordToSearch);
                        view.displayFiles(files);
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 3);
        scanner.close();
    }
}

