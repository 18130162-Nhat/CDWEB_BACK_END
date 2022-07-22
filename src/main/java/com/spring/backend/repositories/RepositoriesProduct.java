package com.spring.backend.repositories;

import com.spring.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RepositoriesProduct extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {

    public List<Product>  findByNameContainingIgnoreCase(String name);


}
