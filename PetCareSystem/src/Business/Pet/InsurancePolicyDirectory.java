package Business.Pet;

import java.util.ArrayList;


public class InsurancePolicyDirectory {
    // List of all policies
    private ArrayList<InsurancePolicy> policyList = new ArrayList<>();

    
    public InsurancePolicyDirectory() {
    }

    // Get the full policy list.
    public ArrayList<InsurancePolicy> getPolicyList() {
        return policyList;
    }

    
    // Create and add a new policy
                public InsurancePolicy addPolicy(
                String policyId,
                String provider,
                String coverageType,
                String startDate,
                String endDate,
                double premium,
                String status,
                Pet pet,
                PetOwner owner
        ) {

            InsurancePolicy policy = new InsurancePolicy(
                    policyId,
                    provider,
                    coverageType,
                    startDate,
                    endDate,
                    premium,
                    status,
                    pet,
                    owner
            );

            policyList.add(policy);
            return policy;
        }



    // Add an existing policy object.
    public void addPolicy(InsurancePolicy policy) {
        policyList.add(policy);
    }

    // Remove a policy.
    public void removePolicy(InsurancePolicy policy) {
        policyList.remove(policy);
    }

    // Search policy by ID.
    public InsurancePolicy findPolicyById(String policyId) {
        for (InsurancePolicy policy : policyList) {
            if (policy.getPolicyId().equals(policyId)) {
                return policy;
            }
        }
        return null;
    }
}
