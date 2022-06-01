package com.cognixia.capstoneproject.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

/**
 * Defines a model object to hold the result of converting the integer to Roman
 * numeral.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionResult extends ResourceSupport {

    private String result;
}
