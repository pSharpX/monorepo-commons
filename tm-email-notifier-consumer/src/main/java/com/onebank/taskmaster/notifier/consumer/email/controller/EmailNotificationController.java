package com.onebank.taskmaster.notifier.consumer.email.controller;

import com.onebank.taskmaster.config.ConditionalOnNotificationEnabled;
import com.onebank.taskmaster.notifier.consumer.email.service.sender.EmailSender;
import com.onebank.taskmaster.notifier.model.senders.EmailNotificationMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications/email")
@RequiredArgsConstructor
@ConditionalOnNotificationEnabled
public class EmailNotificationController {
    private final EmailSender emailSender;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void sentNotification(@Valid @RequestBody EmailNotificationMessage request) {
        emailSender.send(request);
    }
}
