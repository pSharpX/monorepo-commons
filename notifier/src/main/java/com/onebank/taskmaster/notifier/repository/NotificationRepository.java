package com.onebank.taskmaster.notifier.repository;

import com.onebank.taskmaster.notifier.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
