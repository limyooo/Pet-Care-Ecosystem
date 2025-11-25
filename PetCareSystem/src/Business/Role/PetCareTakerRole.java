package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * Role for Pet Care Taker.
 */
public class PetCareTakerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,
            Organization organization, Enterprise enterprise, Petsystem system) {
        
        // 现在返回 null，等写UIPanel再改
        return null;
    }
}