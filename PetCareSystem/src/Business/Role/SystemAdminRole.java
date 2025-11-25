/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import UI.admin.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author hanlinyao
 */
public class SystemAdminRole extends Role { // <--- 关键：必须继承 Role

    // 默认构造函数（您已经写了）
    public SystemAdminRole() {
    }
    
    // 最佳实践：重写 toString() 以便在UI组件中显示正确的角色名
    @Override
    public String toString() {
        return "System Admin";
    }
    
    /*
     * 业务逻辑：根据框架惯例，Role 类通常需要一个方法
     * 来返回该角色对应的JPanel工作区，例如 SystemAdminWorkAreaJPanel。
     * * 如果您的 Role 基类将来会包含一个抽象方法来创建工作区，
     * 您可能需要实现类似以下的方法：
     */
    
    // public JPanel createWorkArea(UserAccount account, Organization organization, Enterprise enterprise, Network network, Petsystem system) {
    //     return new SystemAdminWorkAreaJPanel(); 
    // }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             Petsystem business) {

    return null;//创建UI面板之后再补充
}

}
