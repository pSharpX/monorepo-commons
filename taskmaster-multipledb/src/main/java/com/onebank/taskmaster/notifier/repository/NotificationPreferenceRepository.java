package com.onebank.taskmaster.notifier.repository;

import com.onebank.taskmaster.notifier.entity.NotificationPreferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationPreferenceRepository extends JpaRepository<NotificationPreferenceEntity, Long> {
}
