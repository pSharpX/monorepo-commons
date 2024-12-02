package com.onebank.taskmaster.notifier.entity;

import com.onebank.taskmaster.notifier.entity.listeners.NotificationCreationListener;
import com.onebank.taskmaster.notifier.model.NotificationStatus;
import com.onebank.taskmaster.notifier.model.NotificationChannel;
import com.onebank.taskmaster.notifier.model.TaskNotificationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = {AuditingEntityListener.class, NotificationCreationListener.class})
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userIdentifier;

    @Length(max = 200)
    @NotNull
    private String title;

    @Length(max = 1000)
    @NotNull
    private String message;

    @NotNull
    private TaskNotificationType notificationType;

    @NotNull
    private NotificationChannel channel = NotificationChannel.EMAIL;

    @NotNull
    private NotificationStatus status = NotificationStatus.CREATED;

    @Column(columnDefinition = "boolean default true", insertable = false)
    private Boolean enabled = true;

    @Column(updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String updatedBy;

    @LastModifiedDate
    private LocalDateTime updateDatetime;
}
