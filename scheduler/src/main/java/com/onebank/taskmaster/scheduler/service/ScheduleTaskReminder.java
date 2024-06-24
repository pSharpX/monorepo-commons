package com.onebank.taskmaster.scheduler.service;

import com.onebank.taskmaster.scheduler.model.CreateTaskReminderRequest;
import lombok.NonNull;

public interface ScheduleTaskReminder {
    void scheduleTaskReminder(@NonNull CreateTaskReminderRequest request);
    void cancelTaskReminder(@NonNull String taskId);
}
