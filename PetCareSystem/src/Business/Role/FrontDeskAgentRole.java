package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetClinicOrganization.FrontDeskOrganization;
import Business.UserAccount.UserAccount;
import UI.admin.MainJFrame;
import UI.petClinic.FrontDeskManagementJPanel;
import javax.swing.JPanel;

/**
 * FrontDeskAgentRole:
 * Handles patient registration, appointment scheduling and basic triage.
 */
public class FrontDeskAgentRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,UserAccount account,
                             Organization organization,Enterprise enterprise,
                             Petsystem system) {

    return new FrontDeskManagementJPanel(userProcessContainer,account,
            (FrontDeskOrganization) organization, enterprise,
            (MainJFrame) userProcessContainer.getTopLevelAncestor());
            }
}