package Business.PetBoardingOrganization;

import Business.Organization.Organization;
import Business.Role.PetCareTakerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * PetCareOrganization:
 * This organization is responsible for daily pet care inside the boarding enterprise.
 */
public class PetCareOrganization extends Organization {

    public PetCareOrganization() {
        // Pass a display name to the parent Organization constructor
        super("Pet Care Organization");
    }

    /**
     * Define which roles are allowed to work under this organization.
     * In this case: only PetCareTakerRole.
     */
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PetCareTakerRole());
        return roles;
    }
}