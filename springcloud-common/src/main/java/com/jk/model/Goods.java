package com.jk.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {

    private Integer goodId;

    private String goodName;

    private BigDecimal goodPrice;

    private String goodType;

}
