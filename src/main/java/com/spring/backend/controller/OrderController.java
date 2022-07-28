package com.spring.backend.controller;

import com.spring.backend.model.OrderCustomer;
import com.spring.backend.model.ResponseObject;
import com.spring.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
public class OrderController {
    @Autowired
    OrderService orderService ;

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> order(@RequestBody OrderCustomer orderCustomer){
        orderService.order(orderCustomer);
       return ResponseEntity.status(HttpStatus.OK)
               .body(new ResponseObject("oke" , "")) ;
    }
}
