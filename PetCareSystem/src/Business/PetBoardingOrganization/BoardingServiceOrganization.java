package Business.PetBoardingOrganization;

import Business.Organization.Organization;
import Business.Role.BoardingManagerRole;
import Business.Role.CustomerSupporterRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 * BoardingServiceOrganization:
 * Handles booking, check-in/out and communication with pet owners.
 */
    public class BoardingServiceOrganization extends Organization {

    public BoardingServiceOrganization() {
        super("Boarding Service Organization");
    }

    // Boarding service supports both Manager and Customer Supporter roles
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new BoardingManagerRole());
        roles.add(new CustomerSupporterRole());
        return roles;
    }
}