package com.dehghan.service;

import com.dehghan.model.ProductEntity;
import com.dehghan.repository.ProductRpository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    private final ProductRpository productRepository;

    public ProductService(ProductRpository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    public void newProduct(ProductEntity product){

        ProductEntity save = new ProductEntity();
        save.setId(product.getId());
        save.setName(product.getName());
        save.setDescription(product.getDescription());
        save.setPrice(product.getPrice());
        save.setQuantity(product.getQuantity());
        save.setTaxRate(product.getTaxRate());

    }

    public ProductEntity updatePrduct(Long id, ProductEntity productEntity){

        Optional<ProductEntity> product = productRepository.findById(id);

        if (product.isPresent()){
            ProductEntity updateProduct = product.get();
            updateProduct.setDescription(productEntity.getDescription());
            updateProduct.setName(productEntity.getName());
            updateProduct.setPrice(productEntity.getPrice());
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
}
