package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.CustomerService;
import Business.PetClinicOrganization.FrontDeskOrganization;
import Business.UserAccount.UserAccount;
import UI.admin.MainJFrame;
import UI.petClinic.FrontDeskManagementJPanel;
import javax.swing.JPanel;
import Business.PetBoardingOrganization.CustomerService;
import UI.Boarding.CustomerServiceJPanel;

/**
 * FrontDeskAgentRole:
 * Handles patient registration, appointment scheduling and basic triage.
 */
public class FrontDeskAgentRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,
                                 Organization organization, Enterprise enterprise, Petsystem system) {
        
        // ⭐ 关键：先判断组织类型，再进行强制转换
        if (organization instanceof CustomerService) {
            // Pet Boarding 的客服
            return new CustomerServiceJPanel(userProcessContainer, account,
                    (CustomerService) organization, enterprise, system);
        } else if (organization instanceof FrontDeskOrganization) {
            // Pet Clinic 的前台
            return new FrontDeskManagementJPanel(userProcessContainer, account,
                    (FrontDeskOrganization) organization, enterprise);
        } else {
            // 默认情况（不应该发生）
            System.out.println("Warning: Unknown organization type for FrontDeskAgentRole: " 
                    + organization.getClass().getName());
            return null;
        }
    }
}