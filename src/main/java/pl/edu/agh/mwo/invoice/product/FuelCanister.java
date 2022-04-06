package pl.edu.agh.mwo.invoice.product;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FuelCanister extends Product{

    public FuelCanister(String name, BigDecimal price) {
        super(name, price, BigDecimal.ZERO, new BigDecimal("5.56"));

        }



}
