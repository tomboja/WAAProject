package com.miu.waaproject.domain;

import com.miu.waaproject.enums.Address_Type;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String zipcode;
    @NotNull
    private String state;
    @NotNull
    private String country;

    @ManyToOne
    private Buyer buyer; // id: 22

    private Address_Type address_type; // SHIPPING_ADDRESS, BILLING_ADDRESS, BOTH

}
