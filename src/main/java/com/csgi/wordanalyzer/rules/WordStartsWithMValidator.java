package com.csgi.wordanalyzer.rules;

import java.util.List;
import com.csgi.wordanalyzer.exception.CSGIException;


/**
 * {@code WordStartsWithMValidator} is a rule that counts how many words
 * in a given list start with the letter 'M' or 'm'.
 * <p>
 * This rule implements the {@link WordRule} interface and is intended
 * to be used with a rule engine such as {@code WordProcessor} to
 * dynamically evaluate word-based business rules.
 * </p>
 *
 * @author Himanshu
 * @version 1.0
 */
public class WordStartsWithMValidator implements WordRule {
	
	/**
     * Stores the count of words that start with 'M' or 'm'.
     */
    private long count;
    
    /**
     * Counts how many words in the input list start with the letter 'M' or 'm'.
     *
     * @param words the list of words to evaluate
     * @throws CSGIException if an error occurs during processing
     */
    @Override
    public void apply(List<String> words) throws CSGIException {
        count = words.stream()
                     .filter(word -> word.toLowerCase().startsWith("m"))
                     .count();
    }
    
    /**
     * Prints the result of the rule evaluation: the number of words
     * starting with 'M' or 'm'.
     *
     * @throws CSGIException if an error occurs during reporting
     */
    @Override
    public void report() throws CSGIException {
        System.out.println("Number of words starting with M/m: " + count);
    }

    /**
     * Returns the count of words that start with 'M' or 'm'.
     * <p>This method is primarily used in unit tests.</p>
     *
     * @return the count of matching words
     */
    public long getCount() {
        return count;
    }
}