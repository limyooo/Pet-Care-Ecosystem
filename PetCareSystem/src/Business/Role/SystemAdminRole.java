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
public class SystemAdminRole extends Role {

    
    public SystemAdminRole() {
    }
    
    
    @Override
    public String toString() {
        return "System Admin";
    }
   
    // public JPanel createWorkArea(UserAccount account, Organization organization, Enterprise enterprise, Network network, Petsystem system) {
    //     return new SystemAdminWorkAreaJPanel(); 
    // }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                             UserAccount account,
                             Organization organization,
                             Enterprise enterprise,
                             Petsystem business) {

   return new SystemAdminWorkAreaJPanel(business);
}

}
