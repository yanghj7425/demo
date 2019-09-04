package com.yhj.order_service.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class ProductOrder implements Serializable {
    private static final long serialVersionUID = -4890251294998737674L;

    private Integer id;

    private String productName;

    private Integer price;

    private Date createTime;

    private String tradeNo;

    private Integer userId;

    private String userName;


    public ProductOrder() {

    }
}
