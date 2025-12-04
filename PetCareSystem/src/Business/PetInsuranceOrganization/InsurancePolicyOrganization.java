package Business.PetInsuranceOrganization;

import Business.Organization.Organization;
import Business.Role.InsuranceAgentRole;
import Business.Role.Role;
import Business.Pet.InsurancePolicyDirectory;
import java.util.ArrayList;

/**
 * Organization responsible for managing insurance policies.
 */

public class InsurancePolicyOrganization extends Organization {
    // Each organization maintains its own policy directory
    private InsurancePolicyDirectory policyDirectory;

    
    public InsurancePolicyOrganization() {
        super("Insurance Policy Organization");
        this.policyDirectory = new InsurancePolicyDirectory(); // Initialize policy directory to avoid null-pointer issues
    }

    // Returns this organization's policy directory.
    public InsurancePolicyDirectory getPolicyDirectory() {
        return policyDirectory;
    }

    // Defines which roles this organization supports.
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InsuranceAgentRole());
        return roles;
    }
}
