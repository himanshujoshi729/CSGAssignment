package com.csgi.wordanalyzer;

import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.input.InputFileReader;
import com.csgi.wordanalyzer.input.InputValidator;
import com.csgi.wordanalyzer.rules.WordLengthRule;
import com.csgi.wordanalyzer.rules.WordStartsWithMValidator;
import com.csgi.wordanalyzer.service.CountWordsService;

import java.io.IOException;
import java.util.List;

public class CountWordsApp {

    public static void main(String[] args) throws CSGIException {
        try {
            // Step 1: Read input file
            InputFileReader reader = new InputFileReader();
            List<String> inputWords = null;
			try {
				inputWords = reader.readLines("input.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

            // Step 2: Validate input words
            InputValidator validator = new InputValidator();
            validator.validateWords(inputWords);

            // Step 3: Use the service with the validated words
            CountWordsService service = new CountWordsService(inputWords);

            // Rule 1: Count words that start with M or m
            long countMWords = service.countWordsMatchingRule(new WordStartsWithMValidator());
            System.out.println("Number of words starting with 'M' or 'm': " + countMWords);

            // Rule 2: Get all words longer than 5 characters
            List<String> longWords = service.getWordsMatchingRule(new WordLengthRule());
            System.out.println("Words longer than 5 characters: " + longWords);

        } catch (CSGIException e) {
            throw new CSGIException("Error occurred: " + e.getMessage());
        }
    }
}
