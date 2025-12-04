package Business.Enterprise;

import Business.Organization.Organization;
import Business.Pet.InsurancePolicyDirectory;
import java.util.ArrayList;

/**
 *  - Manage the organizations under this enterprise （InsurancePolicy / InsuranceClaim）
 *  - Maintain a central InsurancePolicyDirectory that stores all insurance policies belonging to this enterprise.
 */

public class PetInsuranceEnterprise extends Enterprise {
    // The enterprise-level directory holding all insurance policies
    private InsurancePolicyDirectory insurancePolicyDirectory;

    public PetInsuranceEnterprise(String name) {
        super(name, EnterpriseType.PetInsurance);
         // Initialize directory to avoid null references later
        this.insurancePolicyDirectory = new InsurancePolicyDirectory();
    }

    //  Defines which organization types this enterprise supports.
    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> list = new ArrayList<>();
        list.add(Organization.Type.InsurancePolicy);
        list.add(Organization.Type.InsuranceClaim);
        return list;
    }

   
    public InsurancePolicyDirectory getInsurancePolicyDirectory() {
        return insurancePolicyDirectory;
    }

   
    public void setInsurancePolicyDirectory(InsurancePolicyDirectory insurancePolicyDirectory) {
        this.insurancePolicyDirectory = insurancePolicyDirectory;
    }
}
