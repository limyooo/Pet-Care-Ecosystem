package Business.PetClinicOrganization;

import Business.Organization.Organization;
import Business.Role.FrontDeskAgentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * FrontDeskOrganization:
 * Handles registration, appointment scheduling and basic triage.
 */
public class FrontDeskOrganization extends Organization {

    public FrontDeskOrganization() {
        // Display name for this organization
        super("Front Desk Organization");
    }

    // Only front desk agents work in this organization
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FrontDeskAgentRole());
        return roles;
    }
}
