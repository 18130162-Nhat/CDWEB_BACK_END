package com.spring.backend.service;

import com.spring.backend.entity.Customer;
import com.spring.backend.repositories.RepositoriesCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    RepositoriesCustomer customer ;
    private Customer cus ;

    public boolean login(String email , String pass ){
        if(customer.findCustomerByEmailAndPassAndStatus(email,pass,"ACTIVE")==null) return  false ;
        return  true ;
    }
    public  boolean isExistEmail(String email){
       try{
           if(customer.findByEmail(email)==null) return  false ;
       }catch (Exception e){
           return  false ;
       }
        return true ;
    }
    public Customer saveCustomer(Customer cus){
       return customer.save(cus) ;
    }
    public void updateTimeAndCode(Customer customer , String code){
        customer.setCode(code);
        customer.setTime(System.currentTimeMillis());
        this.customer.save(customer) ;
    }
    public  Customer findByEmail(String email){
        return  customer.findByEmail(email) ;
    }
    public boolean checkTimeSend(String email){
        Customer customer = findByEmail(email) ;
        if(customer==null) return  false ;
        this.cus = customer ;
        long start = System.currentTimeMillis()/1000;
        if((start-(customer.getTime()/1000))>30) return  false ;
        else  return  true  ;
    }
    public boolean checkCode(String code){
        if(this.cus.getCode().equals(code)) return true ;
        return  false ;
    }
    public void updatePassWord(String pass){
        this.cus.setPass(pass);
        customer.save(this.cus) ;
    }
}
