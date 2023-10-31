package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordModel {
    public int countWordInFile(String fileSource, String word) throws Exception {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileSource))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equals(word)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            throw new Exception("Error reading the file: " + e.getMessage());
        }
        return count;
    }

    public List<String> getFileNameContainsWordInDirectory(String source, String word) throws Exception {
        List<String> foundFiles = new ArrayList<>();
        File directory = new File(source);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains(word)) {
                                foundFiles.add(file.getName());
                                break;  // Stop searching this file after finding a match
                            }
                        }
                    } catch (IOException e) {
                        throw new Exception("Error reading file " + file.getName() + ": " + e.getMessage());
                    }
                }
            }
        } else {
            throw new Exception("Invalid directory path");
        }
        return foundFiles;
    }
}

