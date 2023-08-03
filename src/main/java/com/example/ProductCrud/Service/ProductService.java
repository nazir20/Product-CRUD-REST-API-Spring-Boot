package com.example.ProductCrud.Service;

import com.example.ProductCrud.Entity.Product;
import com.example.ProductCrud.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*  GET Requests */
    public Product saveNewProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveNewProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    /* DELETE Requests */
    public String deleteProductById(int id){
        productRepository.deleteById(id);
        return "Product with id of " + id + " deleted successfully!";
    }


    /* PUT Requests */
    public Product updateProductById(Product product){

        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.save(existingProduct);
    }




}
