package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PetBoardingEnterprise;
import Business.Enterprise.PetClinicEnterprise;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Role.SystemAdminRole;
// 下面这些 Role 需要你在 Business.Role 包里自己建（如果暂时没有，可以先注释掉）
import Business.Role.FrontDeskAgentRole;
import Business.Role.PetCareTakerRole;
import Business.Role.BoardingManagerRole;
import Business.Role.VetDoctorRole;
import Business.Role.LabAssistantRole;
import Business.Role.InsuranceAgentRole;
import Business.Role.ClaimProcessorRole;
import Business.Role.EnterpriseAdminRole;
import Business.Pet.Pet;
import Business.Pet.PetOwner;
import Business.Pet.InsurancePolicyDirectory;


import Business.UserAccount.UserAccount;
import Business.WorkQueue.CompensationNotificationRequest;
import Business.WorkQueue.HealthCareCheckRequest;
import Business.WorkQueue.InsuranceClaimRequest;
import Business.WorkQueue.LabTestRequest;

import com.github.javafaker.Faker;

// 导入新增的 Pet 相关类
import Business.Pet.Pet;
import Business.Pet.PetOwner;
import Business.Pet.PetDirectory;
import Business.Pet.PetOwnerDirectory;
import Business.Pet.PetBoardingRecord;
import Business.Pet.BoardingRecordDirectory;
import Business.Pet.InsurancePolicy;

public class ConfigureABusiness {

    public static Petsystem configure() {

        // 1. 获取唯一系统实例
        Petsystem system = Petsystem.getInstance();
        
        InsurancePolicyDirectory policyDir = system.getInsurancePolicyDirectory();
        // ⭐ 关键修正：检查是否已经配置过数据。如果系统中的 Network 列表不为空，则直接返回。
        if (!system.getNetworkList().isEmpty()) {
            return system; 
        }

        // Java Faker：用于生成随机测试数据
        Faker faker = new Faker();

        // 2. 创建一个 Network：Portland
        Network petNetwork = system.createAndAddNetwork("Portland");
        petNetwork.setName("Portland");

        // 3. 在该 Network 中创建 3 个 Enterprise
        PetBoardingEnterprise boardingEnt =
                (PetBoardingEnterprise) petNetwork.getEnterpriseDirectory()
                        .createAndAddEnterprise(
                                "Happy Paws Boarding",
                                Enterprise.EnterpriseType.PetBoarding);

        PetClinicEnterprise clinicEnt =
                (PetClinicEnterprise) petNetwork.getEnterpriseDirectory()
                        .createAndAddEnterprise(
                                "Happy Paws Clinic",
                                Enterprise.EnterpriseType.PetClinic);

        PetInsuranceEnterprise insuranceEnt =
                (PetInsuranceEnterprise) petNetwork.getEnterpriseDirectory()
                        .createAndAddEnterprise(
                                "Happy Paws Insurance",
                                Enterprise.EnterpriseType.PetInsurance);
        
         // 3.x 为每个 Enterprise 创建一个 Enterprise Admin 账号（固定用户名和密码，方便登录演示）
        // Boarding Enterprise Admin
        Employee boardingAdminEmp = boardingEnt.getEmployeeDirectory()
                .createEmployee("Boarding Enterprise Admin");
        boardingEnt.getUserAccountDirectory().createUserAccount(
                "boardingadmin",          // 用户名
                "boardingadmin",           // 密码（你可以自己改强一点）
                boardingAdminEmp,
                new EnterpriseAdminRole() // 如果没有这个类，先用你的 AdminRole
        );

        // Clinic Enterprise Admin
        Employee clinicAdminEmp = clinicEnt.getEmployeeDirectory()
                .createEmployee("Clinic Enterprise Admin");
        clinicEnt.getUserAccountDirectory().createUserAccount(
                "ClinicAdmin",
                "ClinicAdmin",
                clinicAdminEmp,
                new EnterpriseAdminRole()
        );

        // Insurance Enterprise Admin
        Employee insuranceAdminEmp = insuranceEnt.getEmployeeDirectory()
        .createEmployee("Insurance Enterprise Admin");
        UserAccount insuranceAdminAccount = insuranceEnt.getUserAccountDirectory().createUserAccount(
        "insAdmin",
        "ins@123",
        insuranceAdminEmp,
        new EnterpriseAdminRole()
        );


        // 4. 给每个 Enterprise 创建 Organizations（要求你已经有 OrganizationDirectory.createOrganization(Type)）
        // 4.1 Boarding enterprise
        
        Organization petCareOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.PetCare);
        Organization boardingServiceOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.BoardingService);
        Organization boardingCustomerServiceOrg = boardingEnt.getOrganizationDirectory()
        .createOrganization(Type.CustomerService);  
        
        
        // 4.2 Clinic enterprise
        Organization frontDeskOrg = clinicEnt.getOrganizationDirectory()
                .createOrganization(Type.FrontDesk);
        Organization vetDoctorOrg = clinicEnt.getOrganizationDirectory()
                .createOrganization(Type.VetDoctor);
        Organization vetLabOrg = clinicEnt.getOrganizationDirectory()
                .createOrganization(Type.VetLab);

        // 4.3 Insurance enterprise
        Organization policyOrg = insuranceEnt.getOrganizationDirectory()
                .createOrganization(Type.InsurancePolicy);
        Organization claimOrg = insuranceEnt.getOrganizationDirectory()
                .createOrganization(Type.InsuranceClaim);

        // 5. System Admin 账号
        Employee sysAdminEmp = system.getEmployeeDirectory()
                .createEmployee("System Admin");
        system.getUserAccountDirectory().createUserAccount(
                "sysadmin", "sysadmin", sysAdminEmp, new SystemAdminRole()
        );

        // 6. 用 Faker 生成员工账号（演示数据）

        // 6.1 Front Desk 员工
        for (int i = 0; i < 3; i++) {
            String name = faker.name().fullName();
            Employee e = frontDeskOrg.getEmployeeDirectory().createEmployee(name);
            String username = "fd_" + faker.name().username();
            String password = "fd" + faker.number().digits(3);
            frontDeskOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new FrontDeskAgentRole());
        }
        //pet boarding 客服账号
        // 固定 Front Desk 测试账号
        Employee frontDeskTest = frontDeskOrg.getEmployeeDirectory().createEmployee("Test Front Desk");
        frontDeskOrg.getUserAccountDirectory().createUserAccount(
                "fd1", "1111", frontDeskTest, new FrontDeskAgentRole());
        
