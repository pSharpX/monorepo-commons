package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.config.NotificationTemplateConfig;
import com.onebank.taskmaster.notifier.model.NotificationTemplateDetails;
import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationTemplateService {
    private final NotificationTemplateConfig templateConfig;

    public NotificationTemplateDetails getTemplateDetails(TaskNotificationType notificationType) {
        return this.templateConfig.getTemplates().stream()
                .filter(templateDetails -> templateDetails.getNotificationType().equalsIgnoreCase(notificationType.toString()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Template not found: %s", notificationType)));
    }
}
