package Business.WorkQueue;

/**
 * Work request from Vet Doctor to Vet Lab for a lab test.
 */
public class LabTestRequest extends WorkRequest {

    private String testResult;   // lab result text

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
}
