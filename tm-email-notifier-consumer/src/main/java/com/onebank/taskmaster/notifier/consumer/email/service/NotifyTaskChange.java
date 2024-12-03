package com.onebank.taskmaster.notifier.consumer.email.service;

import com.onebank.taskmaster.notifier.consumer.email.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
