package Business.WorkQueue;

/**
 * Request for a general health check of a pet.
 * For example: from Pet Boarding to Pet Clinic.
 */
public class HealthCareCheckRequest extends WorkRequest {
    
    //messsage and sender has been providede by work request父类
    private int patientId;
    private String symptom;
    private String assignedDoctor;
    private String labResult;
    private String insuranceClaimRequest;
    private String checkResult;  // doctor's conclusion for the check

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(String assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String labResult) {
        this.labResult = labResult;
    }

    public String getInsuranceClaimRequest() {
        return insuranceClaimRequest;
    }

    public void setInsuranceClaimRequest(String insuranceClaimRequest) {
        this.insuranceClaimRequest = insuranceClaimRequest;
    }
    
    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
   
    @Override
    public String toString() {
        return String.valueOf(this.patientId);
    }
}
