package com.spring.backend.service;

import com.spring.backend.entity.*;
import com.spring.backend.repositories.RepositoriesContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    RepositoriesContact contactRes;
    @Autowired
    CustomerService service;
    public Contact saveContact(int idCus, String title, String content){
        Customer cus = service.findCustomer(idCus);
        Contact contact = new Contact(title, content, cus);
        return contactRes.save(contact) ;
    }
}
