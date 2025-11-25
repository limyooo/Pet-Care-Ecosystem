/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

/**
 *
 * @author jingyangwang
 */
public class PetOwner {
    
    //petOwner's attributes
    private String ownerId;
    private String ownerName;
    private String phone;
    private String email;
    private String address;
    private String emergencyContact;
    
    //constructor
    public PetOwner() {
    }

    public PetOwner(String ownerId, String ownerName, String phone, String email, String address, String emergencyContact) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.emergencyContact = emergencyContact;
    }
    //getter and setter method
    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }
    /* 暂时不确定干啥的
    @Override
    public String toString() {
        return name;  // 供 UI 表格 / 下拉框显示名字
    }
    */
}