// ⭐ 新增：固定 Customer Service 测试账号 (cs1)
        
        // 6.2 Pet Care 员工
        for (int i = 0; i < 3; i++) {
            String name = faker.name().fullName();
            Employee e = petCareOrg.getEmployeeDirectory().createEmployee(name);
            String username = "pc_" + faker.name().username();
            String password = "pc" + faker.number().digits(3);
            petCareOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new PetCareTakerRole());
        }
        Employee pct1 = boardingServiceOrg.getEmployeeDirectory().createEmployee("Test Pet Care Taker");
        boardingServiceOrg.getUserAccountDirectory().createUserAccount(
                "pct1", "pct1", pct1, new PetCareTakerRole());

        // 6.3 Boarding Service 员工
        for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            Employee e = boardingServiceOrg.getEmployeeDirectory().createEmployee(name);
            String username = "bs_" + faker.name().username();
            String password = "bs" + faker.number().digits(3);
            boardingServiceOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new BoardingManagerRole());
        }
        Employee bmTestEmp = boardingServiceOrg.getEmployeeDirectory().createEmployee("Test Boarding Manager");
        boardingServiceOrg.getUserAccountDirectory().createUserAccount(
                "bm1", "bm1", bmTestEmp, new BoardingManagerRole());
        
        // ⭐ Pet Boarding Customer Service 固定测试账号
        Employee boardingCSTestEmp = boardingCustomerServiceOrg.getEmployeeDirectory()
        .createEmployee("Test Customer Service");
        boardingCustomerServiceOrg.getUserAccountDirectory().createUserAccount(
        "cs1",           // 用户名
        "cs1",           // 密码
        boardingCSTestEmp,
        new FrontDeskAgentRole()
);
        // 6.4 Vet Doctor
        /*for (int i = 0; i < 3; i++) {
            String name = "Dr. " + faker.name().lastName();
            Employee e = vetDoctorOrg.getEmployeeDirectory().createEmployee(name);
            String username = "doc_" + faker.name().username();
            String password = "doc" + faker.number().digits(3);
            vetDoctorOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new VetDoctorRole());
        }*/
        // 6.4.1固定的Doctor账号
        String[][] fixedDoctors = {
            {"Doctor William Hanks", "Surgery", "doc1", "doc1"},
            {"Doctor Hanna King", "Internal Medicine", "doc2", "doc2"},
            {"Doctor July Oven", "Orthopedics", "doc3", "doc3"},
            {"Doctor Anna Watterson", "Gynecology", "doc4", "doc4"},
            {"Doctor Bella Stone", "Dermatology", "doc5", "doc5"},
            {"Doctor Kevin Harper", "General Vet", "doc6", "doc6"}
        };

        for (String[] d : fixedDoctors) {
            String fullName = d[0];
            String specialty = d[1];
            String username = d[2];
            String password = d[3];

            // 创建 Employee
            Employee doctorEmp = vetDoctorOrg.getEmployeeDirectory().createEmployee(fullName + " - " + specialty);

            // 创建账号
            vetDoctorOrg.getUserAccountDirectory().createUserAccount(
                username,
                password,
                doctorEmp,
                new VetDoctorRole()
            );
        }

        // 6.5 Lab Assistant
        /*for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            Employee e = vetLabOrg.getEmployeeDirectory().createEmployee(name);
            String username = "lab_" + faker.name().username();
            String password = "lab" + faker.number().digits(3);
            vetLabOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new LabAssistantRole());
        }*/
        
        //固定的 Lab Assistant 测试账号
        Employee labTestEmp = vetLabOrg.getEmployeeDirectory()
                .createEmployee("Test Lab Assistant");
        vetLabOrg.getUserAccountDirectory().createUserAccount(
                "lab1",          
                "lab1",          
                labTestEmp,
                new LabAssistantRole()
        );

        // 6.6 Insurance Policy Advisor
        for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            Employee e = policyOrg.getEmployeeDirectory().createEmployee(name);
            String username = "pol_" + faker.name().username();
            String password = "pol" + faker.number().digits(3);
            policyOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new InsuranceAgentRole());
        }
        
                    // ⭐ 固定 Insurance Agent 测试账号：agent / agent123
            Employee testAgentEmp = policyOrg.getEmployeeDirectory()
                                             .createEmployee("Test Insurance Agent");
            policyOrg.getUserAccountDirectory().createUserAccount(
                    "agent",          // 登录用户名
                    "12345",       // 登录密码
                    testAgentEmp,
                    new InsuranceAgentRole()
            );


        // 6.7 Insurance Claim Specialist
        for (int i = 0; i < 3; i++) {
            String name = faker.name().fullName();
            Employee e = claimOrg.getEmployeeDirectory().createEmployee(name);
            String username = "clm_" + faker.name().username();
            String password = "clm" + faker.number().digits(3);
            claimOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new ClaimProcessorRole());
        }

        // 固定的 Claim Processor 测试账号
        Employee cpTestEmp = claimOrg.getEmployeeDirectory()
                                     .createEmployee("Test Claim Processor");
        claimOrg.getUserAccountDirectory().createUserAccount(
                "claim",          // 用户名
                "12345",         // 密码
                cpTestEmp,
                new ClaimProcessorRole()
        );
        
        // 7. 用 Faker 生成 WorkRequest 测试数据
        
    PetOwnerDirectory petOwnerDirectory = system.getPetOwnerDirectory();
    java.util.List<Pet> createdPets = new java.util.ArrayList<>();

    for (int i = 0; i < 5; i++) {

        // 创建 PetOwner
        String ownerId = "PO" + faker.number().digits(4);
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();
        String address = faker.address().fullAddress();
        String emergencyContact = faker.phoneNumber().phoneNumber();
        String insuranceCompany = faker.company().name() + " Insurance"; // 随便生成公司 + Insurance
        String policyId = "PL" + faker.number().digits(6);                // 保单号
        String coverageLevel = faker.options().option("Full Coverage 100%", "Partial Coverage 50%"); 
        String expirationDate = faker.date().future(300, java.util.concurrent.TimeUnit.DAYS).toString();

       PetOwner owner = petOwnerDirectory.addOwner(
                ownerId, name, phone, email, address, emergencyContact,
                insuranceCompany, policyId, coverageLevel, expirationDate);
        
        

        // 创建 Pet
        PetDirectory petDirectory = owner.getPetDirectory();

        Pet pet = petDirectory.addPet(
                "P" + faker.number().digits(4),
                faker.dog().name(),
                (i % 2 == 0) ? "Dog" : "Cat",
                faker.number().numberBetween(1, 10),
                faker.number().randomDouble(2, 5, 50),
                faker.food().dish(),
                faker.food().ingredient(),
                faker.lorem().sentence(),
                owner
        );

        createdPets.add(pet);
        
        // ⭐⭐⭐ 为这个 owner + pet 创建一条 InsurancePolicy，加到 system 的 policyDir 里
        // 生成开始和结束日期（格式：yyyy-MM-dd）
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date startDate = faker.date().past(60, java.util.concurrent.TimeUnit.DAYS);
        java.util.Date endDate   = faker.date().future(300, java.util.concurrent.TimeUnit.DAYS);

        String startDateStr = sdf.format(startDate);
        String endDateStr   = sdf.format(endDate);

        // 覆盖类型、状态用和 UI 对得上的选项
        String coverageType = faker.options().option("Full Coverage", "Partial Coverage");
        double premium      = faker.number().randomDouble(2, 50, 300);
        String status       = faker.options().option("Active", "Expired", "Cancelled");

        policyDir.addPolicy(
                policyId,           // 上面已经生成的保单号
                insuranceCompany,   // 保险公司
                coverageType,       // Basic / Standard / Premium
                startDateStr,       // StartDate
                endDateStr,         // EndDate
                premium,            // Premium
                status,             // Status
                pet,                // 关联宠物
                owner               // 关联主人
    );
    }
    
    
    // ⭐⭐⭐ 在这里添加 Customer Service 测试数据 ⭐⭐⭐
