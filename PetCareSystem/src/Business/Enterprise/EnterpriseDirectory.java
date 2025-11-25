package Business.Enterprise;

import Business.Enterprise.PetBoardingEnterprise;
import Business.Enterprise.PetClinicEnterprise;
import Business.Enterprise.PetInsuranceEnterprise;

import java.util.ArrayList;

/**
 * EnterpriseDirectory:
 * Holds all enterprises under a Network / EcoSystem.
 */
public class EnterpriseDirectory {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

}
