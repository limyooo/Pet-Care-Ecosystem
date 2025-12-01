package Business.WorkQueue;

import Business.Pet.Pet;

/**
 * Work request from Vet Doctor to Vet Lab for a lab test.
 */
public class LabTestRequest extends WorkRequest {

    private String testResult;   
    private HealthCareCheckRequest healthCareRequest;
    private Pet pet;

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
    
}
