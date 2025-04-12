package com.ecommerce.Store.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String id;
    private String image;
    private String name;
    private String description;
    private double price;
    private int count;
}
