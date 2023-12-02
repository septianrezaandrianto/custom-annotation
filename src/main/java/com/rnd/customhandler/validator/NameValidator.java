package com.rnd.customhandler.validator;

import com.rnd.customhandler.constant.Constant;
import com.rnd.customhandler.exception.BadRequestException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<NameValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if(Objects.isNull(value) || ObjectUtils.isEmpty(value.trim()) ||
                !Pattern.matches(Constant.Regex.ALPHANUMERIC_PATTERN, value)) {
            throw BadRequestException.builder()
                    .responseCode(Constant.ResponseCode.BAD_REQUEST_CODE)
                    .responseMessage(Constant.ResponseMessage.INVALID_REQUEST.replace("{value}", "name"))
                    .build();
        }
        return true;
    }
}
