package com.miu.waaproject.service.Impl;

import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.exceptions.ResourceNotFoundException;
import com.miu.waaproject.repository.SellerRepository;
import com.miu.waaproject.service.SellerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    @Override
    public Seller saveSeller(Seller seller) {
        log.info("Creating nes seller with email {} to the database", seller.getEmail());
        // Add password encoder  before saving
        return sellerRepository.save(seller);
    }

    @Override
    public Seller getSellerById(long id) {
        return sellerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "Id", id));
    }
}
