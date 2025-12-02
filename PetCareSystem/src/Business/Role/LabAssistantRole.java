package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetClinicOrganization.VetLabOrganization;
import Business.UserAccount.UserAccount;
import UI.petClinic.LabAssistantWorkAreaJpanel;
import javax.swing.JPanel;

/**
 * LabAssistntRole:
 * Processes lab test requests and records test results.
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,UserAccount account,
                                 Organization organization,Enterprise enterprise,
                                 Petsystem system) {

        // 确保 organization 是 VetLabOrganization
        VetLabOrganization labOrg = (VetLabOrganization) organization;

        return new LabAssistantWorkAreaJpanel(userProcessContainer,account,labOrg);
    }
}