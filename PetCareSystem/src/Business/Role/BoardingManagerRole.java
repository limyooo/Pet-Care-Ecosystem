package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetBoardingOrganization.BoardingServiceOrganization;
import Business.UserAccount.UserAccount;
import UI.Boarding.ManagerJPanel;
import UI.Boarding.WelcomJpanel;
import javax.swing.JPanel;

/**
 * BoardingManagerRole:
 * Manages boarding reservations, capacity and overall operations.
 */
public class BoardingManagerRole extends Role {

   @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,
            Organization organization, Enterprise enterprise, Petsystem system) {
        
        // ⭐ 返回 Boarding Manager 的工作区面板
        return new ManagerJPanel(userProcessContainer, account, organization, enterprise, system);
    }
    
    @Override
    public String toString() {
        return "Boarding Manager";
    }
}