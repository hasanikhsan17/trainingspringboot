package com.hasan.trainingjdbc.repository;

import java.util.List;

import com.hasan.trainingjdbc.entity.InvoiceDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("InvoiceDetailsRepository")
public class InvoiceDetailsRepositoryImp implements InvoiceDetailsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<InvoiceDetails> getInvoiceDetail(int invoice_id) {
        return jdbcTemplate.query("select * from public.invoice_details where invoice_id =" + invoice_id,
                (rs, rowNum) -> new InvoiceDetails(rs.getLong("detail_id"), rs.getInt("invoice_id"),
                        rs.getString("product_name"), rs.getLong("qty"), rs.getBigDecimal("total_price")));
    }

}
