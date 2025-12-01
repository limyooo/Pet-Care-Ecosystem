package Business.WorkQueue;

/**
 * Work request for an insurance claim.
 * Created by customer / front desk / clinic and
 * handled by Insurance Claim Organization.
 */
public class InsuranceClaimRequest extends WorkRequest {

    // 自增的 claim 编号
    private static int claimCounter = 2000;

    // 核心字段
    private int claimId;
    private double claimAmount;
    private String claimDecision;
    private HealthCareCheckRequest healthRequest;

    // ======= 为 UI 新增的字段 =======
    private String patientId;        // 患者/病历 ID
    private String policyId;         // 保单号
    private String petName;          // 宠物名
    private String symptom;          // 症状
    private String labResult;        // 检验结果
    private double treatmentCost;    // 治疗费用

    private String insuranceCompany; // 保险公司
    private String coverageLevel;    // 保障等级
    private String expirationDate;   // 到期日（用 String 存就够）

    // 构造方法：自动生成 claimId
    public InsuranceClaimRequest() {
        this.claimId = ++claimCounter;
    }

    // ========== 原有 getter / setter ==========
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
        return healthRequest;
    }

    public void setHealthRequest(HealthCareCheckRequest healthRequest) {
        this.healthRequest = healthRequest;
    }

    // ========== 新增字段的 getter / setter ==========
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String labResult) {
        this.labResult = labResult;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        // 用 claimId 在表格里显示
        return String.valueOf(this.claimId);
    }
}
