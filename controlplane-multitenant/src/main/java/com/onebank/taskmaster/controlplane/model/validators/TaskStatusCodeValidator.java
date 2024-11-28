package com.onebank.taskmaster.controlplane.model.validators;

import com.onebank.taskmaster.controlplane.model.TaskStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskStatusCodeValidator implements ConstraintValidator<TaskStatusCode, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(value)) {
            log.debug("The value for TaskStatus is null. Skipping validation...");
            return true;
        }

        return TaskStatus.isValid(value);
    }
}
