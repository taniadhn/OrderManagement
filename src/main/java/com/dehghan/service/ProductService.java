package com.dehghan.service;

import com.dehghan.model.ProductEntity;
import com.dehghan.model.UserEntity;
import com.dehghan.repository.ProductRpository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    private final ProductRpository productRepository;
    private final UserService userService;

    public ProductService(ProductRpository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public void newProduct(ProductEntity product){

        ProductEntity toSave = new ProductEntity();
        toSave.setId(product.getId());
        toSave.setName(product.getName());
        toSave.setDescription(product.getDescription());
        toSave.setProductPrice(product.getProductPrice());
        toSave.setQuantity(product.getQuantity());
        toSave.setTaxRate(product.getTaxRate());
         productRepository.save(toSave);


    }

    public ProductEntity updatePrduct(Long id, ProductEntity productEntity){

        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isPresent()){
            ProductEntity updateProduct = product.get();
            updateProduct.setDescription(productEntity.getDescription());
            updateProduct.setName(productEntity.getName());
            updateProduct.setProductPrice(productEntity.getProductPrice());
            updateProduct.setQuantity(productEntity.getQuantity());
            updateProduct.setTaxRate(productEntity.getTaxRate());

            productRepository.save(updateProduct);
            return  updateProduct;
        }else
            return  null;
    }

    public void deleteOneProduct(Long id){
        productRepository.deleteById(id);
    }

    public double calculateTax( ProductEntity productEntity) {
        double productPrice =productEntity.getProductPrice();
        double taxRate  = productEntity.getTaxRate();
        double taxAmount = productPrice * taxRate;
        double totalPrice = productPrice + taxAmount;
        //double taxAmount = productPrice * taxRate;
       // double totalPrice = productPrice + taxAmount;
        return totalPrice;
    }

}
