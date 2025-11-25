/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author hanlinyao
 */
public class Network {
    
    //我们模型是简化版本，就是一个ecosystem只有一个network 就是portland
    //然后在portland只有一个宠物托管所/一个宠物医院和一个宠物保险公司
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    public Network(String name) {
        enterpriseDirectory = new EnterpriseDirectory();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    //display network “Portland”
    @Override
    public String toString() {
        return name;   
    }
}

