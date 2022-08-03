package com.spring.backend.repositories;

import com.spring.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoriesContact extends JpaRepository<Contact, Integer> {
}
