package com.miu.waaproject.service.Impl;

import com.miu.waaproject.domain.Product;
import com.miu.waaproject.exceptions.ResourceNotFoundException;
import com.miu.waaproject.repository.ProductRepository;
import com.miu.waaproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/12/21
 */

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        log.info("Saving product to the database");
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        log.info("Fetching product with id {} from the database", id);
        return productRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product", "Id", id, "get product by Id"));
    }

    @Override
    public List<Product> getProductsList() {
        log.info("Fetching all products from the database");
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, long id) {
        // First find the product tobe updated from the database
        Product prod = productRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product", "Id", id, "product update"));
        // Update product
        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        prod.setAvailable(!product.isAvailable());
        return prod;
    }

    @Override
    public boolean deleteProductById(long id) {
        // First find the product tobe updated from the database
        Product product = productRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product", "Id", id, "product delete"));
        if (product != null) {
            productRepository.deleteById(id);
            return true;
        }else  return false;
    }
}
