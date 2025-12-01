/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.PetBoardingOrganization;

import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.FrontDeskAgentRole;
import java.util.ArrayList;

/**
 * Pet Boarding 的 Customer Service 组织
 * 负责联系客户
 * @author hanlinyao
 */
public class CustomerService extends Organization{
    

    public CustomerService() {
        super("Customer Service");  // 直接使用字符串，避免枚举问题
    }
    
    public CustomerService(String name) {
        super(name);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new FrontDeskAgentRole());
        return roles;
    }
    
}
