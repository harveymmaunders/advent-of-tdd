package org.advent.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Solution {
    public static void main(String[] args) {
        final String filePath = "src/main/resources/day1-elf-calories.txt";
        try {
            FileReader fileReader = new FileReader(filePath);

            ElfCalorieCounter elfCalorieCounter = new ElfCalorieCounter(new BufferedReader(fileReader));
            int[] calorieCounts = elfCalorieCounter.maxElfCalories();
            int sum = 0;
            for (int i = 0; i < calorieCounts.length; i++) {
                sum += calorieCounts[i];
                System.out.println(calorieCounts[i]);
            }
            System.out.println("Sum of top 3 calories: " + sum);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to read file", e);
        }
    }
}
