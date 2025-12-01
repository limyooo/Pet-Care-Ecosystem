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
    
    private String insuranceCompany;
    private String policyId;
    private String coverageLevel;
    private String expirationDate;
    
    private PetDirectory petDirectory; // 新增成员变量
    
    //constructor
    public PetOwner() {
        petDirectory = new PetDirectory(); // 初始化
    }

    public PetOwner(String ownerId, String ownerName, String phone,
                String email, String address, String emergencyContact,
                String insuranceCompany, String policyId,
                String coverageLevel, String expirationDate) {

        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.emergencyContact = emergencyContact;

        this.insuranceCompany = insuranceCompany;
        this.policyId = policyId;
        this.coverageLevel = coverageLevel;
        this.expirationDate = expirationDate;

        this.petDirectory = new PetDirectory();
    }
    //getter and setter method
    // 新增 getPetDirectory 方法
    public PetDirectory getPetDirectory() {
        return petDirectory;
    }
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
    
    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
       
    /* 暂时不确定干啥的
    @Override
    public String toString() {
        return name;  // 供 UI 表格 / 下拉框显示名字
    }
    */
}
