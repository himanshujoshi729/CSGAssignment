package com.csgi.wordanalyzer.rules;

import java.util.List;

import com.csgi.wordanalyzer.exception.CSGIException;

/**
 * {@code WordRule} is a contract for implementing business rules that operate
 * on a list of words.
 * <p>
 * Implementations of this interface should define logic for applying a specific rule
 * to a list of words via the {@link #apply(List)} method, and provide output or
 * reporting logic via the {@link #report()} method.
 * </p>
 * <p>
 * This design allows multiple rules to be composed and applied dynamically, supporting
 * scalability and maintainability of rule-based word processing applications.
 * </p>
 *
 * <p><b>Typical usage:</b></p>
 * <pre>{@code
 * WordRule rule = new WordStartsWithMValidator();
 * rule.apply(words);
 * rule.report();
 * }</pre>
 *
 * @author Himanshu
 * @version 1.0
 */
public interface WordRule {
    
	 /**
     * Applies the rule to the given list of words.
     *
     * @param words the list of words to evaluate
     * @throws CSGIException if rule processing encounters an error
     */
    void apply(List<String> words) throws CSGIException;
    
    /**
     * Prints or logs the result of the rule evaluation.
     *
     * @throws CSGIException if reporting fails
     */
	void report() throws CSGIException;
}
