package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;

import java.util.ArrayList;

/**
 * Enterprise represents a high-level business unit (company).
 * Each enterprise contains multiple organizations.
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public Enterprise(String name, EnterpriseType type) {
        super(name); // Call Organization constructor
        this.enterpriseType = type;
        this.organizationDirectory = new OrganizationDirectory();
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    /**
     * Enterprise categories.
     */
    public enum EnterpriseType {
        PetBoarding("Pet Boarding Enterprise"),
        PetClinic("Pet Clinic Enterprise"),
        PetInsurance("Pet Insurance Enterprise");

        private String value;

        EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Subclasses must define: which Organization types this Enterprise supports.
     * 子类必须定义：该 Enterprise 支持哪些 Organization 类型
     */
    public abstract ArrayList<Organization.Type> getSupportedOrganizationTypes();


    /**
     * Enterprise 本身通常不直接拥有 Role。
     * All Roles are implemented within Organizations. 所有 Role 都是在 Organization 里面实现的。
     */
    @Override
    public ArrayList<Role> getSupportedRole() {
        return new ArrayList<>();
    }
    
    @Override
    public String toString() {
    return getName();
}

}