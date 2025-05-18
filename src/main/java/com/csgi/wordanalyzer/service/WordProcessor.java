package com.csgi.wordanalyzer.service;


import java.util.ArrayList;
import java.util.List;

import com.csgi.wordanalyzer.exception.CSGIException;
import com.csgi.wordanalyzer.rules.WordRule;



/**
 * The {@code WordProcessor} class is responsible for applying a set of word-processing
 * rules (encapsulated as {@link WordRule} implementations) to a given list of words.
 * <p>
 * It supports dynamic addition of rules and orchestrates the application and reporting
 * of each rule in sequence.
 * </p>
 *
 * <h2>Design Patterns Used:</h2>
 * <ul>
 *   <li><b>Strategy Pattern</b>: Each {@link WordRule} implementation defines a strategy
 *       for processing words. The {@code WordProcessor} delegates responsibility to
 *       these strategies, promoting flexibility and extensibility.</li>
 * </ul>
 *
 * <h2>SOLID Principles Applied:</h2>
 * <ul>
 *   <li><b>Single Responsibility Principle (SRP)</b>: This class is solely responsible for
 *       coordinating rule execution, without containing the logic of individual rules.</li>
 *   <li><b>Open/Closed Principle (OCP)</b>: New rules can be added by implementing the
 *       {@link WordRule} interface and registering them using {@link #addRule}, without
 *       modifying the existing code in {@code WordProcessor}.</li>
 * </ul>
 *
 * <p><b>Example usage:</b></p>
 * <pre>{@code
 * WordProcessor processor = new WordProcessor();
 * processor.addRule(new WordStartsWithMValidator());
 * processor.addRule(new LongerThanFiveRule());
 * processor.processWords(Arrays.asList("Monkey", "apple", "Mountain", "Marble"));
 * }</pre>
 *
 * @author Himanshu
 * @version 1.0
 */
public class WordProcessor {
	
	/**
     * The list of registered word-processing rules to be applied.
     */
    private final List<WordRule> rules = new ArrayList<>();
    
    /**
     * Adds a {@link WordRule} implementation to the list of rules.
     *
     * @param rule the word-processing rule to add
     */
    public void addRule(WordRule rule) {
        rules.add(rule);
    }
     
    /**
     * Applies and reports all registered rules on the provided list of words.
     * <p>
     * Each rule's {@link WordRule#apply(List)} method is executed first. After all rules are applied,
     * their {@link WordRule#report()} methods are called.
     * </p>
     *
     * @param words the list of words to process
     * @throws CSGIException if any rule throws an exception during reporting
     */
    public void processWords(List<String> words) throws CSGIException {
        for (WordRule rule : rules) {
            try {
				rule.apply(words);
			} catch (CSGIException e) {
				e.printStackTrace();
			}
        }
        for (WordRule rule : rules) {
            rule.report();
        }
    }
}
