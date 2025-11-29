package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import UI.enterpriseAdmin.EnterpriseAdminWorkAreaJPanel;
import javax.swing.JPanel;

public class EnterpriseAdminRole extends Role {

    @Override
public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             Petsystem business) {

    return new EnterpriseAdminWorkAreaJPanel(
            userProcessContainer,
            account,
            enterprise,
            business
    );
}


    @Override
    public String toString() {
        return "Enterprise Admin";
    }
}
