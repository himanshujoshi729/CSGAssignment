**Word Length Checker**

This project is designed to analyze a list of words and apply certain rules for counting and filtering based on the word's length. Specifically, it includes functionality to:
Count words that start with the letter 'M' or 'm'.

Get all words that are longer than 5 characters.

Overview
The program processes words and applies specific rules using a service class called CountWordsService. The service can handle lists of words, read input from a file, and apply different word validation rules such as:

WordStartsWithMValidator: A rule that filters words starting with 'M' or 'm'.

WordLengthRule: A rule that filters words whose length is greater than 5 characters.

Key Features
Word Length Filter: Filters and returns words with a length greater than 5 characters.

Word Starting with M: Counts how many words start with the letter 'M' or 'm'.

Usage
1. Input File
The program reads a file (e.g., input.txt) containing a list of words.

The words in the file are validated to ensure that each word is a valid string consisting of letters only.

2. Word Length Check
The program will count the words with a length greater than 5. For example, given the input:

arduino
Copy
Edit
"Monkey", "apple", "Mountain", "stream", "melon", "Cat", "magnificent", "mirror", "sun", "Moon"
The words longer than 5 characters are:

"Monkey"

"Mountain"

"stream"

"magnificent"

"mirror"

"Moon"

Example Code
java
Copy
Edit
public class CountWordsApp {

    public static void main(String[] args) {
        // Sample word list
        List<String> inputWords = List.of(
                "notification", "Himanshu", "csg", "Netcracker", "Amdocs", "IBM", "Ericsson", "mirror", "sun", "Moon"
        );

        // Initialize the service
        CountWordsService service = new CountWordsService(inputWords);

        // Rule 1: Count words that start with M or m
        long countMWords = service.countWordsMatchingRule(new WordStartsWithMValidator());
        System.out.println("Number of words starting with 'M' or 'm': " + countMWords);

        // Rule 2: Get all words longer than 5 characters
        List<String> longWords = service.getWordsMatchingRule(new WordLengthRule());
        System.out.println("Words longer than 5 characters: " + longWords);
    }
}

**3. Running the Application**
To run the program, follow these steps:

Ensure that the input.txt file exists in the resources folder of your project.

Build and run the Java application using any IDE or command line (mvn clean install or mvn exec:java if using Maven).

The output will display:

The count of words starting with 'M' or 'm'.

The list of words with a length greater than 5.
