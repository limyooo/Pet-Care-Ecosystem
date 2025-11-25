package Business.PetClinicOrganization;

import Business.Organization.Organization;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * VetLabOrganization:
 * Processes lab test requests and records lab results.
 */
public class VetLabOrganization extends Organization {

    public VetLabOrganization() {
        super("Vet Lab Organization");
    }

    // Only lab assistants work in this lab
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LabAssistantRole()); 
        return roles;
    }
}
