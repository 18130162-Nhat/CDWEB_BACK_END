package com.spring.backend.repositories;

import com.spring.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoriesCustomer extends JpaRepository<Customer , Integer> {

    public Customer findCustomerByEmailAndPassAndStatus(String email , String pass , String status) ;
    public Customer findByEmail(String email) ;
}
