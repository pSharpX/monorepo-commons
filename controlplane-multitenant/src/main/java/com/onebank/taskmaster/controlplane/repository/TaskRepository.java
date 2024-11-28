package com.onebank.taskmaster.controlplane.repository;

import com.onebank.taskmaster.controlplane.config.OnDatabaseIntegration;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import com.onebank.taskmaster.controlplane.model.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@OnDatabaseIntegration
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByTitle(String title);

    @Query("SELECT c FROM TaskEntity c WHERE (:progressStatus is null or c.progressStatus = :progressStatus) and c.title LIKE %:title%")
    List<TaskEntity> findByProgressStatusAndTitleContainingIgnoreCase(@Nullable TaskStatus progressStatus, @NotNull String title);
}
