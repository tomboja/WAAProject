package com.miu.waaproject.controller;
import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Review;
import com.miu.waaproject.dto.SellerDto;
import com.miu.waaproject.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/sellers")
    public ResponseEntity<List<SellerDto>> getAllSellers(){
        List<SellerDto> sellers = adminService.findAllSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @GetMapping("/buyers")
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        List<Buyer> buyers = adminService.findAllBuyers();
        return new ResponseEntity<>(buyers, HttpStatus.OK);
    }

    @PutMapping("/seller/{id}")
    public ResponseEntity<?> approveSeller(@PathVariable Long id){
        boolean status = adminService.approveSeller(id);
        return status
                ? new ResponseEntity<>("Successful", HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getUnapprovedReviews(){
        return ResponseEntity.ok(adminService.findUnapprovedReviews());
    }
}
