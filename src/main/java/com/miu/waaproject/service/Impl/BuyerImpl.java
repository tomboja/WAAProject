package com.miu.waaproject.service.Impl;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.repository.BuyerRepository;
import com.miu.waaproject.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileNotFoundException;
import java.util.List;

@Service
public class BuyerImpl implements BuyerService {
    @Autowired
    BuyerRepository buyerRepository;
    @Override
    public Buyer AddNewBuyer( Buyer buyer) {

            Buyer currentBuyer= new Buyer();
            currentBuyer.setId(buyer.getId());
            currentBuyer.setFirstname(buyer.getFirstname());
            currentBuyer.setLastname(buyer.getLastname());
            currentBuyer.setEmail(currentBuyer.getEmail());
            buyerRepository.save(currentBuyer);
            return currentBuyer;

    }

    @Override
    public List<Buyer> getAllBuyers() {
        List<Buyer> buyers = buyerRepository.findAll();
        return buyers;
    }

    @Override
    public Buyer getBuyerById(Long id) {
        return buyerRepository.getById(id);
    }

    @Override
    public Buyer updateBuyer(Buyer buyer) {
        Buyer currentBuyer = buyerRepository.findById(buyer.getId()).orElseThrow(null);

        currentBuyer.setFirstname(buyer.getFirstname());
        currentBuyer.setLastname(buyer.getLastname());
        currentBuyer.setEmail(buyer.getEmail());
        currentBuyer.setPassword(buyer.getPassword());
        buyerRepository.save(currentBuyer);
        return currentBuyer;

    }
}


