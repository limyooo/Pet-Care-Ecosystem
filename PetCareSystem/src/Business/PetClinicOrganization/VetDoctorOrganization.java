package Business.PetClinicOrganization;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.VetDoctorRole;
import java.util.ArrayList;

/**
 * VetDoctorOrganization:
 * Veterinarians who diagnose pets and create lab test requests.
 */
public class VetDoctorOrganization extends Organization {

    public VetDoctorOrganization() {
        super("Vet Doctor Organization");
    }

    // Only vet doctors work here
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new VetDoctorRole());
        return roles;
    }
}
