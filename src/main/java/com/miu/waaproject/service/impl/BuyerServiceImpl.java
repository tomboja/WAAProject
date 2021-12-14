package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.Buyer;
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
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public Buyer addNewBuyer(Buyer buyer) {
        log.info("Saving buyer to the database");
        User user = new User();
        user.setEmail(buyer.getEmail());
        user.setPassword(passwordEncoder.encode(buyer.getPassword()));
        user.setRole(buyer.getRole());

        userRepository.save(user);
        return buyerRepository.save(buyer);
    }

    @Override
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer getBuyerById(Long id) {
        return buyerRepository.getById(id);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) {
        Buyer currentBuyer = buyerRepository
                .findById(buyer.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "Id", buyer.getId(), "fetching buyer"));

        currentBuyer.setFirstname(buyer.getFirstname());
        currentBuyer.setLastname(buyer.getLastname());
        currentBuyer.setEmail(buyer.getEmail());
        return currentBuyer;
    }
}


