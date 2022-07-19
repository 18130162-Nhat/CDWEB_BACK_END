package com.spring.backend.controller;

import com.spring.backend.model.ResponseObject;
import com.spring.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000/" , maxAge = 3600)
@RestController
public class AuthencationController {
    @Autowired
    UserService userService ;
    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> login(@RequestParam("email") String email , @RequestParam("pass") String pass){
        if(userService.login(email,pass)) return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" , "")) ;
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failure" ,"" )
        ) ;
    }
    @RequestMapping(value = "/isExistEmail" , method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> isExistEmail(@RequestParam("email") String email){
        System.out.println(email);
        if(userService.isExistEmail(email)) return  ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" , "")) ;
        return  ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body( new ResponseObject("failure" , "")) ;
    }

}
