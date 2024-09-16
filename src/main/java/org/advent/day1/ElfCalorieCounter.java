package org.advent.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class ElfCalorieCounter {
    private BufferedReader reader;
    private Collection<Elf> elves = new ArrayList<>();

    public ElfCalorieCounter(BufferedReader reader) {
        this.reader = reader;
        try{
            String line;
            Elf elf = new Elf();
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    elves.add(elf);
                    elf = new Elf();
                } else {
                    elf.addCalories(Integer.parseInt(line));
                }
            }
            elves.add(elf);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file", e);
        }
    }

    public int[] maxElfCalories() {
        return elves.stream()
            .sorted(Comparator.comparing(Elf::getTotalCalories).reversed())
            .limit(3)
            .mapToInt(Elf::getTotalCalories)
            .toArray();
    }
}
