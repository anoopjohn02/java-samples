package anoop.test.sample.principles.singleresponsibility;

import java.util.Date;

// This class breaks the SRP.
public class EmpolyeeViolateSRP {
    private String employeeId;
    private String name;
    private String address;
    private Date dateOfJoining;

    // Responsibility of HR dept --> 1
    public boolean isPromotionDueThisYear() {
        // promotion logic
        return false;
    }

    // Responsibility of Finance dept --> 2
    public boolean calculateIncomeTaxForCurrentYea() {
        // income tax logic
        return false;
    }

    // getters, setters
}
