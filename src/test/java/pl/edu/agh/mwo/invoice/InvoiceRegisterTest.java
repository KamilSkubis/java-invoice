package pl.edu.agh.mwo.invoice;

import org.junit.Test;
import pl.edu.agh.mwo.invoice.product.FuelCanister;
import pl.edu.agh.mwo.invoice.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class InvoiceRegisterTest {

    @Test
    public void firstInvoiceHaveNumber_1() {
        InvoiceRegister invoiceReg = new InvoiceRegister();
        Invoice invoice = invoiceReg.createInvoice();
        assertEquals(1, invoice.getInvoiceNumber());
    }

    @Test
    public void secondInvoiceHaveInvoiceNumber_biggerBy1FromInvoice1() {
        InvoiceRegister invoiceRegister = new InvoiceRegister();
        Invoice i1 = invoiceRegister.createInvoice();
        Invoice i2 = invoiceRegister.createInvoice();
        assertEquals(1, i2.getInvoiceNumber() - i1.getInvoiceNumber());
    }

    @Test
    public void invoiceCreatedOnCarpenterDay_fuelTax0() {
        InvoiceRegister invoiceRegister = new InvoiceRegister();
        Invoice invoice = invoiceRegister.createInvoice();
        Product p = new FuelCanister("ON",
                new BigDecimal("8.00"));
        invoice.addProduct(p, 1);

        Product product = (Product) invoice.getProducts().keySet().toArray()[0];
        assertEquals(new BigDecimal("8.00"), product.getPriceWithTax());
    }

}
