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
import Business.Pet.InsurancePolicyDirectory;


/**
 *
 * @author hanlinyao
 */
public class Petsystem {
    
    private static Petsystem business;
   
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private ArrayList<Network> networkList; 
    private PetOwnerDirectory petOwnerDirectory; 
    private InsurancePolicyDirectory insurancePolicyDirectory;
    
    
    public static Petsystem getInstance() {
        if (business == null) {
            business = new Petsystem();
        }
        return business;
    }
    
    
    private Petsystem() {
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        networkList = new ArrayList<>();
        petOwnerDirectory = new PetOwnerDirectory();
        insurancePolicyDirectory = new InsurancePolicyDirectory();
    }
   
    
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

    public static Petsystem getBusiness() {
        return business;
    }

    public InsurancePolicyDirectory getInsurancePolicyDirectory() {
        return insurancePolicyDirectory;
    }
    
    
    // adds a new network
    public Network createAndAddNetwork(String name){
        Network network = new Network(name);
        networkList.add(network);
       
        return network;
    }
}
