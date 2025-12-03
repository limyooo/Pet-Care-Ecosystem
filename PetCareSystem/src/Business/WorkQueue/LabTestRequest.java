package Business.WorkQueue;

import Business.Pet.Pet;

/**
 * Work request from Vet Doctor to Vet Lab for a lab test.
 */
public class LabTestRequest extends WorkRequest {
    // 从 4000 开始计数
    private static int counter = 4000;   
    private String testId; 
    private String testResult;   
    private String testStatus;  // Pending / Processing / Completed
    private HealthCareCheckRequest healthCareRequest;
    private Pet pet;

    public LabTestRequest() {
        //inherit from WorkRequest 
        super();            
        counter++;          
        this.testId = "T" + counter;
        this.testStatus = "Pending";   //默认状态
    }
    
    public String getTestId() {
        return testId;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public HealthCareCheckRequest getHealthCareRequest() {
        return healthCareRequest;
    }
    //自动反向绑定：让healthReq 也有 labReq
    public void setHealthCareRequest(HealthCareCheckRequest healthCareRequest) {
        this.healthCareRequest = healthCareRequest;
        
        if (healthCareRequest != null) {
        healthCareRequest.setLabTestRequest(this);
        }
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
    }
    
    

    //display Test ID
    @Override
    public String toString() {
        return testId;
    }
}