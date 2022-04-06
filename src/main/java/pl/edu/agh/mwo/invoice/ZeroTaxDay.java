package pl.edu.agh.mwo.invoice;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;

public class ZeroTaxDay {

    public static boolean isZeroTaxDay(LocalDate invoiceDate) {
        LocalDate carpenterDay = LocalDate.of(1999,3,18);
        if(carpenterDay.getMonth().equals(invoiceDate.getMonth()) &&
                carpenterDay.getDayOfMonth() == invoiceDate.getDayOfMonth()){
            return true;
        }
        return false;
    }
}
