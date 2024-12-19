package com.onebank.taskmaster.controlplane.provider;

import com.onebank.taskmaster.controlplane.model.notification.TaskNotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "notification-client", url = "${control-plane.notification.baseUrl}")
public interface NotificationClient {

    @PostMapping(value = "/notifications")
    void send(TaskNotificationRequest request);
}
