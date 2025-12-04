package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Network.Network;
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

        //1.找保险 enterprise
        PetInsuranceEnterprise insuranceEnterprise = null;

        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent instanceof PetInsuranceEnterprise) {
                    insuranceEnterprise = (PetInsuranceEnterprise) ent;
                    break;
                }
            }
        }

        if (insuranceEnterprise == null) {
            System.out.println("⚠ Warning: No PetInsuranceEnterprise found in system!");
        }

        //2. 根据组织类型返回对应 panel
        if (organization instanceof CustomerService) {

            return new CustomerServiceJPanel(
                    userProcessContainer,
                    account,
                    (CustomerService) organization,
                    enterprise,
                    system
            );

        } else if (organization instanceof FrontDeskOrganization) {

            return new FrontDeskManagementJPanel(userProcessContainer,account,
                    (FrontDeskOrganization) organization,enterprise,
                    insuranceEnterprise   );

        } else {
            System.out.println("Warning: Unknown organization type: " + organization.getClass().getName());
            return null;
        }
    }
}