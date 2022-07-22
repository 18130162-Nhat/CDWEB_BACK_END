package com.spring.backend.controller;

import com.spring.backend.model.FormRegister;
import com.spring.backend.model.ResponseObject;
import com.spring.backend.service.CustomerService;
import com.spring.backend.utilities.RenderOTP;
import com.spring.backend.utilities.SendEmail;
import com.spring.backend.utilities.UtilityCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/" , maxAge = 3600)
@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService ;
    @Autowired
    UtilityCustomer utilityCustomer ;
    @Autowired
    RenderOTP renderOTP ;
    @Autowired
    SendEmail sendEmail ;
    @RequestMapping(value = "customer/register" , method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> register(FormRegister form){
        return ResponseEntity.status(HttpStatus.OK).body(
           new ResponseObject("oke" , customerService.saveCustomer(utilityCustomer.toEntity(form)))
        ) ;
    }
    @RequestMapping(value ="/sendOTP" , method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> sendOTP(@RequestParam("email") String email){
        System.out.println(!customerService.isExistEmail(email));
        if(customerService.isExistEmail(email)){
            customerService.updateTimeAndCode(customerService.findByEmail(email),renderOTP.createOTP());
            sendEmail.sendEmail(email,renderOTP.getCode());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject("oke" , "")) ;
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("NOT_EMAIL" , "")) ;
    }
    @RequestMapping(value = "/resetPass", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> resetPassWord(@RequestParam("email") String email , @RequestParam("otp") String otp,
                                                        @RequestParam("pass") String pass){

        if(!customerService.checkTimeSend(email)) return  ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("CODE_TIME_OUT" ,"") ) ;
        if(!customerService.checkCode(otp)) return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("INVALID_OTP","")
        );
        customerService.updatePassWord(pass);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke" ,"")
        );

    }
    @RequestMapping(value = "resetOTP" , method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> resetOTP(@RequestParam("email") String email){
        if(customerService.checkCode(email)) return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("NOT_TIME_OUT" ,""));
        customerService.updateTimeAndCode(customerService.findByEmail(email),renderOTP.createOTP());
        sendEmail.sendEmail(email,renderOTP.getCode());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke",""));
    }

}
