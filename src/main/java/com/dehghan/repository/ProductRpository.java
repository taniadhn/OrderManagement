package com.dehghan.repository;

import com.dehghan.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRpository extends JpaRepository<ProductEntity, Long> {

}
