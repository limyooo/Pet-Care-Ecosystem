/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Pet;

/**
 *
 * @author jingyangwang
 */
public class InsurancePolicy {
    
    //set the insurance policy attributes
    private String policyId;
    private String provider;
    private String coverageType;
    private String startDate;
    private String endDate;
    private double premium;
    
    private Pet pet;
    
    
    //Constructor 
    public InsurancePolicy(){
    }
    
    public InsurancePolicy(String policyId, String provider, String coverageType,
                           String startDate, String endDate, double premium, Pet pet){
        
        this.policyId = policyId;
        this.provider = provider;
        this.coverageType = coverageType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.pet = pet;
    }
    //getter and setter method
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
    //ui to display policyId
    @Override
    public String toString() {
        return policyId;  
    }
}
