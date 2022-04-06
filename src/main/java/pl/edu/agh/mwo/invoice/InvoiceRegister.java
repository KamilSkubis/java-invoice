package pl.edu.agh.mwo.invoice;

import java.time.LocalDate;

public class InvoiceRegister {

    private InvoiceToken invoiceToken;

    public InvoiceRegister() {
        this.invoiceToken = new InvoiceToken();
    }

    public Invoice createInvoice() {
        Invoice invoice = new Invoice(invoiceToken, LocalDate.now());
        invoiceToken.increaseInvoiceNumber();
        return invoice;
    }
    
    public class InvoiceToken {

        private int currentInvoiceNumber;

        private InvoiceToken() {
            currentInvoiceNumber = 1;
        }

        public int getCurrentInvoiceNumber() {
            return currentInvoiceNumber;
        }

        private void increaseInvoiceNumber() {
            currentInvoiceNumber++;
        }
    }
}


