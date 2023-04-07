package com.dehghan.repository;

import com.dehghan.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByNameContaining(String keyword);

    List<CustomerEntity> findByOrderIsNull();

}
