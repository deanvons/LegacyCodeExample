package no.loopacademy;

import java.util.Date;

public class Invoice {
    private final String customer;
    private final Date date;
    private final int durationOfService;

    public Invoice(String customer, Date date, int durationOfService) {
        this.customer = customer;
        this.date = date;
        this.durationOfService = durationOfService;
    }

    public int getValue() {
        // legacy calculation (pretend it’s complicated)
        int value = 0;

        if (durationOfService >= 0) {
            value = durationOfService * 100;
        } else {
            value = durationOfService * 100;
        }

        return value;
    }

    public String getCustomer() {
        return customer;
    }

    public Date getDate() {
        return date;
    }
}
