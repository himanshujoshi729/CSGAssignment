package com.csgi.wordanalyzer.test;

import org.junit.jupiter.api.Test;
import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.rules.WordStartsWithMValidator;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link WordStartsWithMValidator} rule.
 * <p>
 * This class verifies the functionality that counts how many words in a list
 * start with the letter 'M' or 'm'.
 * </p>
 *
 * <h2>Test Scenarios</h2>
 * <ul>
 *   <li>Counting words that begin with 'M' or 'm' (case-insensitive)</li>
 *   <li>Handling cases where no word starts with 'M'</li>
 * </ul>
 * 
 * @author Himanshu
 * @version 1.0
 */
class WordStartsWithMValidatorTest {
    
	/**
     * Test case to verify the rule correctly counts words starting with 'M' or 'm'.
     *
     * @throws CSGIException if rule application fails
     */
    @Test
    void testCountWordsStartingWithM() throws CSGIException {
        List<String> words = Arrays.asList("Monkey", "apple", "Mountain", "ball", "Marble", "house", "Mango");

        WordStartsWithMValidator rule = new WordStartsWithMValidator();
        rule.apply(words);

        assertEquals(4, rule.getCount()); // Monkey, Mountain, Marble, Mango
    }
    
    /**
     * Test case to verify the rule returns zero when no words start with 'M' or 'm'.
     *
     * @throws CSGIException if rule application fails
     */
    @Test
    void testNoWordsStartingWithM() throws CSGIException {
        List<String> words = Arrays.asList("apple", "banana", "house");

        WordStartsWithMValidator rule = new WordStartsWithMValidator();
        rule.apply(words);

        assertEquals(0, rule.getCount());
    }
}
