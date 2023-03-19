package com.dehghan.controller;


import com.dehghan.model.ProductEntity;
import com.dehghan.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


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

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity productUpdate){

        return productService.updatePrduct(id, productUpdate);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteOneProduct(id);

    }
        @PostMapping("/calculateTax/{id}")
        public double calculateProductPrice( @RequestBody ProductEntity productEntity) {
         /***  double productPrice =productEntity.getProductPrice();
           double taxRate  = productEntity.getTaxRate();
            double taxAmount = productPrice * taxRate;
            double totalPrice = productPrice + taxAmount;
            return totalPrice;**/
         return  productService.calculateTax(productEntity);
        }


}
