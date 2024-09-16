package org.advent.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;

@ExtendWith(MockitoExtension.class)
public class TestElfCalorieCounterShould {
    @Test
    void bufferedReader_throws_runtime_exception(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenThrow(IOException.class);
        assertThrows(RuntimeException.class, () -> new ElfCalorieCounter(mockReader));
    }

    @Test
    void creates_elf_with_correct_calories(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("1000")
                                .thenReturn("3000")
                                .thenReturn(null);
        ElfCalorieCounter elfCalorieCounter = new ElfCalorieCounter(mockReader);
        int[] expected_response = {4000};
        assertArrayEquals(elfCalorieCounter.maxElfCalories(), expected_response);
    }

    @Test
    void calculates_max_calories(@Mock BufferedReader mockReader) throws IOException {
        when(mockReader.readLine()).thenReturn("1000")
                                .thenReturn("3000")
                                .thenReturn("")
                                .thenReturn("2000")
                                .thenReturn("3000")
                                .thenReturn("")
                                .thenReturn("5000")
                                .thenReturn("5000")
                                .thenReturn(null);
        ElfCalorieCounter elfCalorieCounter = new ElfCalorieCounter(mockReader);

        int[] expected_response = {10000, 5000, 4000};
        assertArrayEquals(elfCalorieCounter.maxElfCalories(), expected_response);
    }
}
