package com.spring.backend.controller;


import com.spring.backend.model.ResponseObject;
import com.spring.backend.model.ShopProduct;
import com.spring.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ProductController {
    @Autowired
    ProductService productService ;
    @RequestMapping(value = "/searchAutoComplete" , method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> findNameProduct(@RequestParam("value") String value){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" ,productService.findProductNameContaining(value) ));

    }
    @RequestMapping(value = "/findProductById" , method = RequestMethod.GET)
    public ResponseEntity<ResponseObject> findProductById(@RequestParam("id") String id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" , productService.findProductById(id)));
    }
    @RequestMapping(value = "/findProductByfilter", method = RequestMethod.POST)
    public ResponseEntity<ResponseObject> findProductByFilter( @RequestBody ShopProduct shopProduct){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("oke" , productService.findProductByFilter(shopProduct).getContent())) ;
    }
}
