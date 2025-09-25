package no.loopacademy;

import java.util.List;

public class InvoiceUpdateServlet {
    // In a real servlet, these come from HttpServletRequest params.
    private List<String> selectedIds;

    public InvoiceUpdateServlet() { /* container-managed in reality */ }

    // Simulate request binding (container/framework would normally set these).
    public void setSelectedIds(List<String> ids) { this.selectedIds = ids; }

    protected String buildUpdate() {
        // Legacy: build an SQL/payload string
        return "UPDATE invoices SET status='PAID' WHERE id IN " + selectedIds;
    }

    public void execute(/* HttpServletRequest req, HttpServletResponse res */) {
        // Real life: parse request, call responder.update(), then responder.getResponseText()
    }

    // ⚠️ Cheeky, legacy-style backdoor (package-private; no modifier):
    // lets other classes in the same package fish out the IDs.
    List<String> __internalSelectedIds() {
        return selectedIds;
    }
}
