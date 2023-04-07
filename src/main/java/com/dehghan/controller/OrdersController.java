package com.dehghan.controller;


import com.dehghan.model.OrdersEntity;
import com.dehghan.service.OrdersService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService orderService;

    public OrdersController(OrdersService orderService) {
        this.orderService = orderService;

    }

    @GetMapping()
    public List<OrdersEntity> getAllOrders(@RequestParam Optional<Long> customerId){

        return  orderService.getAllOrders(customerId);
    }

    @PostMapping
    public  void createOrders( @RequestBody OrdersEntity orderEntity){
        orderService.newOrder(orderEntity);
    }

    @PutMapping("/{id}")
    public OrdersEntity updateOrder(@PathVariable Long id, @RequestBody OrdersEntity orderUpdate){

        return orderService.updateOrder(id, orderUpdate);
    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){

        orderService.deleteOneOrder(id);

    }



    @GetMapping("/after-date")
    public List<OrdersEntity> getOrdersAfterDate(@RequestParam("createDate") String date) {
        return orderService.getOrdersAfterDate(date);
    }

}
