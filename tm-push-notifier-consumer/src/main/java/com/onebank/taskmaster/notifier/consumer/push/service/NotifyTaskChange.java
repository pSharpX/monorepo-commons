package com.onebank.taskmaster.notifier.consumer.push.service;

import com.onebank.taskmaster.notifier.consumer.push.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
