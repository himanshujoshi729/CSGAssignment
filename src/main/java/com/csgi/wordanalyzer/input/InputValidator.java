package com.csgi.wordanalyzer.input;

import java.util.List;
import com.csgi.wordanalyzer.exception.CSGIException;

/**
 * InputValidator class responsible for validating the words read from the input file.
 * <p>
 * This class performs strict validation, meaning if any word is invalid (e.g., null, empty, or contains non-alphabetic characters),
 * the entire file will be considered as failed, and an exception will be thrown.
 * </p>
 * <p>
 * Example of validation includes:
 * <ul>
 *     <li>Null or empty words are considered invalid.</li>
 *     <li>Words containing non-alphabetic characters are considered invalid.</li>
 * </ul>
 * </p>
 * <p>
 * The file processing will be stopped immediately if any invalid word is found.
 * </p>
 * 
 * @author HimanshuJ
 */
public class InputValidator {

    /**
     * Validates the list of words. The validation is strict: if any word is invalid, an exception is thrown.
     * <p>
     * The validation rules are:
     * <ul>
     *     <li>Word cannot be null or empty.</li>
     *     <li>Word must only contain alphabetic characters (a-z, A-Z).</li>
     * </ul>
     * </p>
     *
     * @param words the list of words to be validated.
     * @throws CSGIException if any word is invalid, an exception is thrown with a relevant message.
     */
    public void validateWords(List<String> words) throws CSGIException {
        for (String word : words) {
            if (word == null || word.isEmpty()) {
                throw new CSGIException("Invalid word: word is null or empty.");
            }

            // only letters allowed
            if (!word.matches("[a-zA-Z]+")) {
                throw new CSGIException("Invalid word format: " + word);
            }
        }
    }
}
