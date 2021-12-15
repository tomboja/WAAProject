package com.miu.waaproject.service.impl;
import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.exceptions.ResourceNotFoundException;
import com.miu.waaproject.repository.ProductRepository;
import com.miu.waaproject.repository.SellerRepository;
import com.miu.waaproject.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

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
    private final SellerRepository sellerRepository;
    private final Validator validator;

    @Override
    public Product saveProduct(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Product> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            System.out.println(sb.toString());
            return null;
        }
        log.info("Saving product to the database");

        // Only save product if seller exists in database
        // Find Seller by email
        Seller seller = sellerRepository
                .findByEmail(product.getSeller_id());
        return seller != null ?
                productRepository.save(product) : null;
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
        prod.setAvailable(product.isAvailable());
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
        } else return false;

    }
}
