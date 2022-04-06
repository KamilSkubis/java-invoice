package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {

    private final String name;
    private final BigDecimal price;
    private final BigDecimal taxPercent;
    private final BigDecimal taxValue;

    protected Product(String name, BigDecimal price, BigDecimal taxPercent, BigDecimal taxValue) {

        if (name == null || name.equals("") || price == null || taxPercent == null || taxPercent.compareTo(new BigDecimal(0)) < 0
                || price.compareTo(new BigDecimal(0)) < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;

        if ((price == null) || (price.compareTo(new BigDecimal(0)) == -1)) {
            throw new IllegalArgumentException();
        }

        this.taxPercent = taxPercent;
        this.taxValue = taxValue;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    public BigDecimal getPriceWithTax() {
        if (taxPercent.equals(BigDecimal.ZERO)) {
            return price.add(taxValue);
        } else {
            return price.multiply(taxPercent).add(price);
        }
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
