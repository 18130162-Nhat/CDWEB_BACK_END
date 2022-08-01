package com.spring.backend.service;

import com.spring.backend.entity.*;
import com.spring.backend.model.OrderCustomer;
import com.spring.backend.repositories.RepositoriesDetailOrder;
import com.spring.backend.repositories.RepositoriesOrder;
import com.spring.backend.utilities.UtilityDetailOrder;
import com.spring.backend.utilities.UtilityOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    RepositoriesOrder order ;
    @Autowired
    UtilityOrder utilityOrder ;
    @Autowired
    RepositoriesDetailOrder repositoriesDetailOrder ;
    @Autowired
    UtilityDetailOrder detailOrder ;
    @Autowired
    CustomerService service ;
    @Transactional

    // thuc hien 2 thao tac luu vao db do la : luu order va luu detail order
    // Transactional dung de roll back neu 1 trong 2 thao tac xay ra loi trong qua trinh save
    public void order(OrderCustomer orderCustomer){
       Order o = utilityOrder.toEntity(orderCustomer) ;
       Order or = order.save(o) ;
       for(Product p : orderCustomer.getListOrder()){
           DetailOrder detail = detailOrder.toEntity(p,or) ;
           repositoriesDetailOrder.save(detail) ;
       }


    }
    public List<Order> findOrderByCustomer(int id){
        Customer cus = service.findCustomer(id);
       return order.findAllByCustomer(cus);
    }



}
