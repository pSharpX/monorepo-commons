package com.onebank.taskmaster.controlplane.entity;

import com.onebank.taskmaster.controlplane.model.TaskCreationStatus;
import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TaskEntity {
    private Long id;
    private String title;
    private String description;
    private List<String> tags;
    private Integer weight = 0;
    private TaskCreationStatus status = TaskCreationStatus.PENDING;
}
