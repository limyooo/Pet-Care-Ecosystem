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
    private HealthCareCheckRequest healthCareRequest;
    private Pet pet;

    public LabTestRequest() {
        //inherit from WorkRequest 
        super();            
        counter++;          
        this.testId = "T" + counter;
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

    public void setHealthCareRequest(HealthCareCheckRequest healthCareRequest) {
        this.healthCareRequest = healthCareRequest;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    //display Test ID
    @Override
    public String toString() {
        return testId;
    }
}