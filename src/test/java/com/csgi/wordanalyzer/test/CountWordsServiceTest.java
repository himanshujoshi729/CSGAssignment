package com.csgi.wordanalyzer.test;

import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.input.InputFileReader;
import com.csgi.wordanalyzer.rules.WordLengthRule;
import com.csgi.wordanalyzer.rules.WordStartsWithMValidator;
import com.csgi.wordanalyzer.service.CountWordsService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CountWordsService class.
 * This class contains tests that validate the functionality of counting words
 * that start with 'M' or 'm', retrieving words longer than five characters,
 * and ensuring null input is handled safely.
 */
class CountWordsServiceTest {

    private final String fileName = "input.txt";  // Ensure this file exists in src/test/resources

    /**
     * Test for counting words that start with 'M' or 'm'.
     * This test ensures that words starting with the letter 'M' or 'm' are correctly counted.
     * 
     * @throws CSGIException If the input file or word rules throw an exception
     * @throws IOException If there's an issue reading the input file
     */
    @Test
    void testCountWordsStartingWithM() throws CSGIException, IOException {
        // Read words from input.txt
        InputFileReader reader = new InputFileReader();
        List<String> inputWords = reader.readLines(fileName);

        // Initialize the service with the read words
        CountWordsService service = new CountWordsService(inputWords);

        // Count words that start with M or m
        long count = service.countWordsMatchingRule(new WordStartsWithMValidator());
        assertTrue(count > 0, "Count of words starting with 'M' or 'm' should be greater than 0");
    }

    /**
     * Test for getting words longer than five characters.
     * This test ensures that only words longer than five characters are returned.
     * It also checks that specific words like "Netcracker" are present and others like "Cat" are not.
     * 
     * @throws CSGIException If the input file or word rules throw an exception
     * @throws IOException If there's an issue reading the input file
     */
    @Test
    void testWordsLongerThanFiveCharacters() throws CSGIException, IOException {
        // Read words from input.txt
        InputFileReader reader = new InputFileReader();
        List<String> inputWords = reader.readLines(fileName);

        // Initialize the service with the read words
        CountWordsService service = new CountWordsService(inputWords);

        // Get all words longer than 5 characters
        List<String> result = service.getWordsMatchingRule(new WordLengthRule());
        assertTrue(result.size() > 0, "There should be words longer than 5 characters");

        // Check specific words
        assertTrue(result.contains("Netcracker")); // Ensure it's in input.txt
        assertFalse(result.contains("Cat")); // Ensure it's not in input.txt
    }

    /**
     * Test for handling null input safely in the CountWordsService constructor.
     * This test ensures that the service does not crash when provided with null input
     * and gracefully returns an empty list.
     */
    @Test
    void testNullSafeConstructor() {
        CountWordsService service = new CountWordsService(null);
        assertEquals(0, service.getAllWords().size(), "Service should handle null input gracefully.");
    }
}
