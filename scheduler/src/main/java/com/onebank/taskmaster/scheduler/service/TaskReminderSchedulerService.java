package com.onebank.taskmaster.scheduler.service;

import com.onebank.taskmaster.scheduler.model.CreateTaskReminderRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskReminderSchedulerService implements ScheduleTaskReminder {
    @Override
    public void scheduleTaskReminder(@NonNull CreateTaskReminderRequest request) {
        log.warn("Task reminder scheduled successfully");
    }

    @Override
    public void cancelTaskReminder(@NonNull String taskId) {
        log.warn("Task reminder has being cancelled");
    }
}
