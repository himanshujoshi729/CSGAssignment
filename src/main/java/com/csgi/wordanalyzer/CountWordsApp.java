package com.csgi.wordanalyzer;


import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.rules.LongerThanFiveRule;
import com.csgi.wordanalyzer.rules.WordStartsWithMValidator;
import com.csgi.wordanalyzer.service.WordProcessor;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code CountWordsApp} class is the entry point of the application.
 * <p>
 * This application processes a list of words and applies a set of dynamic business rules
 * such as:
 * <ul>
 *     <li>Counting how many words start with the letter 'M' or 'm'</li>
 *     <li>Listing all words longer than 5 characters</li>
 * </ul>
 * </p>
 * <p>
 * The rules are designed to be pluggable via the {@link WordProcessor} class.
 * New rules can be added with minimal changes to this code.
 * </p>
 *
 * @author Himanshu
 * @version 1.0
 */


public class CountWordsApp {

    	public static void main(String[] args) throws CSGIException {
            List<String> words = Arrays.asList(
                    "Monkey", "apple", "Mountain", "ball", "Marble", "house", "Elephant", "Mango"
            );

            WordProcessor processor = new WordProcessor();
            processor.addRule(new WordStartsWithMValidator());
            processor.addRule(new LongerThanFiveRule());
            processor.processWords(words);
        }
}
