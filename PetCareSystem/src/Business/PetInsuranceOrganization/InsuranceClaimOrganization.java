package Business.PetInsuranceOrganization;

import Business.Organization.Organization;
import Business.Role.ClaimProcessorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * InsuranceClaimOrganization:
 * Processes claim requests submitted by pet owners or agents.
 */
public class InsuranceClaimOrganization extends Organization {

    public InsuranceClaimOrganization() {
        super("Insurance Claim Organization");
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClaimProcessorRole()); // only claim processors work here
        return roles;
    }
}