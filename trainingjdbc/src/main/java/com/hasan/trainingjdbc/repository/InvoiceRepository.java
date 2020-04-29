package com.hasan.trainingjdbc.repository;

import com.hasan.trainingjdbc.entity.InvoiceHeader;

public interface InvoiceRepository {
    public InvoiceHeader getInvoice(int id);
    public int save(InvoiceHeader invoiceHeader);
     
}