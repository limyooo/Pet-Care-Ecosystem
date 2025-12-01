package Business.WorkQueue;

/**
 * Work request for an insurance claim.
 * Created by customer / front desk / clinic and
 * handled by Insurance Claim Organization.
 */
public class InsuranceClaimRequest extends WorkRequest {

    private static int claimCounter = 2000;  

    private double claimAmount;
    private String claimDecision;
    private int claimId;
    private HealthCareCheckRequest healthRequest;

    public InsuranceClaimRequest() {
        this.claimId = ++claimCounter;   
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
        return healthRequest; }

    public void setHealthRequest(HealthCareCheckRequest req) { 
        this.healthRequest = req; }
    

    @Override
    public String toString() {
        return String.valueOf(this.claimId);
    }
}
