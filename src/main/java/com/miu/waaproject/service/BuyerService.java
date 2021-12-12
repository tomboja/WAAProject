package com.miu.waaproject.service;

import com.miu.waaproject.domain.Buyer;

import java.util.List;

public interface BuyerService {
    Buyer AddNewBuyer(Buyer buyer);

    List<Buyer> getAllBuyers();

    Buyer getBuyerById(Long id);

    Buyer updateBuyer(Buyer buyer);
}
