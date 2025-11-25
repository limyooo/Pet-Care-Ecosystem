package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * FrontDeskAgentRole:
 * Handles patient registration, appointment scheduling and basic triage.
 */
public class FrontDeskAgentRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem system) {
        // TODO: replace with real Front Desk work area panel
        // return new FrontDeskAgentWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}