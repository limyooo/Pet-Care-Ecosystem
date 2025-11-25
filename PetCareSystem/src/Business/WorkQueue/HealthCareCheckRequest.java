package Business.WorkQueue;

/**
 * Request for a general health check of a pet.
 * For example: from Pet Boarding to Pet Clinic.
 */
public class HealthCareCheckRequest extends WorkRequest {

    private String checkResult;  // doctor's conclusion for the check

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }
}
