package com.jk.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {

    private Integer orderId;

    private Integer userId;

    private Integer goodId;

    private String orderName;

    private BigDecimal orderPrice;

}
