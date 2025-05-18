package com.csgi.wordanalyzer.rules;

import java.util.List;
import java.util.stream.Collectors;

import com.csgi.wordanalyzer.exception.CSGIException;


/**
 * {@code LongerThanFiveRule} is a business rule that filters and stores
 * all words from a given list that are longer than 5 characters.
 * <p>
 * This class implements the {@link WordRule} interface and can be plugged
 * into the {@link WordProcessor} to participate in rule-based processing
 * of word lists.
 * </p>
 *
 * 
 * This class is also designed to be testable via {@link #getLongWords()}.
 * 
 * @author Himanshu
 * @version 1.0
 */
public class LongerThanFiveRule implements WordRule {
    
	/**
     * Stores the words that are longer than 5 characters.
     */
    private List<String> longWords;

    
    /**
     * Filters and stores words from the given list that are longer than 5 characters.
     *
     * @param words the list of words to evaluate
     * @throws CSGIException if processing fails
     */
    @Override
    public void apply(List<String> words) throws CSGIException {
        longWords = words.stream()
                         .filter(word -> word.length() > 5)
                         .collect(Collectors.toList());
    }
    
    /**
     * Prints the list of words longer than 5 characters to the standard output.
     */
    @Override
    public void report() {
        System.out.println("Words longer than 5 characters: " + longWords);
    }
    
    /**
     * Returns the list of words that were found to be longer than 5 characters.
     * <p>
     * This method is primarily intended to be used in unit tests.
     * </p>
     *
     * @return a list of words longer than 5 characters
     */
    public List<String> getLongWords() {
        return longWords;
    }
}
