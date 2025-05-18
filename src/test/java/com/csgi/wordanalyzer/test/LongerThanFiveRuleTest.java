package com.csgi.wordanalyzer.test;

import org.junit.jupiter.api.Test;
import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.rules.LongerThanFiveRule;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests for the {@link LongerThanFiveRule} class.
 * <p>
 * This class verifies the functionality of the rule that filters and collects
 * words longer than five characters.
 * </p>
 * 
 * <h2>Test Coverage</h2>
 * <ul>
 *   <li>Correct filtering of words longer than five characters</li>
 *   <li>Behavior when no word exceeds the length threshold</li>
 * </ul>
 * 
 * @author Himanshu
 * @version 1.0
 */
class LongerThanFiveRuleTest {
    
	/**
     * Test case to verify that the rule correctly identifies and collects
     * words that are longer than five characters.
     *
     * @throws CSGIException if an error occurs during rule processing
     */
    @Test
    void testWordsLongerThanFiveCharacters() throws CSGIException {
        List<String> words = Arrays.asList("banana", "apple", "elephant", "mouse", "microscope");

        LongerThanFiveRule rule = new LongerThanFiveRule();
        rule.apply(words);

        List<String> result = rule.getLongWords();
        assertEquals(3, result.size());
        assertTrue(result.contains("banana"));
        assertTrue(result.contains("elephant"));
        assertTrue(result.contains("microscope"));
    }
    
    /**
     * Test case to verify the rule’s behavior when no words exceed five characters.
     * Ensures that the result list is empty.
     *
     * @throws CSGIException if an error occurs during rule processing
     */
    @Test
    void testNoWordsLongerThanFiveCharacters() throws CSGIException {
        List<String> words = Arrays.asList("cat", "dog", "pen");

        LongerThanFiveRule rule = new LongerThanFiveRule();
        rule.apply(words);

        assertTrue(rule.getLongWords().isEmpty());
    }
}
