package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetBoardingOrganization.BoardingServiceOrganization;
import Business.UserAccount.UserAccount;
import UI.Boarding.WelcomJpanel;
import javax.swing.JPanel;

/**
 * Role for Pet Care Taker.
 */
public class PetCareTakerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise, Petsystem system) {
        
        // ⭐ Pet Care Taker 的工作区就是 WelcomJpanel
        return new WelcomJpanel(userProcessContainer, account, (BoardingServiceOrganization) organization, enterprise, system);
    }
    }
