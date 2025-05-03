package com.csgi.wordanalyzer.exception;
/**
 * Custom exception class for defining custom exceptions
 * @author himanshuj
 *
 */
public class CSGIException extends Exception {

	/**
     * Default constructor for the custom exception.
     */
    public CSGIException() {
        super();
    }

    /**
     * Constructor with a custom error message.
     *
     * @param message Error message describing the exception.
     */
    public CSGIException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom error message and cause.
     *
     * @param message Error message describing the exception.
     * @param cause The cause of the exception.
     */
    public CSGIException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with cause.
     *
     * @param cause The cause of the exception.
     */
    public CSGIException(Throwable cause) {
        super(cause);
    }

}