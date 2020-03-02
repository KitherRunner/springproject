package com.kither.validator.validation;

import com.kither.validator.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserValidator {

    @Resource
    private Validator validator;

    public String validate(User user) {
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        if (!CollectionUtils.isEmpty(validate)) {
            return validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
        }
        return "";
    }
}
