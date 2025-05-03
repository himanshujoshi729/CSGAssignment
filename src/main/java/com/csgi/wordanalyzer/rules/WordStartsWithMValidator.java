package com.csgi.wordanalyzer.rules;

import com.csgi.wordanalyzer.exception.CSGIException;

/**
 * Rule implementation to validate if the word starts with the letter 'M' or
 * 'm'.
 */
public class WordStartsWithMValidator implements WordRule {

	

	/**
	 * Tests if the provided word starts with the letter 'M' or 'm'.
	 * 
	 * @param word The word to be checked.
	 * @return true if the word starts with 'M' or 'm', false otherwise.
	 * @throws CSGIException if the word is null or empty.
	 */
	@Override
	public boolean test(String word) throws CSGIException {

        if (word==null)
        {
        	throw new CSGIException("The word cannot be null");
        }
        
        return word.startsWith("M") || word.startsWith("m");
	}


}