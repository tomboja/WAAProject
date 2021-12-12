package com.miu.waaproject.service;

import com.miu.waaproject.domain.Seller;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

public interface SellerService {
    public Seller saveSeller(Seller seller);
    public Seller getSellerById(long id);
}
