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

    // ======= 为 UI 新增的字段 =======
    private String patientId;        // 患者/病历 ID
    private String policyId;         // 保单号
    private String petName;          // 宠物名
    private String symptom;          // 症状
    private String labResult;        // 检验结果
    private double treatmentCost;    // 治疗费用
    
    private String insuranceCompany;   // 保险公司
    private String coverageLevel;      // 保障等级
    private String expirationDate;     // 到期日（用 String 存就够）

    // ======= 原来的 getter/setter =======
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
