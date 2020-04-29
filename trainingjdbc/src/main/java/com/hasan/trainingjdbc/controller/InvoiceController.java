package com.hasan.trainingjdbc.controller;

import javax.validation.Valid;

import com.hasan.trainingjdbc.entity.InvoiceHeader;
import com.hasan.trainingjdbc.repository.InvoiceRepositoryImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class InvoiceController {

    @Autowired
    @Qualifier("invoiceRepository")
    private InvoiceRepositoryImp invoiceRepositoryImp;

    @GetMapping("/invoice")
    public InvoiceHeader getInvoiceById(@RequestParam("id") int id){
        return invoiceRepositoryImp.getInvoice(id);
    }

    @PostMapping("/invoice")
    public int saveInvoice(@Valid @RequestBody InvoiceHeader invoiceHeader) {
        return invoiceRepositoryImp.save(invoiceHeader);
    }
    

}