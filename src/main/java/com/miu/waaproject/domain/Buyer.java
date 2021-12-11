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

    @Column(unique = true, nullable = false)
    private String email;

    private final String role = "BUYER";

    // One buyer can follow many sellers and one seller can be followed by many buyers
    @ManyToMany(fetch = FetchType.EAGER) // Cascade type
    @JoinTable()
    private List<Seller> followingSellers = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "")
    private List<Order> orders;

    @OneToOne() // relationship tobe filled
    private Address shippingAddress;

    @OneToOne() // relationship tobe filled
    private Address billingAddress;
}
