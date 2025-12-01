package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.CustomerService;
import Business.PetClinicOrganization.FrontDeskOrganization;
import Business.UserAccount.UserAccount;
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
        
        // ⭐ 判断是 Boarding 的 CustomerService 还是 Clinic 的 FrontDesk
        if (organization instanceof CustomerService) {
            // Pet Boarding 的客服 → 跳转到 CustomerServiceJPanel
            return new CustomerServiceJPanel(userProcessContainer, account, 
                    (CustomerService) organization, enterprise, system);
        } else {
            // Pet Clinic 的前台 → 跳转到 FrontDeskManagementJPanel
            return new FrontDeskManagementJPanel(userProcessContainer, account,
                    (FrontDeskOrganization) organization, enterprise);
        }
    }
}