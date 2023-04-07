package com.dehghan.controller;

import com.dehghan.model.CustomerEntity;
import com.dehghan.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController( CustomerService customerService) {
        this.customerService = customerService;


    }

    @GetMapping
    public List<CustomerEntity> getAllCustomers(){
        return customerService.getAllCustomer();

    }

    @PostMapping
    public CustomerEntity createCustomer(@RequestBody CustomerEntity newCustomer){
        return customerService.saveOneCustomer(newCustomer);
    }

    @PutMapping("/{customerId}")
    public CustomerEntity updateOneUser(@PathVariable Long customerId, @RequestBody CustomerEntity newCustomer){


        return customerService.updateOneCustomer(customerId, newCustomer);

    }

    @DeleteMapping("/{customerId}")
    //Sadece Id'sını aldığı kişiyi silecek
    public void deleteOneCustomer(@PathVariable Long customerId){

        customerService.deleteById(customerId);
    }

    @GetMapping("/search")
    public List<Map<String, Object>> searchCustomers(@RequestParam String keyword) {
        return customerService.getCustomersWithOrders(keyword);
    }

    @GetMapping("/without-orders")
    public List<CustomerEntity> getCustomersWithoutOrders() {
        return customerService.getCustomersWithoutOrders();
    }
}
