package com.spring.backend.repositories;

import com.spring.backend.entity.Customer;
import com.spring.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriesOrder extends JpaRepository<Order,Integer> {

    public List<Order> findAllByCustomer(Customer customer) ;
}
