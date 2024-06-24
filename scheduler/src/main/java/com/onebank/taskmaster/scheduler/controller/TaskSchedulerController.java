package com.onebank.taskmaster.scheduler.controller;

import com.onebank.taskmaster.scheduler.model.CreateTaskReminderRequest;
import com.onebank.taskmaster.scheduler.service.ScheduleTaskReminder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-schedulers")
@RequiredArgsConstructor
public class TaskSchedulerController {

    private final ScheduleTaskReminder scheduleTaskReminder;

    @PostMapping("/reminders")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void scheduleTaskReminder(@Valid @RequestBody CreateTaskReminderRequest request) {
        scheduleTaskReminder.scheduleTaskReminder(request);
    }

    @DeleteMapping("/reminders/{taskId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void cancelTaskReminder(@PathVariable String taskId) {
        scheduleTaskReminder.cancelTaskReminder(taskId);
    }

}
