package Business.PetInsuranceOrganization;

import Business.Organization.Organization;
import Business.Role.InsuranceAgentRole;
import Business.Role.Role;
import Business.Pet.InsurancePolicyDirectory;
import java.util.ArrayList;

/**
 * InsurancePolicyOrganization:
 * 用于管理保单（Policy）的创建、保存、查询。
 */
public class InsurancePolicyOrganization extends Organization {

    // ★★★★★ 关键：每个组织必须有自己的保单目录 ★★★★★
    private InsurancePolicyDirectory policyDirectory;

    public InsurancePolicyOrganization() {
        super("Insurance Policy Organization");
        this.policyDirectory = new InsurancePolicyDirectory(); // 初始化保单目录
    }

    /**
     * 返回该组织的保单目录
     */
    public InsurancePolicyDirectory getPolicyDirectory() {
        return policyDirectory;
    }

    /**
     * 该组织只支持 InsuranceAgentRole
     */
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InsuranceAgentRole());
        return roles;
    }
}
