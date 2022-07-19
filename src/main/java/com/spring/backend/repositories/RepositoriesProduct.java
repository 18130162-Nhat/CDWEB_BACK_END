package com.spring.backend.repositories;

import com.spring.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriesProduct extends JpaRepository<Product,Integer> {
}
