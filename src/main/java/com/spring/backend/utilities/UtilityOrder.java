package com.spring.backend.utilities;

import com.spring.backend.entity.Customer;
import com.spring.backend.entity.Order;
import com.spring.backend.model.OrderCustomer;
import com.spring.backend.repositories.RepositoriesCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class UtilityOrder {
    @Autowired
    RepositoriesCustomer customer ;
    public Order toEntity(OrderCustomer order){
        Order or = new Order() ;
        or.setPhone(order.getPhone());
        or.setCompany(order.getCompany());
        or.setTimestamp(new Date());
        or.setNote(order.getNote());
        or.setStatus("NEW");
        or.setPriceOrder(order.getPriceOrder());
        Customer cus = customer.findById(order.getIdCus()).get();
        or.setCustomer(cus);
        or.setAddress(order.getAddress());

        return  or ;

    }
}
