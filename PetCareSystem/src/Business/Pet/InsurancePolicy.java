package Business.Pet;

import Business.Pet.PetOwner;

/**
 * InsurancePolicy:
 * 代表一份宠物保险保单。
 */
public class InsurancePolicy {

    // ====== 保单基础信息 ======
    private String policyId;       // 保单号，例如 PL1234
    private String provider;       // 保险公司/机构名称，例如 "Happy Paws Insurance"

    // 保障类型（比如 Medical / Accident 等，大类）
    private String coverageType;

    // 保障等级（比如 Basic / Standard / Premium），对齐你 UI 里的 CoverageLevel
    private String coverageLevel;

    // 生效日期 & 终止日期（可以先用 String 存，后面有时间再改成 Date）
    private String startDate;
    private String endDate;

    // 保费（如果暂时不用，也可以先保留着）
    private double premium;

    // 当前保单状态：Active / Expired / Cancelled / Pending 等
    private String status;

    // ====== 关联对象 ======
    private Pet pet;           // 被保宠物
    private PetOwner owner;    // 投保人（宠物主人）

    // ====== 构造方法 ======
    public InsurancePolicy(
    String policyId,
    String provider,
    String coverageType,
    String startDate,
    String endDate,
    double premium,
    String status,
    Pet pet,
    PetOwner owner
) {
    this.policyId = policyId;
    this.provider = provider;
    this.coverageType = coverageType;
    this.startDate = startDate;
    this.endDate = endDate;
    this.premium = premium;
    this.status = status;
    this.pet = pet;
    this.owner = owner;
}


    // ====== Getter / Setter ======
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public String getCoverageLevel() {
        return coverageLevel;
    }

    public void setCoverageLevel(String coverageLevel) {
        this.coverageLevel = coverageLevel;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    // UI 里下拉框/表格默认展示保单号
    @Override
    public String toString() {
        return policyId;
    }
}
