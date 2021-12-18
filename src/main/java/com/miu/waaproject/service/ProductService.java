package com.miu.waaproject.service;

import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.Review;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/12/21
 */

public interface ProductService {
    public Product saveProduct(Product product);
    public Product getProductById(long id);
    public List<Product> getProductsList();
    public Product updateProduct(Product product, long id);
    public boolean deleteProductById(long id);

     //Get product reviews
     public List<Review> getProductReviews(long productId);
}
