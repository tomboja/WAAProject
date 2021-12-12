package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Review;
import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.repository.AdminRepository;
import com.miu.waaproject.repository.BuyerRepository;
import com.miu.waaproject.repository.ReviewRepository;
import com.miu.waaproject.repository.SellerRepository;
import com.miu.waaproject.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    AdminRepository adminRepository;
    SellerRepository sellerRepository;
    BuyerRepository buyerRepository;
    ReviewRepository reviewRepository;

    @Override
    public List<Seller> findAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public List<Buyer> findAllBuyers() {
        return buyerRepository.findAll();
    }

    @Override
    public boolean approveSeller(Long id) {
        Seller seller = sellerRepository.getById(id);
        if(seller != null) {
            seller.setApproved(true);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> findUnapprovedReviews() {
        return reviewRepository.findByApproved();
    }
}
