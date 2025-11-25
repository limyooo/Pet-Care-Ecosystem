/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.Employee;
import Business.UserAccount.UserAccount;
import Business.Role.SystemAdminRole;

/**
 *
 * @author hanlinyao
 */
public class ConfigureABusiness {
    public static Petsystem configure(){ 
        
        // 1. 获取系统单例实例
        // 此步骤依赖于 Petsystem.java 中已实现的 Singleton 模式 (getInstance() 方法)。
        Petsystem system = Petsystem.getInstance();
        
        // 2. 创建一个系统管理员员工
        // 调用 Petsystem -> EmployeeDirectory.createEmployee()
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        
        // 3. 为系统管理员创建用户账户 (用户名: sysadmin, 密码: sysadmin)
        // 调用 Petsystem -> UserAccountDirectory.createUserAccount()
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "1234", employee, new SystemAdminRole());
        
        // 您可以在这里继续添加其他初始化逻辑，例如创建网络、企业等。
        
        return system;
    }
    
    
    
}
