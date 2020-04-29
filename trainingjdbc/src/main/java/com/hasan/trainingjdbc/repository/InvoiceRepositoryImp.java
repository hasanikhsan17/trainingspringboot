package com.hasan.trainingjdbc.repository;

import java.sql.PreparedStatement;
import java.util.List;

import com.hasan.trainingjdbc.entity.InvoiceDetails;
import com.hasan.trainingjdbc.entity.InvoiceHeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository("invoiceRepository")
public class InvoiceRepositoryImp implements InvoiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("InvoiceDetailsRepository")
    private InvoiceDetailsRepositoryImp invoiceDetailsRepository;

    @Override
    public InvoiceHeader getInvoice(int id) {
        InvoiceHeader ih = jdbcTemplate.queryForObject("select * from public.invoice_header where invoice_id =" + id,
                (rs, rowNum) -> new InvoiceHeader(rs.getLong("invoice_id"), rs.getString("invoice_to"),
                        rs.getString("email"), rs.getBigDecimal("subtotal"), rs.getBigDecimal("discount"),
                        rs.getBigDecimal("total")));

        ih.setInvoiceDetails(invoiceDetailsRepository.getInvoiceDetail(id));
        return ih;
    }

    @Override
    public int save(InvoiceHeader invoiceHeader) {

        String sql = "INSERT INTO public.invoice_header(invoice_to, email, subtotal, discount, total) values(?,?,?,?,?)";
        String sql_invoice_details = "INSERT INTO public.invoice_details(invoice_id, product_name, qty, total_price) values(?,?,?,?)";

        KeyHolder kh = new GeneratedKeyHolder();

        int result = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] { "invoice_id" });
            ps.setString(1, invoiceHeader.getInvoice_to());
            ps.setString(2, invoiceHeader.getEmail());
            ps.setBigDecimal(3, invoiceHeader.getSubtotal());
            ps.setBigDecimal(4, invoiceHeader.getDiscount());
            ps.setBigDecimal(5, invoiceHeader.getTotal());
            return ps;
        }, kh);

        List<InvoiceDetails> id = invoiceHeader.getInvoiceDetails();
        id.forEach(invoiceDetails -> {
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql_invoice_details, new String[] { "detail_id" });

                ps.setInt(1, (Integer) kh.getKey());
                ps.setString(2, invoiceDetails.getProduct_name());
                ps.setLong(3, invoiceDetails.getQty());
                ps.setBigDecimal(4, invoiceDetails.getTotal_price());
                return ps;
            });
        });
        return result;
    }

}