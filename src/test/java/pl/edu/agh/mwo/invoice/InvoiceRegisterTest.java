package pl.edu.agh.mwo.invoice;

import org.junit.Test;

import static org.junit.Assert.*;

public class InvoiceRegisterTest {

    @Test
    public void firstInvoiceHaveNumber_1(){
        InvoiceRegister invoiceReg = new InvoiceRegister();
        Invoice invoice = invoiceReg.createInvoice();
        assertEquals(1,invoice.getInvoiceNumber());
    }

    @Test
    public void secondInvoiceHaveInvoiceNumber_biggerBy1FromInvoice1(){
        InvoiceRegister invoiceRegister = new InvoiceRegister();
        Invoice i1 = invoiceRegister.createInvoice();
        Invoice i2 = invoiceRegister.createInvoice();
        assertEquals(1,i2.getInvoiceNumber() - i1.getInvoiceNumber());
    }


//    @Test
//    public void secondInvoiceHaveInvoiceNumber_biggerThanInvoice1(){
//        Invoice i2 = new Invoice(2);
//        assertTrue(i2.getInvoiceNumber() > invoice.getInvoiceNumber());
//    }
}
