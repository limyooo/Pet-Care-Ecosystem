package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UI.Insurance.AgentWorkAreaJPanel;   // ⭐ 记得加这个 import
import javax.swing.JPanel;

public class InsuranceAgentRole extends Role {

    @Override
public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             Petsystem system) {
    return new AgentWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
}
}
