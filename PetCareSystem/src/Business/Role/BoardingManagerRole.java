package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetBoardingOrganization.BoardingServiceOrganization;
import Business.UserAccount.UserAccount;
import UI.Boarding.WelcomJpanel;
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
                                 Petsystem system) {
        // TODO: replace with real Boarding Manager work area panel
        // return new BoardingManagerWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
       // 1. 将 Organization 强制转换为 BoardingServiceOrganization
        BoardingServiceOrganization boardingOrg = (BoardingServiceOrganization) organization;

        // 2. 返回目标工作区面板 (WelcomJPanel)
        // 注意：WelcomJPanel 的构造函数必须匹配这些参数
        return new WelcomJpanel(userProcessContainer, account, boardingOrg, enterprise, system);
        
    }
}