package com.rnd.customhandler.validator;

import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.exception.BadRequestException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class QuantityValidator implements ConstraintValidator<QuantityValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(Objects.isNull(value) || ObjectUtils.isEmpty(value.trim()) ||
                !Pattern.matches(Constant.Regex.NUMERIC_PATTERN, value)) {
            throw BadRequestException.builder()
                    .responseCode(Constant.ResponseCode.BAD_REQUEST_CODE)
                    .responseMessage(Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "quantity"))
                    .build();
        }
        return true;
    }
}
