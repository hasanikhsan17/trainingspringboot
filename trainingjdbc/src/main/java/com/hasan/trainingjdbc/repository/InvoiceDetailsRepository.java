package com.hasan.trainingjdbc.repository;

import java.util.List;

import com.hasan.trainingjdbc.entity.InvoiceDetails;

public interface InvoiceDetailsRepository {
    public List<InvoiceDetails> getInvoiceDetail(int invoice_id);
}