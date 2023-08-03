package com.example.ProductCrud.Controller;

import com.example.ProductCrud.Entity.Product;
import com.example.ProductCrud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    /* @Constructor Injection */
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /* @GET Requests */
    @GetMapping("")
    public String indexApi(){
        return "Product CRUD RestApi";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    /* @POST Requests */
    @PostMapping("/add-product")
    public Product addNewProduct(@RequestBody Product product){
        return productService.saveNewProduct(product);
    }

    @PostMapping("/add-products")
    public List<Product> addNewProducts(@RequestBody List<Product> products){
        return productService.saveNewProducts(products);
    }

    /* @PUT Requests */
    @PutMapping("/update-product")
    public Product updateProduct(@RequestBody  Product product){
        return productService.updateProductById(product);
    }

    /* @DELETE Requests*/
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProductById(id);
    }

    /* Handle 404 - Not Found */
    @RequestMapping(value = "/{path:[^\\.]*}")
    public String handle404(@PathVariable String path) {
        return "404 - Not Found";
    }

}
