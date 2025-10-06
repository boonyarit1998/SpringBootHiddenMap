package com.api.hiddenMap.repository;

import com.api.hiddenMap.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepositry extends JpaRepository<ReviewEntity,Long> {
}
