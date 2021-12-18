package com.miu.waaproject;

import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.service.ProductService;
import com.miu.waaproject.service.SellerService;
import org.modelmapper.ModelMapper;
import com.miu.waaproject.domain.User;
import com.miu.waaproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WaaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaaProjectApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService, ProductService productService, SellerService sellerService) {
        return args -> {
            // Create admin, seller and buyer
            userService.save(new User(null, "admin@email.com", "Password1", "ADMIN"));
            userService.save(new User(null, "jane@email.com", "Password1", "SELLER"));
            userService.save(new User(null, "jason@email.com", "Password1", "BUYER"));
            userService.save(new User(null, "jagama@email.com", "Password1", "SELLER"));

            // Create products
            productService.saveProduct(new Product(null, "Banana","The best banana ever",4.80, true, "dean@email.com"));
            productService.saveProduct(new Product(null, "React 101 Book","React is a good SPA library", 40.50, true, "jane@email.com"));
            productService.saveProduct(new Product(null, "Spring Fundamentals","Spring is awesome", 30, true, "jane@email.com"));
            productService.saveProduct(new Product (null, "SpringBoot For beginners","This is a module that works over spring modules", 20 ,true, "jane@email.com"));
            productService.saveProduct(new Product(null, "MacBook Pro","The best computer ever",1000, true, "dean@email.com"));
            productService.saveProduct(new Product(null, "Pro Angular 8","Angular framework book", 40.50, true, "jane@email.com"));


        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
