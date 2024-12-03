package com.onebank.taskmaster.consumer.sms.service;

import com.onebank.taskmaster.consumer.sms.model.TaskChangeNotifierRequest;
import lombok.NonNull;

public interface NotifyTaskChange {
    void notifyTaskChange(@NonNull TaskChangeNotifierRequest request);
}
