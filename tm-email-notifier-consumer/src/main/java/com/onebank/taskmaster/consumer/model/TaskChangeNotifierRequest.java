package com.onebank.taskmaster.consumer.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskChangeNotifierRequest {
    @NotNull
    private Long taskId;
    private TaskChangeNotificationType notificationType = TaskChangeNotificationType.CREATED;
}
