package com.onebank.taskmaster.consumer.service;

import com.onebank.taskmaster.consumer.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
