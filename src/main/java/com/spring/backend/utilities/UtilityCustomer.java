package com.spring.backend.utilities;

import com.spring.backend.entity.Customer;
import com.spring.backend.model.FormRegister;
import org.springframework.stereotype.Component;

@Component
public class UtilityCustomer {

    public Customer toEntity(FormRegister form){
        Customer customer = new Customer() ;
        customer.setEmail(form.getEmail());
        customer.setFirstName(form.getFirstName());
        customer.setPass(form.getPass());
        customer.setPhone(form.getPhone());
        customer.setLastName(form.getLastName());
        customer.setRole("USER");
        customer.setStatus("ACTIVE");
        return  customer ;

    }
}
