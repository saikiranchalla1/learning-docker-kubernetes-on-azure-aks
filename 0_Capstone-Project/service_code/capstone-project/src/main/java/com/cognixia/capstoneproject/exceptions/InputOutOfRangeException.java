package com.cognixia.capstoneproject.exceptions;

/**
 * Defines a custom-exception when the input to be converted to Roman is out of
 * range.
 */
@SuppressWarnings({"PMD.MissingSerialVersionUID"})
public class InputOutOfRangeException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.  The cause is
     * not initialized, and may subsequently be initialized by a call to {@link
     * #initCause}.
     *
     * @param message the detail message. The detail message is saved for later
     * retrieval by the {@link #getMessage()} method.
     */
    public InputOutOfRangeException(final String message) {
        super(message);
    }
}
