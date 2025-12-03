package Business.WorkQueue;

import Business.Pet.Pet;
import Business.UserAccount.UserAccount;

/**
 * Request for a general health check of a pet.
 * For example: from Pet Boarding to Pet Clinic.
 */
public class HealthCareCheckRequest extends WorkRequest {
    
    public static final String STATUS_PENDING_DOCTOR = "Pending Doctor Assignment";
    public static final String STATUS_ASSIGNED_DOCTOR = "Assigned to Doctor";
    public static final String STATUS_IN_LAB = "In Lab";
    public static final String STATUS_LAB_COMPLETED = "Lab Completed";
    public static final String STATUS_TREATMENT_COMPLETED = "Treatment Completed";
    
    //messsage and sender has been providede by work request父类
    //patient ID 从 1001 开始
    private static int counter = 1000; 
    private String patientId;
    private String symptom;
    private String assignedDoctor;
    private String labResult;
    private String checkResult;  // doctor's conclusion for the check
    //添加pet之后request就可以携带宠物资料
    private Pet pet;
    private UserAccount labAssistant;   
    private String boardingRecordId;
    private String treatmentNeeded;
    private double treatmentCost;
    private LabTestRequest labTestRequest;
    
    
    //Constructor：create new patientId
    
    //getter 和 setter
    public String getBoardingRecordId() {
        return boardingRecordId;
    }
    
    public void setBoardingRecordId(String boardingRecordId) {
        this.boardingRecordId = boardingRecordId;
    }
    
    public HealthCareCheckRequest() {
        this.patientId = String.valueOf(++counter);
        this.setStatus(STATUS_PENDING_DOCTOR);   //defautlt setting:等待分配医生
    }
    
    public String getPatientId() {
        return patientId;
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
    
    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
   
    public Pet getPet() { 
        return pet; 
    }
    
    public void setPet(Pet pet) {
        this.pet = pet; 
    }

    public UserAccount getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(UserAccount labAssistant) {
        this.labAssistant = labAssistant;
    }

    public String getTreatmentNeeded() {
        return treatmentNeeded;
    }

    public void setTreatmentNeeded(String treatmentNeeded) {
        this.treatmentNeeded = treatmentNeeded;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    public LabTestRequest getLabTestRequest() {
        return labTestRequest;
    }

    public void setLabTestRequest(LabTestRequest labTestRequest) {
        this.labTestRequest = labTestRequest;
    }
   
    @Override
        public String toString() {
        return String.valueOf(patientId);
    }
}