for (int i = 0; i < Math.min(3, createdPets.size()); i++) {
    Pet pet = createdPets.get(i);
    
    HealthCareCheckRequest csRequest = new HealthCareCheckRequest();
    csRequest.setMessage("Customer notification needed for: " + pet.getPetName());
    csRequest.setStatus("Pending CS Review");
    csRequest.setPet(pet);
    csRequest.setSymptom(faker.medical().symptoms());
    csRequest.setBoardingRecordId("BR" + faker.number().digits(4));
    csRequest.setCheckResult("Health check completed");
    
    boardingCustomerServiceOrg.getWorkQueue().getWorkRequestList().add(csRequest);
}

        // 7.1 Boarding -> Clinic：健康检查
        for (int i = 0; i < createdPets.size(); i++) {

        Pet pet = createdPets.get(i);

        HealthCareCheckRequest req = new HealthCareCheckRequest();
        req.setMessage("Health check for pet: " + pet.getPetName());
        req.setStatus("Pending");

        //塞宠物
        req.setPet(pet);

        //设定症状
        req.setSymptom(faker.medical().symptoms());

        //将这个request放到clinic front desk的队列里
        frontDeskOrg.getWorkQueue().getWorkRequestList().add(req);
        }

        // 7.2 Doctor -> Lab：实验室检查
        /*
        for (int i = 0; i < 5; i++) {
            LabTestRequest req = new LabTestRequest();
            req.setMessage("Lab test for pet: " + faker.dog().name());
            req.setStatus("Pending");
            vetLabOrg.getWorkQueue().getWorkRequestList().add(req);
        }*/

        // 7.3 Insurance Claim 请求
        for (int i = 0; i < 5; i++) {

        InsuranceClaimRequest req = new InsuranceClaimRequest();

        // ===== 先从 createdPets 找一个宠物 + 宠物主人 =====
        if (!createdPets.isEmpty()) {
            // 简单一点：循环使用 createdPets
            Pet pet = createdPets.get(i % createdPets.size());
            PetOwner owner = pet.getPetOwner();   // Pet 里应该有 getOwner()

            // 挂到 claim 上（⭐关键）
            req.setPet(pet);
            req.setOwner(owner);

        // 把已有字段也用 owner 的真实信息来填，更一致
        if (owner != null) {
            req.setHolderName(owner.getOwnerName());
            req.setInsuranceCompany(owner.getInsuranceCompany());
            req.setPolicyId(owner.getPolicyId());
            req.setCoverageLevel(owner.getCoverageLevel());
            req.setExpirationDate(owner.getExpirationDate());
        }
    }

            // ===== 基础信息 =====
            req.setMessage("Claim for " + req.getHolderName()); // 没有就还是 random name
            req.setStatus("Pending");
            req.setClaimAmount(0);

            // 展示字段（如果上面已经从 owner 拿了，也可以只补充没填的）
            if (req.getPatientId() == null) {
                req.setPatientId("PT" + faker.number().digits(4));
            }
            if (req.getPetName() == null) {
                req.setPetName(faker.dog().name());
            }
            req.setSymptom(faker.medical().symptoms());
            req.setLabResult(faker.medical().diseaseName());

            double treatmentCost = faker.number()
                    .randomDouble(2, 50, 500);
            req.setTreatmentCost(treatmentCost);
            
                    req.setDoctorName(
                faker.options().option(
                    "Doctor William Hanks",
                    "Doctor Hanna King",
                    "Doctor July Oven",
                    "Doctor Anna Watterson",
                    "Doctor Bella Stone",
                    "Doctor Kevin Harper"
                )
            );

            req.setTreatmentNeeded(
                "Treatment plan for " + req.getLabResult()
                // 你也可以用 faker.medical().symptoms() 或者自定义字符串
            );
            // 如果上面没有从 owner 那里 set 过 coverageLevel，就走原来的随机逻辑
            if (req.getCoverageLevel() == null) {
                String level = faker.options().option("Basic", "Standard", "Premium");
                req.setCoverageLevel(level);
            }
            if (req.getExpirationDate() == null) {
                java.util.Date futureDate =
                        faker.date().future(365, java.util.concurrent.TimeUnit.DAYS);
                java.text.SimpleDateFormat sdf =
                        new java.text.SimpleDateFormat("yyyy-MM-dd");
                req.setExpirationDate(sdf.format(futureDate));
            }

            // 决策相关一开始不填
            req.setCoverageDecision(null);
            req.setClaimDecision(null);

            req.setSender(insuranceAdminAccount);
            claimOrg.getWorkQueue().getWorkRequestList().add(req);
        }




        // 7.4 Compensation 通知
        for (int i = 0; i < 3; i++) {
            CompensationNotificationRequest req = new CompensationNotificationRequest();
            req.setMessage("Compensation notice");
            req.setCompensationAmount(
                    faker.number().randomDouble(2, 50, 1000));
            req.setStatus("Pending");
            policyOrg.getWorkQueue().getWorkRequestList().add(req);
        }
        
        // 8.2 创建 PetBoardingRecord
        // *** 关键假设：PetBoardingEnterprise 有 getBoardingRecordDirectory() 方法 ***
        // *** 实际中您可能需要去 PetBoardingEnterprise.java 中实现这个方法 ***
        BoardingRecordDirectory boardingRecordDirectory = 
                ((PetBoardingEnterprise) boardingEnt).getBoardingRecordDirectory();

        int petIndex = 0;
        for (int i = 0; i < 7; i++) {
            if (createdPets.isEmpty()) break;
            Pet pet = createdPets.get(petIndex++ % createdPets.size());
            
            String recordId = "BR" + faker.number().digits(4);
            
            // 生成过去 1-7 天的日期作为开始日期
            java.util.Date startDate = faker.date().past(7, java.util.concurrent.TimeUnit.DAYS);
            // 生成未来 1-7 天的日期作为结束日期
            java.util.Date endDate = faker.date().future(7, java.util.concurrent.TimeUnit.DAYS); 
            
            // 状态从 Checked In, Pending Check-out, Completed 中随机选择
            String status = faker.options().option("Checked In", "Pending Check-out", "Completed");

            // Room Number: 楼层-房间号 (e.g., A-101)
            String roomNumber = faker.bothify("?-###", true); 

            // 使用 BoardingRecordDirectory.addRecord() 方法
            boardingRecordDirectory.addRecord(
                    recordId,
                    pet,
                    startDate.toString(), // 实际项目建议使用 SimpleDateFormat 格式化
                    endDate.toString(),   // 实际项目建议使用 SimpleDateFormat 格式化
                    roomNumber, 
                    faker.lorem().sentence(),
                    status
            );
        }
        // ======================================================================

        return system;
    }
        
    }
    

