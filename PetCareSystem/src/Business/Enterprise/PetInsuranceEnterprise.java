package Business.Enterprise;

import Business.Organization.Organization;
import java.util.ArrayList;

/**
 * Enterprise for pet insurance.
 */
public class PetInsuranceEnterprise extends Enterprise {

    public PetInsuranceEnterprise(String name) {
        super(name, EnterpriseType.PetInsurance);
    }

    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> list = new ArrayList<>();
        list.add(Organization.Type.InsurancePolicy);
        list.add(Organization.Type.InsuranceClaim);
        return list;
    }
}
