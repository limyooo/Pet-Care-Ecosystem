package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * ClaimProcessorRole:
 * Reviews and approves or rejects insurance claims.
 */
public class ClaimProcessorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        // TODO: replace with real Claim Processor work area panel
        // return new ClaimProcessorWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}
