package com.miu.waaproject.controller;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = buyerService.getAllBuyers();
        return buyers!=null? new ResponseEntity<>(buyers,HttpStatus.OK): new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

//    @PostMapping
//    public ResponseEntity<Buyer> addNewBuyer(@RequestBody Buyer buyer) {
//
//        Buyer currentBuyer = buyerService.addNewBuyer(buyer);
//        if(currentBuyer!=null)
//            return new ResponseEntity<>(currentBuyer, HttpStatus.CREATED);
//
//        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") Long id) {
        Buyer currentBuyer = buyerService.getBuyerById(id);
        return currentBuyer!=null? new ResponseEntity<>(currentBuyer,HttpStatus.OK):new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Buyer> updateBuyer(@RequestBody Buyer buyer, @PathVariable("id") Long id){
          Buyer currentBuyer = buyerService.updateBuyer(buyer,id);
          return currentBuyer!=null?new ResponseEntity<>(currentBuyer,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



