package com.wandou.model.dto;

import lombok.Data;

@Data
public class Book {

    private String name;

    private String type;

    private Long price;

    private String author;

    public Book(String name, String type, Long price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
}
