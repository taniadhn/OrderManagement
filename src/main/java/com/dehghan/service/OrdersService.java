package com.dehghan.service;

import com.dehghan.model.OrdersEntity;
import com.dehghan.repository.OrdersRpository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {


    private final OrdersRpository orderRpository;

    public OrdersService(OrdersRpository orderRpository) {
        this.orderRpository = orderRpository;

    }

    public List<OrdersEntity> getAllOrders(Optional<Long> customerId){
        if(customerId.isPresent())
            return orderRpository.findByCustomerId(customerId.get());
        return orderRpository.findAll();
    }

    public void newOrder(OrdersEntity order){

        OrdersEntity toSave = new OrdersEntity();
        toSave.setId(order.getId());
        toSave.setDate(order.getDate());
        toSave.setTotalPrice(order.getTotalPrice());
        toSave.setCustomer(order.getCustomer());
         orderRpository.save(toSave);


    }

    public OrdersEntity updateOrder(Long id, OrdersEntity orderEntity){

        Optional<OrdersEntity> order = orderRpository.findById(id);

        if (order.isPresent()){
            OrdersEntity updateOrder = order.get();
            updateOrder.setCustomer(orderEntity.getCustomer());
            updateOrder.setDate(orderEntity.getDate());
            updateOrder.setTotalPrice(orderEntity.getTotalPrice());

            orderRpository.save(updateOrder);
            return  updateOrder;
        }else
            return  null;
    }

    public void deleteOneOrder(Long id){
        orderRpository.deleteById(id);
    }


   public List<OrdersEntity> getOrdersAfterDate(String date) {
        return orderRpository.findOrdersByDateAfter(date);
    }
}
