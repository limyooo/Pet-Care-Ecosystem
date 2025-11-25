package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * LabAssistntRole:
 * Processes lab test requests and records test results.
 */
public class LabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem system) {
        // TODO: replace with real Lab Assistant work area panel
        // return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}