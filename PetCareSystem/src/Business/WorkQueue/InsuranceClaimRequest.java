package Business.WorkQueue;

import Business.Pet.Pet;
import Business.Pet.PetOwner;

/**
 * InsuranceClaimRequest:
 * Represents one insurance claim submitted for review.
 */

public class InsuranceClaimRequest extends WorkRequest {

    private static int claimCounter = 2000;  // Auto-increment ID

    // Basic Claim Info
    private int claimId;              // Unique claim ID
    private double claimAmount;       // Final approved amount
    private String claimDecision;     // Approved / Rejected / Pending
    private HealthCareCheckRequest healthRequest; // Linked medical checkup (if any)

    // Display Fields (shown in tables/UI)
    private String holderName;  
    private String patientId;       
    private String policyId;      
    private String petName;         
    private String symptom;          
    private String labResult;        
    private double treatmentCost;   

    // Insurance-related info
    private String insuranceCompany;  
    private String coverageLevel;     
    private String expirationDate;  

    // Coverage Decision (Full / Partial)
    private String coverageDecision;  // Full Coverage / Partial Coverage / No Coverage
    private Pet pet;
    private PetOwner owner;
    
    // Medical Detail
    private String doctorName;        // Doctor Assigned
    private String treatmentNeeded;   

    
    public InsuranceClaimRequest() {
        this.claimId = ++claimCounter; // auto-generate claim id
    }

    
    public int getClaimId() {
        return claimId;
    }

    
    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    
    public String getClaimDecision() {
        return claimDecision;
    }

    public void setClaimDecision(String claimDecision) {
        this.claimDecision = claimDecision;
    }

    
    public HealthCareCheckRequest getHealthRequest() {
        return healthRequest;
    }

    public void setHealthRequest(HealthCareCheckRequest healthRequest) {
        this.healthRequest = healthRequest;
    }

    
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    
    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    
    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String labResult) {
        this.labResult = labResult;
    }

    
    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    
    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
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

    
    public String getCoverageDecision() {
        return coverageDecision;
    }

    public void setCoverageDecision(String coverageDecision) {
        this.coverageDecision = coverageDecision;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTreatmentNeeded() {
        return treatmentNeeded;
    }

    public void setTreatmentNeeded(String treatmentNeeded) {
        this.treatmentNeeded = treatmentNeeded;
    }

    
    @Override
    public String toString() {
    return patientId != null ? patientId : String.valueOf(claimId);
}

}
