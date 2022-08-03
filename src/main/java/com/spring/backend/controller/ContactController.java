package com.spring.backend.controller;

import com.spring.backend.entity.Contact;
import com.spring.backend.entity.Customer;
import com.spring.backend.model.ResponseObject;
import com.spring.backend.repositories.RepositoriesContact;
import com.spring.backend.service.ContactService;
import com.spring.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    RepositoriesContact contactRes;
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/saveContact" , method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> saveContact(@RequestParam("idCus") int idCus,
                                                      @RequestParam("title") String title,
                                                      @RequestParam("content") String content) {
        contactService.saveContact(idCus, title, content);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke", ""));
    }

}
