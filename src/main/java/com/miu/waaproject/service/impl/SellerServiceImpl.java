package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.domain.User;
import com.miu.waaproject.exceptions.ResourceNotFoundException;
import com.miu.waaproject.repository.SellerRepository;
import com.miu.waaproject.repository.UserRepository;
import com.miu.waaproject.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;

    @Override
    public Seller saveSeller(Seller seller) {
        Set<ConstraintViolation<Seller>> violations = validator.validate(seller);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Seller> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            return null;
        }
        log.info("Creating seller with email {} to the database", seller.getEmail());
        User user = new User();
        user.setEmail(seller.getEmail());
        user.setPassword(passwordEncoder.encode(seller.getPassword()));
        user.setRole(seller.getRole());

        userRepository.save(user);
        return sellerRepository.save(seller);
    }

    @Override
    public Seller getSellerById(long id) {
        log.info("Fetching seller by Id {} from the database", id);
        return sellerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "Id", id, "fetching seller"));
    }
}
