package com.miu.waaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/10/21
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean approved;

    private final String role = "BUYER";

    // One buyer can follow many sellers and one seller can be followed by many buyers
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "followers") // Cascade type
    @JoinTable(name = "buyer_seller_follow")
    private List<Seller> followingSellers;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<Order> orders;

    @OneToOne() // relationship tobe filled
    private Address shippingAddress;

    @OneToOne() // relationship tobe filled
    private Address billingAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "buyer") // needs editing
    private ShoppingCart shoppingCart;

    private Integer points;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<Review> reviews;
}
