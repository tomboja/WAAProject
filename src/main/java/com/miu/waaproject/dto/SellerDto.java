package com.miu.waaproject.dto;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/13/21
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email; // somebody@email.com
    private boolean approved = false;
    private String role = "SELLER";
    private List<Product> products;
    private List<ProductOrder> ordersReceived;
    private Set<Buyer> followers = new HashSet<>();

}
