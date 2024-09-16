package org.advent.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ElfReaderSpike {
    public static void main(String[] args) {
        final String filePath = "src/main/resources/day1-elf-calories.txt";

        System.out.println("Running ElfSpike");
        
        Collection<Elf> elves = new ArrayList<>();
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
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
}
