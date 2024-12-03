package com.onebank.taskmaster.consumer.sms.service;

import com.onebank.taskmaster.consumer.sms.model.TaskChangeNotifierRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskChangeNotifierService implements NotifyTaskChange {
    @Override
    public void notifyTaskChange(@NonNull TaskChangeNotifierRequest request) {
      log.warn("Notification was sent");
    }
}
