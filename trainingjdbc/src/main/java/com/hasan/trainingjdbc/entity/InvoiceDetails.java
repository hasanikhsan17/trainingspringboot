package com.hasan.trainingjdbc.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvoiceDetails {
    
    private Long detail_id;
    private int invoice_id;
    private String product_name;
    private Long qty;

    private BigDecimal total_price;

}
