package com.springboot.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(unique = true, nullable = false)
    private String productName;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
