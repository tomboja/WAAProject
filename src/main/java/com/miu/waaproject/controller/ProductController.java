package com.miu.waaproject.controller;

import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.Review;
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

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") long productId) {
        Product product = productService.getProductById(productId);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<List<Review>> getProductReviews(@PathVariable("productId") long productId) {
        List<Review> reviews = productService.getProductReviews(productId);

        return reviews != null
                ? new ResponseEntity<>(reviews, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getProductsList() {
        return new ResponseEntity<>(productService.getProductsList(), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("productId") long productId) {
        Product prod = productService.updateProduct(product, productId);

        return prod != null
                ? new ResponseEntity<>(prod, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") long productId) {
        boolean deleted = productService.deleteProductById(productId);

        return deleted ? new ResponseEntity<>(null, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
