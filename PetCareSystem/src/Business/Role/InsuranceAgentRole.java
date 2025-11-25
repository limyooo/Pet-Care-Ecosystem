package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * InsuranceAgentRole:
 * Manages insurance policies and helps customers create or update policies.
 */
public class InsuranceAgentRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        // TODO: replace with real Insurance Agent work area panel
        // return new InsuranceAgentWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}
