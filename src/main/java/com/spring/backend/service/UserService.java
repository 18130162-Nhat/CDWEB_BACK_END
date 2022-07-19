package com.spring.backend.service;

import com.spring.backend.repositories.RepositoriesCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    RepositoriesCustomer customer ;

    public boolean login(String email , String pass ){
        if(customer.findCustomerByEmailAndPassAndStatus(email,pass,"ACTIVE")==null) return  false ;
        return  true ;
    }
    public  boolean isExistEmail(String email){
        if(customer.findByEmail(email)==null) return  false ;
        return true ;
    }
}
