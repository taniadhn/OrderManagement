package com.dehghan.controller;


import com.dehghan.model.ProductEntity;
import com.dehghan.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductEntity> getAllProducts(){//@RequestParam Optional<Long> userId){

        return  productService.getAllProducts();
    }

    @PostMapping
    public  void createProduct( @RequestBody ProductEntity productEntity){
        productService.newProduct(productEntity);
    }

    @PutMapping
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity productUpdate){

        return productService.updatePrduct(id, productUpdate);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteOneProduct(id);

    }
}
