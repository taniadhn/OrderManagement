package com.dehghan.service;

import com.dehghan.model.CustomerEntity;
import com.dehghan.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public List<CustomerEntity> getAllCustomer() {

        return customerRepository.findAll();

    }

    public CustomerEntity saveOneCustomer(CustomerEntity newCustomer) {
        return customerRepository.save(newCustomer);
    }


    public CustomerEntity updateOneCustomer(Long id, CustomerEntity newCustomer) {


        Optional<CustomerEntity> customer = customerRepository.findById(id);

        if (customer.isPresent()) {

            CustomerEntity foundCustomer = customer.get();
            foundCustomer.setAge(newCustomer.getAge());
            foundCustomer.setName(newCustomer.getName());
            foundCustomer.setOrder(newCustomer.getOrder());
            return customerRepository.save(foundCustomer);
        } else
            return null;
    }


    public void deleteById(Long customerId) {

        customerRepository.deleteById(customerId);
    }

    public List<Map<String, Object>> getCustomersWithOrders(String keyword) {
        List<CustomerEntity> customers = customerRepository.findByNameContaining(keyword);
        List<Map<String, Object>> result = new ArrayList<>();

        for (CustomerEntity customer : customers) {
            Map<String, Object> item = new HashMap<>();

            item.put("id", customer.getId());
            item.put("name", customer.getName());
            item.put("order", customer.getOrder());
            item.put("age", customer.getAge());
            result.add(item);
        }

        return result;
    }

    public List<CustomerEntity> getCustomersWithoutOrders() {
        return customerRepository.findByOrderIsNull();
    }
}