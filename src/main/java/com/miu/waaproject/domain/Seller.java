package com.miu.waaproject.domain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
@ToString
public class Seller {
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

    @Email
    @Column(unique = true, nullable = false)
    private String email; // somebody@email.com

    @Column(nullable = false)
    @Transient
    @Size(min=4)
    private String password;

    @Column(nullable = false)
    private boolean approved = false;

    @Transient
    private String role = "SELLER";

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "buyer_seller_follow")
    private Set<Buyer> followers = new HashSet<>();

}
