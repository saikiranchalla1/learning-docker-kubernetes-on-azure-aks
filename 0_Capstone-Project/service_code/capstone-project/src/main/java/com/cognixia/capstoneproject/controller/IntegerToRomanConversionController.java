package com.cognixia.capstoneproject.controller;

import com.cognixia.capstoneproject.exceptions.InputOutOfRangeException;
import com.cognixia.capstoneproject.models.ConversionResult;
import com.cognixia.capstoneproject.services.ConversionService;
import io.micrometer.core.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Defines a Rest controller that defines methods to convert Integers to Roman
 * numerals.
 */
@RestController
@Slf4j
@AllArgsConstructor
@SuppressWarnings({"checkstyle:magicnumber",
        "PMD.UnnecessaryAnnotationValueElement"})
@RequestMapping(path = "/", produces = "application/json")
public class IntegerToRomanConversionController {

    /**
     * An instance of ConversionService injected as {@link
     * com.cognixia.capstoneproject.services.IntegerToRomanConversionService } at runtime.
     */
    private ConversionService conversionService;


    /**
     * Defines a GET mapping that accepts an integer value as a query (request)
     * parameter and returns it's equivalent Roman Numeral
     * (https://en.wikipedia.org/wiki/Roman_numerals). In addition, this method
     * also checks for the Scope on the incoming request's Authorization header.
     *
     * @param query - Query param containing the integer value that is to be
     * converted.
     * @return - Returns an instance of {@link ConversionResult} formatted as JSON
     * that also contains a Self-link defined by the HATEOAS Specification
     * (https://restfulapi.net/hateoas/).
     * @throws InputOutOfRangeException - Throws an Exception if the query param
     * is out of range.
     */
    @GetMapping(produces = "application/json;charset=UTF-8", value = "{query}")
    @ResponseBody
    @ApiOperation(value = "", authorizations = {
            @Authorization(value = "Authorization")})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ConversionResult.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden")})
    public ConversionResult convertIntegerToRoman(@PathVariable Integer query)
            throws
            InputOutOfRangeException {
        ConversionResult result;
        try {
            log.info(String
                    .format("Request received to convert %d to Roman numeral", query));
            result = conversionService.convertIntegerToRoman(Integer.valueOf(query));
            result.add(linkTo(methodOn(IntegerToRomanConversionController.class)
                    .convertIntegerToRoman(query)).withSelfRel());
            log.info("Request processed successfully. Return result to client");
        } catch (InputOutOfRangeException e) {
            log
                    .error(
                            "Exception occurred when converting to Roman: " + e.getMessage());
            throw e;
        }
        return result;
    }
}
