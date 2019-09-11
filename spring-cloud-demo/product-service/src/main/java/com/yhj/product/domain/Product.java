package com.yhj.product.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class Product implements Serializable {
    private static final long serialVersionUID = 4223959560955340370L;
    private Integer Id;

    private String name;

    private Integer price;

    private Integer store;

    private String image;

}

