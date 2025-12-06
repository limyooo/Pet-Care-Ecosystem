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
    
    //The ecosystem has only one network - Portland
    //one pet boarding facility / one pet clinic and one pet insurance company
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    
    
    public Network(String name) {
        this.name = name;
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

