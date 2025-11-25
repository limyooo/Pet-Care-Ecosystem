/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

import java.util.ArrayList;

/**
 *
 * @author jingyangwang
 */
public class InsurancePolicyDirectory {
    
    private ArrayList<InsurancePolicy> policyList = new ArrayList<>();
    
    //Constructor
    public InsurancePolicyDirectory(){
        
    }
    //get Policy list method
    public ArrayList<InsurancePolicy> getPolicyList() {
        return policyList;
    }
    
    //add new policy method to the list
    public InsurancePolicy addPolicy(String policyId, String provider, String coverageType,
                                     String startDate, String endDate, double premium, 
                                     Pet pet) {

        InsurancePolicy policy = new InsurancePolicy(policyId, provider, coverageType,
                                                     startDate, endDate, premium, pet);

        policyList.add(policy);
        return policy;
    }
    //add existing policy from list
    public void addPolicy(InsurancePolicy policy) {
        policyList.add(policy);
    }

    //remove existing policy from list
    public void removePolicy(InsurancePolicy policy) {
        policyList.remove(policy);
    }

    //search by policyId
    public InsurancePolicy findPolicyById(String policyId) {
        for (InsurancePolicy policy : policyList) {
            if (policy.getPolicyId().equals(policyId)) {
                return policy;
            }
        }
        return null;
    }
}

