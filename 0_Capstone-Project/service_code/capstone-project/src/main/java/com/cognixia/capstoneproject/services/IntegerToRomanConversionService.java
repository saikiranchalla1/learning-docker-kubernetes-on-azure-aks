package com.cognixia.capstoneproject.services;

import com.cognixia.capstoneproject.exceptions.InputOutOfRangeException;
import com.cognixia.capstoneproject.models.ConversionResult;
import org.springframework.stereotype.Service;

/**
 * Defines a service that converts an integer value to a Roman numeral.
 */
@Service
public class IntegerToRomanConversionService implements ConversionService {

    private static final String[] M = {"", "M", "MM", "MMM"};
    private static final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC",
            "DCC", "DCCC", "CM"};
    private static final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX",
            "LXX", "LXXX", "XC"};
    private static final String[] I = {"", "I", "II", "III", "IV", "V", "VI",
            "VII", "VIII", "IX"};
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 3999;

    /**
     * Converts an returns the Roman numeral for an Integer value. A valid input
     * ranges from 1 to 3999.
     *
     * @param input - number to be converted to Roman
     * @return - returns a ConversionResult that contains the Roman numeral
     * equivalent of the input.
     * @throws InputOutOfRangeException - throws an exception if an invalid
     *                                  integer is passed as an input.
     */
    @Override
    public ConversionResult convertIntegerToRoman(final int input) throws
            InputOutOfRangeException {
        if (input < MIN_RANGE || input > MAX_RANGE) {
            throw new InputOutOfRangeException(
                    String.format("Input:%d is out range. Valid  input range "
                            + "for conversion is 1-3999", input));
        }
        return new ConversionResult(
                M[input / 1000] + C[(input % 1000) / 100] + X[(input % 100) / 10] + I[
                        input % 10]);
    }
}
