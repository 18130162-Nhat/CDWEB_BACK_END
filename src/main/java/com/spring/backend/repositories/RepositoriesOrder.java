package com.spring.backend.repositories;

import com.spring.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriesOrder extends JpaRepository<Order,Integer> {


}
