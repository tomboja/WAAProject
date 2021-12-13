package com.miu.waaproject.domain;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String email; // somebody@email.com

    @Column(nullable = false)
    @Transient
    private String password;

    @Column(nullable = false)
    private boolean approved = false;

    @Transient
    private String role = "SELLER";

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "buyer_seller_follow")
    private Set<Buyer> followers = new HashSet<>();
}
