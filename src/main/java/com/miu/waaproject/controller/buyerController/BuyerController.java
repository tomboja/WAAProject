package com.miu.waaproject.controller.buyerController;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Seller;
import com.miu.waaproject.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buyer/")
public class BuyerController {

    BuyerService buyerService;

    @GetMapping("All")
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = buyerService.getAllBuyers();
        return buyers!=null? new ResponseEntity<>(buyers,HttpStatus.OK): new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }


    @GetMapping("{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") Long id) {
        Buyer currentBuyer = buyerService.getBuyerById(id);
        return currentBuyer!=null? new ResponseEntity<>(currentBuyer,HttpStatus.OK):new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @PostMapping("registration")
    public ResponseEntity<Buyer> addNewBuyer(@RequestBody Buyer buyer) {
        Buyer currentBuyer = buyerService.AddNewBuyer(buyer);
        return currentBuyer!=null? new ResponseEntity<>(currentBuyer, HttpStatus.CREATED): new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

    }

    @PutMapping
    public ResponseEntity<Buyer> updateBuyer(@RequestBody Buyer buyer){
          Buyer currentBuyer = buyerService.updateBuyer(buyer);
          return currentBuyer!=null?new ResponseEntity<>(currentBuyer,HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



