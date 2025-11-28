package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

public class EnterpriseAdminRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem business) {
        // 以后如果要给 Enterprise Admin 单独做一个工作区面板
        // 比如 EnterpriseAdminWorkAreaJPanel，就在这里 new 那个面板
        // return new EnterpriseAdminWorkAreaJPanel(...);

        return null;  // 目前先返回 null，占个位置就行
    }

    @Override
    public String toString() {
        return "Enterprise Admin";
    }
}
