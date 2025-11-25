package Business.Enterprise;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 * Enterprise for pet boarding service.
 */
public class PetBoardingEnterprise extends Enterprise {

    public PetBoardingEnterprise(String name) {
        super(name, EnterpriseType.PetBoarding);
    }

    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> list = new ArrayList<>();
        // Departments inside pet boarding enterprise
        list.add(Organization.Type.FrontDesk);
        list.add(Organization.Type.PetCare);
        list.add(Organization.Type.BoardingService);
        return list;
    }
}
