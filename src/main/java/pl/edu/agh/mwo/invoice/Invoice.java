package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Collection<Product> products;

    public Invoice(){
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addProduct(Product product, Integer quantity) {
        if(quantity <=0 ){
            throw new IllegalArgumentException("quantity cannot be 0");
        }


        for(int i=0 ; i<quantity ; i++){
            products.add(product);
        }
    }

    public BigDecimal getSubtotal() {
        BigDecimal subtotal = new BigDecimal(0);
        if(products.size() == 0) {
            return subtotal;
        }
        for(Product product : products){
            subtotal = subtotal.add(product.getPrice());
        }
        return subtotal;

    }

    public BigDecimal getTax() {
        BigDecimal tax = BigDecimal.ZERO;
        if(products.size() == 0) {
            return tax;
        }

        for(Product product : products){
            tax = tax.add(product.getPrice().multiply(product.getTaxPercent()));
        }
        return tax;
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        if(products.size() == 0) {
            return total;
        }
        for(Product product : products){
            total = total.add(product.getPriceWithTax());
        }
        return total;
    }
}
