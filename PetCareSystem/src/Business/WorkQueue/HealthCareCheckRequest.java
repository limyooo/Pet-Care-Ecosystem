package Business.WorkQueue;

import Business.Pet.Pet;
import Business.UserAccount.UserAccount;

/**
 * Request for a general health check of a pet.
 * For example: from Pet Boarding to Pet Clinic.
 */
public class HealthCareCheckRequest extends WorkRequest {
    
    //messsage and sender has been providede by work request父类
    //patient ID 从 1001 开始
    private static int counter = 1000; 
    private int patientId;
    private String symptom;
    private String assignedDoctor;
    private String labResult;
    private String checkResult;  // doctor's conclusion for the check
    //添加pet之后request就可以携带宠物资料
    private Pet pet;
    private UserAccount labAssistant;
    
    // ⭐ 新增字段
    private String boardingRecordId;
    
    //Constructor：create new patientId
    
    // ⭐ 新增 getter 和 setter
    public String getBoardingRecordId() {
        return boardingRecordId;
    }
    
    public void setBoardingRecordId(String boardingRecordId) {
        this.boardingRecordId = boardingRecordId;
    }
    
    public HealthCareCheckRequest() {
        this.patientId = ++counter;  
    }
    
    public int getPatientId() {
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
    
    @Override
    public String toString() {
        return String.valueOf(this.patientId);
    }
}
