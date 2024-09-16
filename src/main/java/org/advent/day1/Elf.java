package org.advent.day1;

/**
 * Elf that is assigned calories
 */
public class Elf implements Comparable<Elf> {

    private int totalCalories = 0;

    /**
     * Calories carried by the Elf
     * @return total calories
     */
    public int getTotalCalories() {
        return this.totalCalories;
    }

    public void addCalories(int calories) {
        this.totalCalories += calories;
    }

    @Override
    public int compareTo(Elf arg0) {
        return this.totalCalories - arg0.totalCalories;
    }

}
