package com.miu.waaproject.domain;

import com.fasterxml.jackson.annotation.*;
import com.miu.waaproject.enums.Order_Status;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ProductOrder {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Order_Status status; // can be one of CANCELLED, SHIPPED, ON_THE_WAY, DELIVERED

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @NotNull
    private String buyer_email;
}
