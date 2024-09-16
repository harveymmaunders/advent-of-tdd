package org.advent.day1;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfShould {
    @Test
    void have_zero_total_calories_when_created() {
        Elf elf = new Elf();
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
        Elf elf = new Elf();
        elf.addCalories(1000);
        assertThat(elf.getTotalCalories(), equalTo(1000));
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        Elf elf1 = new Elf();
        elf1.addCalories(100);

        Elf elf2 = new Elf();
        elf2.addCalories(50);

        assertThat(elf1.compareTo(elf2), greaterThan(0));
    }

    @Test
    void compare_zero_for_equal_elf() {
        Elf elf1 = new Elf();
        elf1.addCalories(100);

        Elf elf2 = new Elf();
        elf2.addCalories(100);

        assertThat(elf1.compareTo(elf2), equalTo(0));
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        Elf elf1 = new Elf();
        elf1.addCalories(50);

        Elf elf2 = new Elf();
        elf2.addCalories(100);

        assertThat(elf1.compareTo(elf2), lessThan(0));
    }

    @Test
    void test_elf1() {
        Elf elf1 = new Elf();
        Stream.of(1000, 2000, 3000).forEach(elf1::addCalories);
        assertThat(elf1.getTotalCalories(), equalTo(6000));
    }

    @Test
    void test_elf2() {
        Elf elf2 = new Elf();
        elf2.addCalories(4000);
        assertThat(elf2.getTotalCalories(), equalTo(4000));
    }

    @Test
    void test_elf3() {
        Elf elf3 = new Elf();
        Stream.of(5000, 6000).forEach(elf3::addCalories);
        assertThat(elf3.getTotalCalories(), equalTo(11000));
    }

    @Test
    void test_elf4() {
        Elf elf4 = new Elf();
        Stream.of(7000, 8000, 9000).forEach(elf4::addCalories);
        assertThat(elf4.getTotalCalories(), equalTo(24000));
    }

    @Test
    void test_elf5() {
        Elf elf5 = new Elf();
        Stream.of(10000).forEach(elf5::addCalories);
        assertThat(elf5.getTotalCalories(), equalTo(10000));
    }
}
