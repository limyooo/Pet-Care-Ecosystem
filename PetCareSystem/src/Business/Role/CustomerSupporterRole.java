package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * CustomerSupporterRole:
 * Handles customer inquiries, booking support and general assistance
 * for the Boarding Service Organization.
 *
 */
public class CustomerSupporterRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
                                 UserAccount account, 
                                 Organization organization, 
                                 Enterprise enterprise, 
                                 Petsystem system) {
        // TODO: Replace with actual Customer Support work area panel
        // return new CustomerSupportWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}