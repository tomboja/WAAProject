package com.miu.waaproject.controller;


import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.service.BuyerService;
import com.miu.waaproject.service.impl.SellerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final BuyerService buyerService;
    private final SellerServiceImpl sellerService;

    @GetMapping("/login")
    public String LoginPage() {
        return "Welcome to login";
    }

    @PostMapping("/buyers")
    public ResponseEntity<Buyer> addNewBuyer(@RequestBody Buyer buyer) {

        Buyer currentBuyer = buyerService.addNewBuyer(buyer);
        if(currentBuyer!=null)
            return new ResponseEntity<>(currentBuyer, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

    @PostMapping("/sellers")
    public ResponseEntity<Seller> saveNewSeller(@RequestBody Seller seller) {
        Seller newSeller = sellerService.saveSeller(seller);
        return newSeller!=null? new ResponseEntity<>(newSeller, HttpStatus.CREATED): new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

}
