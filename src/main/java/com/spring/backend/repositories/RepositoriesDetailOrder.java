package com.spring.backend.repositories;

import com.spring.backend.entity.DetailOrder;
import com.spring.backend.entity.DetailOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriesDetailOrder extends JpaRepository<DetailOrder, DetailOrderId> {
}
