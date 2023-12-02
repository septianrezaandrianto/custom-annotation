package com.rnd.customhandler.validator;

import com.rnd.customhandler.exception.BadRequestException;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuantityValidatorTest {

    private final QuantityValidator quantityValidator = new QuantityValidator();
    private final ConstraintValidatorContext context = null;

    @Test
    @DisplayName("should return testIsValid_ValidQuantity")
    void testIsValid_ValidQuantity() {
        String validQuantity = "1000";
        boolean isValid = quantityValidator.isValid(validQuantity, context);
        assertTrue(isValid);
    }

    @Test
    @DisplayName("should return testIsValid_InvalidQuantity_Null")
    void testIsValid_InvalidQuantity_Null() {
        String inValidQuantity = null;
        assertThrows(BadRequestException.class, () -> quantityValidator.isValid(inValidQuantity, context));
    }

    @Test
    @DisplayName("should return testIsValid_InvalidQuantity_Empty")
    void testIsValid_InvalidQuantity_Empty() {
        String invalidQuantity = "";
        assertThrows(BadRequestException.class, () -> quantityValidator.isValid(invalidQuantity, context));
    }

    @Test
    @DisplayName("should return testIsValid_InvalidQuantity_Whitespace")
    void testIsValid_InvalidQuantity_Whitespace() {
        String invalidQuantity = "   ";
        assertThrows(BadRequestException.class, () -> quantityValidator.isValid(invalidQuantity, context));
    }

    @Test
    @DisplayName("should return testIsValid_InvalidQuantity_NonAlphanumeric")
    void testIsValid_InvalidQuantity_NonAlphanumeric() {
        String invalidQuantity = "1@00";
        assertThrows(BadRequestException.class, () -> quantityValidator.isValid(invalidQuantity, context));
    }
}
