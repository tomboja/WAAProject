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
        return new ResponseEntity<>(buyers,HttpStatus.OK);
    }


    @GetMapping("{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable("id") Long id) {
        Buyer currentBuyer = buyerService.getBuyerById(id);
        if(currentBuyer!=null)
            return new ResponseEntity<>(currentBuyer,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("registration")
    public ResponseEntity<Buyer> addNewBuyer(@RequestBody Buyer buyer) {
        Buyer currentBuyer = buyerService.addNewBuyer(buyer);
        if(currentBuyer!=null)
            return new ResponseEntity<>(currentBuyer, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);

    }

    @PutMapping
    public ResponseEntity<Buyer> updateBuyer(@RequestBody Buyer buyer){
          Buyer currentBuyer = buyerService.updateBuyer(buyer);
          if(currentBuyer!=null)
              return new ResponseEntity<>(currentBuyer,HttpStatus.OK);
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



