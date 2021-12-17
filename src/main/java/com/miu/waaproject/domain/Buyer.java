package com.miu.waaproject.domain;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
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
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Buyer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min=2, max=50)
    private String firstname;

    @Column(nullable = false)
    @Size(min=2, max=50)
    private String lastname;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    @Transient
    @Size(min=4, max=50)
    private String password;

    private final String role = "BUYER";

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "followers")
    private Set<Seller> followingSellers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private List<Address> addresses;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;

    private Integer points;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<Review> reviews;
}
