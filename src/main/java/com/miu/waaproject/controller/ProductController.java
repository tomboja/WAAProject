package com.miu.waaproject.controller;

import com.miu.waaproject.domain.Product;
import com.miu.waaproject.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/12/21
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product prod = productService.saveProduct(product);
        return prod != null ?
                new ResponseEntity<>(prod, HttpStatus.CREATED) :
                new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Product product = productService.getProductById(id);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProductsList() {
        return new ResponseEntity<>(productService.getProductsList(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") long id) {
        Product prod = productService.updateProduct(product, id);

        return prod != null
                ? new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") long id) {
        boolean deleted = productService.deleteProductById(id);

        return deleted ? new ResponseEntity<>(null, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
