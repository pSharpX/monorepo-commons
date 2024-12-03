package com.onebank.taskmaster.notifier.consumer.sms.service;

import com.onebank.taskmaster.notifier.consumer.sms.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
