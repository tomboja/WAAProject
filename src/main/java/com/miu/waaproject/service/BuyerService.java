package com.miu.waaproject.service;

import com.miu.waaproject.domain.Buyer;

import java.io.FileNotFoundException;
import java.util.List;

public interface BuyerService {
    Buyer addNewBuyer(Buyer buyer);
    List<Buyer> getAllBuyers();
    Buyer getBuyerById(Long buyerId);
    Buyer updateBuyer(Buyer buyer, Long id);
}
