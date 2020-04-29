package com.hasan.trainingjdbc.entity;

import java.math.BigDecimal;
import java.util.List;

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
public class InvoiceHeader {
    
    private Long invoice_id;
    private String invoice_to;
    private String email;
    private BigDecimal subtotal;
    private BigDecimal discount;
    private BigDecimal total;
    private List<InvoiceDetails> invoiceDetails;


    public InvoiceHeader(Long invoice_id, String invoice_to, String email, BigDecimal subtotal, BigDecimal discount, BigDecimal total) {
        this.invoice_id = invoice_id;
        this.invoice_to = invoice_to;
        this.email = email;
        this.subtotal = subtotal;
        this.discount = discount;
        this.total = total;    
    }

}