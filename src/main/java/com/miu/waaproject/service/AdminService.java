package com.miu.waaproject.service;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Review;
import com.miu.waaproject.domain.Seller;

import java.util.List;

public interface AdminService {
    List<Seller> findAllSellers();
    List<Buyer> findAllBuyers();
    boolean approveSeller(Long id);
    List<Review> findUnapprovedReviews();

}
