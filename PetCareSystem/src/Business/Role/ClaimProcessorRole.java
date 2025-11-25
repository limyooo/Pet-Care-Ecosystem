package Business.Role;


import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Petsystem;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

public class ClaimProcessorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem system) {
        // TODO: replace with real Claim Processor work area panel
        // return new ClaimProcessorWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}
