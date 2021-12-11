package com.miu.waaproject.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
public class ShoppingCart {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne() // needs editing
    private Buyer buyer;

    @OneToMany() // needs editing
    private List<Product> products;



}
