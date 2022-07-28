package com.spring.backend.utilities;

import com.spring.backend.entity.DetailOrder;
import com.spring.backend.entity.DetailOrderId;
import com.spring.backend.entity.Order;
import com.spring.backend.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class UtilityDetailOrder {

    public DetailOrder toEntity(Product  p , Order order){
        DetailOrder detailOrder = new DetailOrder() ;
        DetailOrderId detailOrderId = new DetailOrderId();
        detailOrderId.setOrderId(order.getIdOrder());
        detailOrderId.setProductId(p.getIdProduct());
        detailOrder.setId(detailOrderId);
        detailOrder.setOrder(order);
        detailOrder.setProduct(p);
        detailOrder.setQuantity(p.getQuantity());
        return detailOrder ;
    }
}
