package com.csgi.wordanalyzer.service;

import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.rules.WordRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountWordsService {

    private final List<String> words;

    public CountWordsService(List<String> words) {
        this.words = Objects.requireNonNullElse(words, new ArrayList<>());
    }

    /**
     * Count how many words match the given rule.
     *
     * @param rule the rule to apply
     * @return number of matching words
     */
    public long countWordsMatchingRule(WordRule rule) {
        return words.stream()
                .filter(t -> {
					try {
						return rule.test(t);
					} catch (CSGIException e) {
						e.printStackTrace();
					}
					return false;
				})
                .count();
    }

    /**
     * Returns all words that match the given rule.
     *
     * @param rule the rule to apply
     * @return list of matching words
     */
    public List<String> getWordsMatchingRule(WordRule rule) {
        return words.stream()
                .filter(t -> {
					try {
						return rule.test(t);
					} catch (CSGIException e) {
						e.printStackTrace();
					}
					return false;
				})
                .toList();
    }

    /**
     * Returns the full list of words being analyzed.
     *
     * @return list of input words
     */
    public List<String> getAllWords() {
        return new ArrayList<>(words);
    }
}
