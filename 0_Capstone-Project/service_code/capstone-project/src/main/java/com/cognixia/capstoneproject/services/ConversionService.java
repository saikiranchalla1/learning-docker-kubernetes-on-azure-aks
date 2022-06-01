package com.cognixia.capstoneproject.services;

import com.cognixia.capstoneproject.exceptions.InputOutOfRangeException;
import com.cognixia.capstoneproject.models.ConversionResult;

/**
 * Defines the interface for the Services used by the Controller.
 */
@SuppressWarnings("CheckStyle")
public interface ConversionService {

    /**
     * Method to convert an integer to a Roman numeral.
     *
     * @param input - integer input to be converted.
     * @return - returns an instance of ConversionResult which contains the Roman
     * numeral.
     * @throws InputOutOfRangeException - throws InputOutOfRangeException if the
     *                                  input parameter is not within the supported range.
     */
    ConversionResult convertIntegerToRoman(int input) throws
            InputOutOfRangeException;
}
