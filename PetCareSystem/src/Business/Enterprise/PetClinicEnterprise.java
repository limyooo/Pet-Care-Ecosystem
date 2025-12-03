package Business.Enterprise;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 * Enterprise for pet clinic / hospital.
 */
public class PetClinicEnterprise extends Enterprise {

    public PetClinicEnterprise(String name) {
        super(name, EnterpriseType.PetClinic);
    }

    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> list = new ArrayList<>();
        list.add(Organization.Type.FrontDesk);
        list.add(Organization.Type.VetDoctor);
        list.add(Organization.Type.VetLab);
        return list;
    }
}