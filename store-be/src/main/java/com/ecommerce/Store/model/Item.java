package com.ecommerce.Store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("initial_quantity")
    private int initialQuantity;
    private int quantity;
}
