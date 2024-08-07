package com.onebank.taskmaster.controlplane.repository;

import com.onebank.taskmaster.controlplane.config.ConditionalOnDatabaseEnabled;
import com.onebank.taskmaster.controlplane.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ConditionalOnDatabaseEnabled
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByTitle(String title);
}
