package com.csgi.wordanalyzer.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import com.csgi.wordanalyzer.exception.CSGIException;

/**
 * InputFileReader class is responsible for reading the contents of a text file from the resources directory.
 * <p>
 * This class ensures that only files with a ".txt" extension are processed and provides a method
 * to read the file line by line, trimming whitespace and filtering out empty lines.
 * </p>
 * <p>
 * If the file is not found, an exception is thrown. Additionally, if the file does not have a ".txt" extension,
 * an exception will also be thrown, ensuring strict validation for file types.
 * </p>
 * 
 * @author HimanshuJ
 */
public class InputFileReader {

    /**
     * Reads lines from a specified input file in the resources directory.
     * <p>
     * This method validates the file extension to ensure it is a ".txt" file. It reads the file line by line, trims whitespace,
     * and filters out any empty lines. The valid lines are then collected into a list and returned.
     * </p>
     * <p>
     * If the file is not found, or if the file extension is not ".txt", a {@link CSGIException} will be thrown.
     * </p>
     * 
     * @param fileName the name of the file to be read from the resources directory.
     * @return a list of non-empty lines from the input file.
     * @throws CSGIException if the file does not have a ".txt" extension or is not found.
     * @throws IOException if there is an error reading the file.
     */
    public List<String> readLines(String fileName) throws CSGIException, IOException {
        // Validate the file extension
        if (fileName == null || !fileName.toLowerCase().endsWith(".txt")) {
            throw new CSGIException("Only .txt files are supported: " + fileName);
        }

        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new CSGIException("File not found: " + fileName);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                return reader.lines()
                             .map(String::trim) // Trim whitespace from each line
                             .filter(line -> !line.isEmpty()) // Filter out empty lines
                             .collect(Collectors.toList()); // Collect the non-empty lines into a list
            }
        }
    }
}
