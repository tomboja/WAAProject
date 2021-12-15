package com.miu.waaproject.service.impl;
import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.ShoppingCart;
import com.miu.waaproject.domain.User;
import com.miu.waaproject.exceptions.ResourceNotFoundException;
import com.miu.waaproject.repository.BuyerRepository;
import com.miu.waaproject.repository.UserRepository;
import com.miu.waaproject.service.BuyerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Transactional
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private  final Validator validator;
    @Override
    public Buyer addNewBuyer(Buyer buyer) {

        log.info("Saving buyer to the database");
        Set<ConstraintViolation<Buyer>> violations = validator.validate(buyer);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Buyer> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            return null;
        }
        User user = new User();
        user.setEmail(buyer.getEmail());
        user.setPassword(passwordEncoder.encode(buyer.getPassword()));
        user.setRole(buyer.getRole());
        userRepository.save(user);
        buyer.setShoppingCart(new ShoppingCart());
        userRepository.save(user);
        return buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer getBuyerById(Long buyerId) {
        return buyerRepository.findById(buyerId).orElseThrow(null);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer, Long id) {
        Buyer currentBuyer = buyerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "Id", buyer.getId(), "fetching buyer"));

        currentBuyer.setFirstname(buyer.getFirstname());
        currentBuyer.setLastname(buyer.getLastname());
        currentBuyer.setEmail(buyer.getEmail());
        return currentBuyer;
    }
}


