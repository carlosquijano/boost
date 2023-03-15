package io.github.cq.boost.domain.repository;

import io.github.cq.boost.domain.entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
}
