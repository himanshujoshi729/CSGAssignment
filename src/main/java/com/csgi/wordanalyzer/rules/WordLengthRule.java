package com.csgi.wordanalyzer.rules;

import com.csgi.wordanalyzer.exception.CSGIException;

/**
 * Rule implementation to validate if the word length is greater than five characters.
 */
public class WordLengthRule implements WordRule {

    /**
     * Tests if the provided word has more than five characters.
     * 
     * @param word The word to be checked.
     * @return true if the word's length is greater than five, false otherwise.
     * @throws CSGIException if the word is null.
     */
    @Override
    public boolean test(String word) throws CSGIException {
        if (word == null) {
            throw new CSGIException("The word cannot be null.");
        }

        return word.length() > 5;
    }
}