package no.loopacademy;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    public void applyUpdate(String updateString) {
        // Legacy placeholder: in a real system this would execute SQL / repo call.
        // Kept here to show that the Responder DOES talk to the DB in update().
        System.out.println("APPLYING UPDATE: " + updateString);
    }

    public List<Invoice> getInvoices(Criteria criteria) {
        // In real life: query DB and map rows
        return new ArrayList<>();
    }
}
