package com.dehghan.repository;

import com.dehghan.model.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OrdersRpository extends JpaRepository<OrdersEntity, Long> {
    List<OrdersEntity> findByCustomerId(Long aLong);

    List<OrdersEntity> findOrdersByDateAfter(String date);
}
