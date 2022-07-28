package com.spring.backend.controller;

import com.spring.backend.model.LoginResponse;
import com.spring.backend.model.ResponseObject;
import com.spring.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
public class AuthencationController {
    @Autowired
    CustomerService userService ;
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> login(@RequestParam("email") String email , @RequestParam("pass") String pass){
        if(userService.login(email,pass)){
            LoginResponse login = new LoginResponse(userService.getCus().getIdCustomer() ,
                    userService.getCus().getFirstName()+" " +userService.getCus().getLastName());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("oke" , login)) ;
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failure" ,"" )
        ) ;
    }
    @RequestMapping(value = "/isExistEmail" , method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> isExistEmail(@RequestParam("email") String email){
        System.out.println(email);
        if(userService.isExistEmail(email)) return  ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" , "")) ;
        return  ResponseEntity.status(HttpStatus.OK)
                .body( new ResponseObject("failure" , "")) ;
    }


    @RequestMapping(value = "/customer/changeProfile" , method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> updateUser(@RequestParam("firstName") String firstName, @RequestParam("email") String email,
                                                         @RequestParam("lastName") String lastName, @RequestParam("phone") String phone){
        System.out.println(firstName);
        System.out.println(email);
        System.out.println(lastName);
        System.out.println(phone);

        return  ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" , "")) ;
    }

//    @RequestMapping(value = "/customer/changePass" , method = RequestMethod.POST)
//    public ResponseEntity<ResponseObject> updatePass(@RequestParam("pass") String pass, @RequestParam("newpass") String newpass,
//                                                     @RequestParam("repeat") String repeat){
//        System.out.println(pass);
//        System.out.println(newpass);
//        System.out.println(repeat);
//
//        return  ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseObject("oke" , "")) ;
//    }


}
