package Business.PetBoardingOrganization;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 * PetBoardingOrganizationDirectory:
 * Holds all organizations under the Pet Boarding Enterprise,
 * such as PetCareOrganization and BoardingServiceOrganization.
 */
public class PetBoardingOrganizationDirectory {

    // List of all organizations related to pet boarding
    private ArrayList<Organization> organizationList;

    public PetBoardingOrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    // Getter for the list
    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    
    /**
     * Factory method to create organizations by type.
     * Only PetCare and BoardingService are allowed here.
     */
    public Organization createOrganization(Organization.Type type) {
        Organization organization = null;

        if (type == Organization.Type.PetCare) {
            organization = new PetCareOrganization();
            organizationList.add(organization);
        } else if (type == Organization.Type.BoardingService) {
            organization = new BoardingServiceOrganization();
            organizationList.add(organization);
        }

        return organization;
    }
}