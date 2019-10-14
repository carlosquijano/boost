package io.github.cq.boost.repository;

import io.github.cq.boost.entity.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjectRepository extends JpaRepository<ObjectEntity, Long> {
}
