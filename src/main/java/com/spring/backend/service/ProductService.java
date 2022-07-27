package com.spring.backend.service;
import com.spring.backend.entity.Product;
import com.spring.backend.model.ResponseShopProduct;
import com.spring.backend.model.ShopProduct;
import com.spring.backend.repositories.RepositoriesProduct;
import com.spring.backend.utilities.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    RepositoriesProduct repositoriesProduct ;
    public List<Product> findProductNameContaining(String name){

    return  repositoriesProduct.findByNameContainingIgnoreCase(name);
}
        public ArrayList<Object> findProductById(String id){
        ArrayList<Object> list = new ArrayList<>() ;
        Product product  = repositoriesProduct.findById(Integer.parseInt(id)).get();
        list.add(product);
        list.add(product.getBranch());
        list.add(product.getListImage());
        return  list;
        }
        public Page<Product> findProductByFilter(ShopProduct shopProduct){
            Specification productSpecification = new ProductSpecification(shopProduct.getList().get(4)) ;
            Pageable pageable =  PageRequest.of(shopProduct.getPage()-1, shopProduct.getItemProduct(),Sort.by(shopProduct.getSort().equals("DES")?Sort.Direction.DESC:Sort.Direction.ASC,"price"));
            for(int i=0 ; i<shopProduct.getList().size()-1;i++){
               if(!shopProduct.getList().get(i).getValue().isBlank()) {
                   productSpecification =  Specification.where(productSpecification).and(new ProductSpecification(shopProduct.getList().get(i)));
               }
            }
    return  repositoriesProduct.findAll(productSpecification,  pageable) ;
        }
        public int productFiltered (ShopProduct shopProduct){
            Specification productSpecification = new ProductSpecification(shopProduct.getList().get(4)) ;
            for(int i=0 ; i<shopProduct.getList().size()-1;i++){
                if(!shopProduct.getList().get(i).getValue().isBlank()) {
                    productSpecification =  Specification.where(productSpecification).and(new ProductSpecification(shopProduct.getList().get(i)));
                }
            }
        return repositoriesProduct.findAll(productSpecification).size() ;
        }
        public ResponseShopProduct findProduct(ShopProduct shopProduct){
            ResponseShopProduct res = new ResponseShopProduct(shopProduct.getItemProduct(),productFiltered(shopProduct)
                    ,shopProduct.getPage(),  findProductByFilter(shopProduct).getContent());
            return  res ;
        }
}
