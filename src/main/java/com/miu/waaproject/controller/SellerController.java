package com.miu.waaproject.controller;

import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.dto.SellerDto;
import com.miu.waaproject.service.impl.SellerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sellers")
public class SellerController {

    private final SellerServiceImpl sellerService;

    @PostMapping
    public ResponseEntity<Seller> saveNewSeller(@RequestBody Seller seller) {
        Seller newSeller = sellerService.saveSeller(seller);
        return newSeller!=null? new ResponseEntity<>(newSeller, HttpStatus.CREATED): new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    // fetch all seller for admin - admin controller
    // fetch all buyer for admin - admin controller

    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById( @PathVariable("id") long id) {
        return new ResponseEntity<>(sellerService.getSellerById(id), HttpStatus.OK);
    }
}
