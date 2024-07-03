package com.onebank.taskmaster.controlplane.entity;

import com.onebank.taskmaster.controlplane.model.TaskCreationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 200)
    @NotNull
    private String title;
    @Length(max = 800)
    @NotNull
    private String description;
    //private List<String> tags;
    @NotNull
    private Integer weight = 0;
    //@NotNull
    //private TaskCreationStatus status = TaskCreationStatus.PENDING;
}
