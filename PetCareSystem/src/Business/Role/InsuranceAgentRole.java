package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.Insurance.AgentWorkAreaJPanel;   // ⭐ 记得加这个 import
import javax.swing.JPanel;

/**
 * InsuranceAgentRole:
 * Defines the role of an Insurance Agent who manages policy creation and maintenance.
 */
public class InsuranceAgentRole extends Role {

    
    // Creates the main work area UI for the insurance agent.(AgentWorkAreaJPanel)
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             Petsystem system) {
    // Return the UI panel for Insurance Agent
    return new AgentWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
}
}
