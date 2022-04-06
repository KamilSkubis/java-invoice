package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;

public class FuelCanisterZeroTax extends Product {
    public FuelCanisterZeroTax(String name, BigDecimal price) {
        super(name, price, BigDecimal.ZERO, BigDecimal.ZERO);
    }
}
