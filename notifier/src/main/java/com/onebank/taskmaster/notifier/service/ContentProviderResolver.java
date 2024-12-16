package com.onebank.taskmaster.notifier.service;

import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import com.onebank.taskmaster.notifier.service.providers.MessageContentProvider;
import lombok.NonNull;

@SuppressWarnings("rawtypes")
public interface ContentProviderResolver {
    MessageContentProvider resolve(@NonNull TaskNotificationType type);
}
