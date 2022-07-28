package com.spring.backend.service;

import com.spring.backend.entity.Customer;
import com.spring.backend.entity.Order;
import com.spring.backend.entity.Product;
import com.spring.backend.model.CustomerProfile;
import com.spring.backend.model.ShopProduct;
import com.spring.backend.repositories.RepositoriesCustomer;
import com.spring.backend.utilities.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    RepositoriesCustomer customer ;
    private Customer cus ;


    public boolean login(String email , String pass ){
        Customer u = customer.findCustomerByEmailAndPassAndStatus(email,pass,"ACTIVE") ;
        if(u==null) return  false ;
        this.cus = u ;
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

    public Customer findCustomer(int idCustomer){
       return customer.findById(idCustomer);
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

    public void updatePassProfile(int idCus, String newpass){
        Customer cus = customer.findById(idCus);
        cus.setPass(newpass);
        customer.save(cus) ;
    }

    public void updateCusProfile(int idCus, String email, String firstName, String lastName, String phone){
        Customer cus = customer.findById(idCus);
            cus.setEmail(email);
            cus.setFirstName(firstName);
            cus.setLastName(lastName);
            cus.setPhone(phone);
            customer.save(cus);
    }

//    public boolean updateProfile1(int idCus, String email, String firstName, String lastName, String phone){
//        List<Customer> list = new ArrayList<Customer>();
//        for (Customer c : list) {
//            if(c.getIdCustomer()==idCus) {
//                c.setEmail(email);
//                c.setFirstName(firstName);
//                c.setLastName(lastName);
//                c.setPhone(phone);
//                customer.save(c);
//                return true;
//            }
//        }
//
//        return false;
//    }

    public CustomerProfile findCustomerByFilter(int id){
        Customer customer1 = customer.findById(id);
        CustomerProfile profile = new CustomerProfile(customer1.getIdCustomer(),
                customer1.getEmail(),customer1.getFirstName(),
                customer1.getLastName(), customer1.getPhone());
        return  profile;
    }
    public Customer getCus(){
        return this.cus ;
    }

    public List<Order> findAllOrder(int idUser){
        Customer cus = customer.findById(idUser) ;
        return  cus.getOrderList() ;

    }
}
