package com.miu.waaproject.domain;

import lombok.*;
import org.hibernate.annotations.Cascade;

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
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
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
    private boolean approved;

    private final String role = "SELLER";

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Order> ordersReceived;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Buyer> followers = new ArrayList<>();

}
