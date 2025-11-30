/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.EmployeeDirectory;
import Business.Network.Network;
import Business.Pet.PetOwnerDirectory;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author hanlinyao
 */
public class Petsystem {
    // 1. 静态私有属性：用于存储唯一的系统实例 (Singleton)
    private static Petsystem business;
    // 2. 顶级目录和列表
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private ArrayList<Network> networkList; // 用于存储网络列表
    private PetOwnerDirectory petOwnerDirectory; // 新增成员变量
    
    // 3. 公共静态方法：用于获取唯一的系统实例 (getInstance())
    // 确保只有当实例不存在时才创建它
    public static Petsystem getInstance() {
        if (business == null) {
            business = new Petsystem();
        }
        return business;
    }
    // 4. 私有构造函数：阻止外部使用 new Petsystem() 创建实例
    private Petsystem() {
        // 初始化所有顶级目录和列表
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        networkList = new ArrayList<>();
        petOwnerDirectory = new PetOwnerDirectory();
    }
    // 5. Getter 方法：允许访问子目录和列表
    // 新增 getPetOwnerDirectory 方法
    public PetOwnerDirectory getPetOwnerDirectory() {
        return petOwnerDirectory;
    }
    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }
    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }
    
    
    // 6. 辅助方法：添加新网络
    public Network createAndAddNetwork(String name){
        Network network = new Network(name); // 假设 Network 有一个带名称的构造函数
        networkList.add(network);
        networkList.add(network);
        return network;
    }
}
