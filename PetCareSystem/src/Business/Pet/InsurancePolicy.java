package Business.Pet;

import Business.Pet.PetOwner;


public class InsurancePolicy {

    private String policyId;   
    private String provider;    
    private String coverageType; // Full Coverage / Partial Coverage
    private String startDate;
    private String endDate;
    private double premium;
    private String status; // Active / Expired / Cancelled
    private Pet pet;          
    private PetOwner owner; // Policy holder   

    
    public InsurancePolicy(
        String policyId,
        String provider,
        String coverageType,  
        String startDate,
        String endDate,
        double premium,
        String status,
        Pet pet,
        PetOwner owner
    ) {
        this.policyId = policyId;
        this.provider = provider;
        this.coverageType = coverageType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premium = premium;
        this.status = status;
        this.pet = pet;
        this.owner = owner;
    }

    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public PetOwner getOwner() {
        return owner;
    }

    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }

    // Default display in UI components like combo boxes or tables.
    @Override
    public String toString() {
        return policyId;
    }
}
