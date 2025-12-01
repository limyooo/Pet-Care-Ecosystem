package Business.WorkQueue;
import Business.Pet.Pet;
import Business.Pet.PetOwner;

/**
 * Work request for an insurance claim.
 * Created by customer / front desk / clinic and
 * handled by Insurance Claim Organization.
 */
public class InsuranceClaimRequest extends WorkRequest {

    private static int claimCounter = 2000;  // 自增的理赔单号

    // ===== 基本理赔信息 =====
    private int claimId;              // 理赔编号（唯一）
    private double claimAmount;       // 理赔金额
    private String claimDecision;     // 审批结果：Approved / Rejected / Pending
    private HealthCareCheckRequest healthRequest; // 关联的健康检查请求（如果有）

    // ===== 展示在 Claim 列表 / 明细里的字段 =====
    private String holderName;        // 宠物主人名字（你新加的）
    private String patientId;         // 患者/病历 ID
    private String policyId;          // 保单号
    private String petName;           // 宠物名
    private String symptom;           // 症状
    private String labResult;         // 检验结果
    private double treatmentCost;     // 治疗费用

    // ===== 保险相关信息 =====
    private String insuranceCompany;  // 保险公司
    private String coverageLevel;     // 保障等级：Basic / Standard / Premium
    private String expirationDate;    // 保单到期日（String 存就够）

    // ===== 你新加的“全保/半保” 决策 =====
    private String coverageDecision;  // 全保 / 半保 / Pending 等
    private Pet pet;
    private PetOwner owner;

    public InsuranceClaimRequest() {
        this.claimId = ++claimCounter;
    }

    // ---------- claimId ----------
    public int getClaimId() {
        return claimId;
    }

    // ---------- claimAmount ----------
    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    // ---------- claimDecision ----------
    public String getClaimDecision() {
        return claimDecision;
    }

    public void setClaimDecision(String claimDecision) {
        this.claimDecision = claimDecision;
    }

    // ---------- healthRequest ----------
    public HealthCareCheckRequest getHealthRequest() {
        return healthRequest;
    }

    public void setHealthRequest(HealthCareCheckRequest healthRequest) {
        this.healthRequest = healthRequest;
    }

    // ---------- holderName ----------
    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    // ---------- patientId ----------
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    // ---------- policyId ----------
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    // ---------- petName ----------
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    // ---------- symptom ----------
    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    // ---------- labResult ----------
    public String getLabResult() {
        return labResult;
    }

    public void setLabResult(String labResult) {
        this.labResult = labResult;
    }

    // ---------- treatmentCost ----------
    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    // ---------- insuranceCompany ----------
    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    // ---------- coverageLevel ----------
    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    // ---------- expirationDate ----------
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    // ---------- coverageDecision（全保 / 半保） ----------
    public String getCoverageDecision() {
        return coverageDecision;
    }

    public void setCoverageDecision(String coverageDecision) {
        this.coverageDecision = coverageDecision;
    }

        // ===== 关联对象：直接挂 Pet / PetOwner =====
   

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public PetOwner getOwner() {
        return owner;
    }

    public void setOwner(PetOwner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.valueOf(this.claimId);
    }
}
