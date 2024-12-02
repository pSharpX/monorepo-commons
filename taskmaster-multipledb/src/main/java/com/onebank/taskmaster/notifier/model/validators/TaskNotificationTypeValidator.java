package com.onebank.taskmaster.notifier.model.validators;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskNotificationTypeValidator implements ConstraintValidator<TaskNotificationTypeCode, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(Objects.isNull(value)) {
            log.debug("The value for TaskNotificationType is null. Skipping validation...");
            return true;
        }

        return TaskNotificationType.isValid(value);
    }
}
