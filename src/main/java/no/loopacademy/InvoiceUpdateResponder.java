package no.loopacademy;

import java.util.List;

public class InvoiceUpdateResponder {
    private final InvoiceUpdateServlet servlet; // legacy dep
    private final DBConnection db;             // legacy dep

    public InvoiceUpdateResponder(InvoiceUpdateServlet servlet, DBConnection db) {
        this.servlet = servlet;
        this.db = db;
    }

    public void update() {
        // 1) Servlet builds the update command based on request params it holds
        String updateString = servlet.buildUpdate();

        // 2) Responder applies the update via DB (side effect happens here)
        db.applyUpdate(updateString);

        // 3) (Servlet would write getResponseText() to HTTP response; omitted here)
        System.out.println(getResponseText());
    }

    public String getResponseText() {
        // In the pure legacy sketch, we'd still need the IDs; use your chosen approach
        // (e.g., the cheeky package-private accessor) or leave this as-is if you plan

        List<String> ids = servlet.__internalSelectedIds(); // if you added the backdoor
        var invoices = db.getInvoices(new Criteria(ids));// want to change this int total = invoices.stream().mapToInt(Invoice::getValue).sum();
        int total = 0;
        for (int i = 0; i < invoices.size(); i++) {
            total += invoices.get(i).getValue();
        }

        return "Updated " + invoices.size() + " invoices. Total value = " + total;
    }
}