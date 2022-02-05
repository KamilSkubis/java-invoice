package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public abstract class Product {
    private final String name;

    private final BigDecimal price;

    private final BigDecimal taxPercent;

    protected Product(String name, BigDecimal price, BigDecimal tax) {
        if ((name == null) || (name.equals(""))){
            throw new IllegalArgumentException();
        }
        this.name = name;

        if ((price == null) || (price.compareTo(new BigDecimal(0)) == -1)){
            throw new IllegalArgumentException();
        }
        this.price = price;
        this.taxPercent = tax;
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
        return getPrice().multiply(getTaxPercent().add(new BigDecimal(1)));
    }
}
