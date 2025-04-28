package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    @Transactional
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Laptop");
        Product product2 = new Product("Mouse");

        Item item1 = new Item(product1, new BigDecimal("3000"), 1, new BigDecimal("3000"));
        Item item2 = new Item(product2, new BigDecimal("150"), 2, new BigDecimal("300"));

        Invoice invoice = new Invoice("2025/04/001");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        productDao.save(product1);
        productDao.save(product2);

        //When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        Invoice retrievedInvoice = invoiceDao.findById(invoiceId).orElse(null);
        assertNotNull(retrievedInvoice);
        assertEquals(2, retrievedInvoice.getItems().size());

        //CleanUp
        invoiceDao.deleteById(invoiceId);
        productDao.deleteById(product1.getId());
        productDao.deleteById(product2.getId());
    }
}
