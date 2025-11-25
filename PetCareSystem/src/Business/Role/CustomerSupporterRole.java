/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
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
                                 EcoSystem system) {
        // TODO: Replace with actual Customer Support work area panel
        // return new CustomerSupportWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}
