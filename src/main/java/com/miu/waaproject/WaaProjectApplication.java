package com.miu.waaproject;

import org.modelmapper.ModelMapper;
import com.miu.waaproject.domain.User;
import com.miu.waaproject.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.save(new User(null, "john@email.com", "customer", "ADMIN"));
            userService.save(new User(null, "jane@email.com", "Password1", "SELLER"));
            userService.save(new User(null, "jason@email.com", "Password1", "BUYER"));
            userService.save(new User(null, "jagama@email.com", "Password1", "SELLER"));
        };
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
