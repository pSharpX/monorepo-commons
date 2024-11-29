package com.onebank.taskmaster.controlplane.repository;

import com.onebank.taskmaster.controlplane.entity.TagEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
    Optional<TagEntity> findByName(@NonNull String name);
}
