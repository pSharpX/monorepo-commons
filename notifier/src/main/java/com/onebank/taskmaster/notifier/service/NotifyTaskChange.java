package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
