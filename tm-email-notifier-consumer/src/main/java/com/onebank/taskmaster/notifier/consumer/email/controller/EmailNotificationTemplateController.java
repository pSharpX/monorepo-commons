package com.onebank.taskmaster.notifier.consumer.email.controller;

import com.onebank.taskmaster.config.ConditionalOnNotificationEnabled;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications/email/templates")
@RequiredArgsConstructor
@ConditionalOnNotificationEnabled
public class EmailNotificationTemplateController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNotificationTemplate() {
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateNotificationTemplate() {
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publishNotificationTemplate() {
    }
}
