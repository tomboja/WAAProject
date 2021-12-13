package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Review;
import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.domain.User;
import com.miu.waaproject.dto.SellerDto;
import com.miu.waaproject.repository.*;
import com.miu.waaproject.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    AdminRepository adminRepository;
    SellerRepository sellerRepository;
    BuyerRepository buyerRepository;
    ReviewRepository reviewRepository;
    UserRepository userRepository;

    @Override
    public List<SellerDto> findAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();
        List<SellerDto> sellerDtos = new ArrayList<>();
        for (Seller s: sellers) {
            SellerDto sellerDto = new SellerDto();
            sellerDto.setId(s.getId());
            sellerDto.setFirstname(s.getFirstname());
            sellerDto.setLastname(s.getLastname());
            sellerDto.setEmail(s.getEmail());
            sellerDto.setProducts(s.getProducts());
            sellerDto.setFollowers(s.getFollowers());
            sellerDto.setOrdersReceived(s.getOrdersReceived());
            sellerDtos.add(sellerDto);
        }

        return sellerDtos;
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
