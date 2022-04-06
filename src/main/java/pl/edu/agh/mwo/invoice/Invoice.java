package pl.edu.agh.mwo.invoice;

import pl.edu.agh.mwo.invoice.product.FuelCanister;
import pl.edu.agh.mwo.invoice.product.FuelCanisterZeroTax;
import pl.edu.agh.mwo.invoice.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;


public class Invoice {
    private final LocalDate invoiceDate;
    private Map<Product, Integer> products;
    private int invoiceNumber;

    public Invoice(InvoiceRegister.InvoiceToken invoiceToken, LocalDate invoiceDate) {
        products = new LinkedHashMap<>();
        this.invoiceNumber = invoiceToken.getCurrentInvoiceNumber();
        this.invoiceDate = invoiceDate;
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, Integer quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException();
        }

        if (product instanceof FuelCanister &&
                new ZeroTaxDay().isZeroTaxDay(invoiceDate)) {
            product = new FuelCanisterZeroTax(product.getName(), product.getPrice());
        }

        if (products.containsKey(product)) {
            Integer prevQuantity = products.get(product);
            products.put(product, prevQuantity + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public BigDecimal getNetTotal() {
        BigDecimal totalNet = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalNet = totalNet.add(product.getPrice().multiply(quantity));
        }
        return totalNet;
    }

    public BigDecimal getTaxTotal() {
        return getGrossTotal().subtract(getNetTotal());
    }

    public BigDecimal getGrossTotal() {
        BigDecimal totalGross = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            BigDecimal quantity = new BigDecimal(products.get(product));
            totalGross = totalGross.add(product.getPriceWithTax().multiply(quantity));
        }
        return totalGross;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append(invoiceNumber + "\n");
        products.entrySet().stream().forEach(item -> sb.append(
                item.getKey().getName() + " " +
                        item.getValue() + " " +
                        item.getKey().getPrice().toString() + "\n"));
        sb.append("Liczba pozycji: " + products.size());
        return sb.toString();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}
