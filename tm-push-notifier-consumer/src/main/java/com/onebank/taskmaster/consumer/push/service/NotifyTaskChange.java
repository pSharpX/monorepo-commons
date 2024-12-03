package com.onebank.taskmaster.consumer.push.service;

import com.onebank.taskmaster.consumer.push.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
