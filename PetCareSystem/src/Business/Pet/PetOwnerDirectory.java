/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

import java.util.ArrayList;

/**
 *
 * @author jingyangwang
 */
public class PetOwnerDirectory {
     private ArrayList<PetOwner> ownerList = new ArrayList<>();
    
    //Constructor
    public PetOwnerDirectory(){
    }
    //get ownerlist method
    public ArrayList<PetOwner> getOwnerList(){
        return ownerList;
    }
    //get addowner method
    public PetOwner addOwner(String ownerId, String name, String phone, String email, 
                             String address, String emergencyContact,
                             String insuranceCompany, String policyId, 
                             String coverageLevel, String expirationDate) {
        PetOwner owner = new PetOwner(ownerId, name, phone, email, address, emergencyContact,
                                      insuranceCompany, policyId, coverageLevel, expirationDate);
        ownerList.add(owner);
        return owner;
    }
    //remove owner method
    public void removeOwner(PetOwner owner) {
        ownerList.remove(owner);
    }
    
    //search method by ownerId
    public PetOwner findOwnerById(String ownerId) {
        for (PetOwner owner : ownerList) {
            if (owner.getOwnerId().equals(ownerId)) {
                return owner;
            }
        }
        return null;
    }
}
