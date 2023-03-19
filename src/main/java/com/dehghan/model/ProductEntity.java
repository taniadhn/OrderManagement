package com.dehghan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE", nullable = false)
    private Double productPrice;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "TAXRATE" )
    private Float taxRate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @NotNull
    UserEntity userEntity;
}
