package com.miu.waaproject.domain;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    @Size(min=2, max=50)
    private String name;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    private double price;

    private boolean isAvailable = true; // purchased or available
    @NotNull
    private String seller_id;

//    @OneToMany(cascade = CascadeType.ALL)
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "product_id")
//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
//    private List<Review> reviews;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
//    private List<Review> reviews;
}
