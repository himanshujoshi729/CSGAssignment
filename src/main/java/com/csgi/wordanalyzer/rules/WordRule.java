package com.csgi.wordanalyzer.rules;

import com.csgi.wordanalyzer.exception.CSGIException;

/**
 * Functional interface representing a rule for validating words.
 * <p>
 * This interface defines a contract for any word validation rule. Implementing classes must define
 * the validation logic within the {@link #test(String)} method, which accepts a word (String) and returns a boolean.
 * </p>
 * <p>
 * The validation can throw a {@link CSGIException} if the word doesn't meet the validation criteria, 
 * allowing for custom error handling within the implementation.
 * </p>
 * <p>
 * As this is a functional interface, it can be used with lambda expressions and method references.
 * </p>
 * 
 * @author HimanshuJ
 * @see CSGIException
 */
@FunctionalInterface
public interface WordRule {

    /**
     * Tests whether the given word satisfies the validation rule.
     * <p>
     * This method should contain the specific validation logic for a word. It returns true if the word is valid
     * according to the rule, and false otherwise. If the word is not valid, a {@link CSGIException} can be thrown
     * to indicate the specific error condition.
     * </p>
     * 
     * @param word the word to be validated
     * @return true if the word satisfies the rule, false otherwise
     * @throws CSGIException if the word does not meet the validation criteria
     */
    boolean test(String word) throws CSGIException;
}
