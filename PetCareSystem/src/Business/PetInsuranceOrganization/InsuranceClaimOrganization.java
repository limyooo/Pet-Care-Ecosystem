package Business.PetInsuranceOrganization;

import Business.Organization.Organization;
import Business.Role.ClaimProcessorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * Organization responsible for handling insurance claim requests.
 */
public class InsuranceClaimOrganization extends Organization {

    public InsuranceClaimOrganization() {
        super("Insurance Claim Organization"); // Set organization name
    }

    // Returns the list of roles(Claim Processor) supported by this organization.
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ClaimProcessorRole()); // only claim processors work here
        return roles;
    }
}