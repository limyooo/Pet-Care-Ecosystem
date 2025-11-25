package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * BoardingManagerRole:
 * Manages boarding reservations, capacity and overall operations.
 */
public class BoardingManagerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 EcoSystem system) {
        // TODO: replace with real Boarding Manager work area panel
        // return new BoardingManagerWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}
