package Business.Pet;

import java.util.ArrayList;

/**
 * InsurancePolicyDirectory:
 * 管理所有宠物保险保单（InsurancePolicy）。
 */
public class InsurancePolicyDirectory {

    private ArrayList<InsurancePolicy> policyList = new ArrayList<>();

    // Constructor
    public InsurancePolicyDirectory() {
    }

    // 获取所有保单
    public ArrayList<InsurancePolicy> getPolicyList() {
        return policyList;
    }

    // ============================
    // 创建新保单（完整版本）
    // ============================
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



    // 添加已有保单对象
    public void addPolicy(InsurancePolicy policy) {
        policyList.add(policy);
    }

    // 删除保单
    public void removePolicy(InsurancePolicy policy) {
        policyList.remove(policy);
    }

    // 根据保单号查找
    public InsurancePolicy findPolicyById(String policyId) {
        for (InsurancePolicy policy : policyList) {
            if (policy.getPolicyId().equals(policyId)) {
                return policy;
            }
        }
        return null;
    }
}
