package com.kither.validator.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ValidationUtil {

    private Validator validator;

    public ValidationUtil(Validator validator) {
        this.validator = validator;
    }

    public <T> List<String> validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> validate = validator.validate(object, groups);
        if (!CollectionUtils.isEmpty(validate)) {
            return validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
