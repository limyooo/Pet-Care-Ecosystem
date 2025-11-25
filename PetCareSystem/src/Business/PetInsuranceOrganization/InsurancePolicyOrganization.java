package Business.PetInsuranceOrganization;

import Business.Organization.Organization;
import Business.Role.InsuranceAgentRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * InsurancePolicyOrganization:
 * Handles pet insurance policy creation, management and advising.
 */
public class InsurancePolicyOrganization extends Organization {

    public InsurancePolicyOrganization() {
        super("Insurance Policy Organization");
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InsuranceAgentRole()); // only insurance agents work here
        return roles;
    }
}