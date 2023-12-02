package com.rnd.customhandler.validator;

import com.rnd.customhandler.exception.BadRequestException;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameValidatorTest {

    private final NameValidator nameValidator = new NameValidator();
    private final ConstraintValidatorContext context = null;

    @Test
    @DisplayName("should return testIsValid_ValidName")
    void testIsValid_ValidName() {
        String validName = "Kecap Botol";
        boolean isValid = nameValidator.isValid(validName, context);
        assertTrue(isValid);
    }

    @Test
    @DisplayName("should return testIsValid_InvalidName_Null")
    void testIsValid_InvalidName_Null() {
        String invalidName = null;
        assertThrows(BadRequestException.class, () -> nameValidator.isValid(invalidName, context));
    }

    @Test
    @DisplayName("should return testIsValid_InvalidName_Empty")
    void testIsValid_InvalidName_Empty() {
        String invalidName = "";
        assertThrows(BadRequestException.class, () -> nameValidator.isValid(invalidName, context));
    }

    @Test
    @DisplayName("should return testIsValid_InvalidName_Whitespace")
    void testIsValid_InvalidName_Whitespace() {
        String invalidName = "   ";
        assertThrows(BadRequestException.class, () -> nameValidator.isValid(invalidName, context));
    }

    @Test
    @DisplayName("should return testIsValid_InvalidName_NonAlphanumeric")
    void testIsValid_InvalidName_NonAlphanumeric() {
        String invalidName = "Kec@p Botol";
        assertThrows(BadRequestException.class, () -> nameValidator.isValid(invalidName, context));
    }
}
