package com.miu.waaproject;

import com.miu.waaproject.domain.User;
import com.miu.waaproject.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

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
    CommandLineRunner run(UserService userService) {
        return args -> {


            userService.save(new User(null, "John Travolta", "john", "customer", "ADMIN"
            ));
        };
    }

}
