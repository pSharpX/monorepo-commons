package com.onebank.taskmaster.notifier.entity;

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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_preferences")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = {AuditingEntityListener.class})
public class NotificationPreferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userIdentifier;

    @Column(nullable = false)
    private boolean emailEnabled = true;

    @Column(nullable = false)
    private boolean smsEnabled = true;

    @Column(nullable = false)
    private boolean pushEnabled = true;

    @Column(nullable = false)
    private boolean inAppEnabled = true;

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
