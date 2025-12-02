package Business.Enterprise;

import Business.Organization.Organization;
import Business.Pet.InsurancePolicyDirectory;   // ✅ 新增 import
import java.util.ArrayList;

/**
 * Enterprise for pet insurance.
 * 负责管理：
 *  - 两个 Organization（InsurancePolicy / InsuranceClaim）
 *  - 自己名下的所有 InsurancePolicyDirectory（保单目录）
 */
public class PetInsuranceEnterprise extends Enterprise {

    // ✅ 新增：这个保险企业下维护的所有保单
    private InsurancePolicyDirectory insurancePolicyDirectory;

    public PetInsuranceEnterprise(String name) {
        super(name, EnterpriseType.PetInsurance);

        // ✅ 初始化保单目录，避免后面 NPE
        this.insurancePolicyDirectory = new InsurancePolicyDirectory();
    }

    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> list = new ArrayList<>();
        list.add(Organization.Type.InsurancePolicy);
        list.add(Organization.Type.InsuranceClaim);
        return list;
    }

    // ✅ 给外部（例如 UI）提供访问入口
    public InsurancePolicyDirectory getInsurancePolicyDirectory() {
        return insurancePolicyDirectory;
    }

    // （可选）如果以后需要替换整个目录，可以加一个 setter
    public void setInsurancePolicyDirectory(InsurancePolicyDirectory insurancePolicyDirectory) {
        this.insurancePolicyDirectory = insurancePolicyDirectory;
    }
}
