package com.spring.backend.repositories;

import com.spring.backend.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriesBranch extends JpaRepository<Branch , Integer> {
    
}
