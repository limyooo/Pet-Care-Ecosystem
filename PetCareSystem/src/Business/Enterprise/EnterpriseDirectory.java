package Business.Enterprise;

import java.util.ArrayList;

/**
 * EnterpriseDirectory:
 * Holds all enterprises under a Network.
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    /**
     * Factory method to create an enterprise based on type and add it to the list.
     */
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {

        Enterprise enterprise = null;

        if (type == Enterprise.EnterpriseType.PetBoarding) {
            enterprise = new PetBoardingEnterprise(name);
        } else if (type == Enterprise.EnterpriseType.PetClinic) {
            enterprise = new PetClinicEnterprise(name);
        } else if (type == Enterprise.EnterpriseType.PetInsurance) {
            enterprise = new PetInsuranceEnterprise(name);
        }

        if (enterprise != null) {
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
}
