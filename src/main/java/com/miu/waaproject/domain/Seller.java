package com.miu.waaproject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/10/21
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean approved;

    private final String role = "SELLER";

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<Product> products;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<ProductOrder> ordersReceived;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "buyer_seller_follow")
    private Set<Buyer> followers = new HashSet<>();
}
