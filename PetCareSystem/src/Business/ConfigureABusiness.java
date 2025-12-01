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
                "clinicAdmin",
                "Clinic@123",
                clinicAdminEmp,
                new EnterpriseAdminRole()
        );

        // Insurance Enterprise Admin
        Employee insuranceAdminEmp = insuranceEnt.getEmployeeDirectory()
        .createEmployee("Insurance Enterprise Admin");
        UserAccount insuranceAdminAccount = insuranceEnt.getUserAccountDirectory().createUserAccount(
        "insuranceAdmin",
        "Insurance@123",
        insuranceAdminEmp,
        new EnterpriseAdminRole()
        );


        // 4. 给每个 Enterprise 创建 Organizations（要求你已经有 OrganizationDirectory.createOrganization(Type)）
        // 4.1 Boarding enterprise
        
        Organization petCareOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.PetCare);
        Organization boardingServiceOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.BoardingService);

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
        
        // 固定 Front Desk 测试账号
        Employee frontDeskTest = frontDeskOrg.getEmployeeDirectory().createEmployee("Test Front Desk");
        frontDeskOrg.getUserAccountDirectory().createUserAccount(
                "fd1", "1111", frontDeskTest, new FrontDeskAgentRole());
        

        // 6.2 Pet Care 员工
        for (int i = 0; i < 3; i++) {
            String name = faker.name().fullName();
            Employee e = petCareOrg.getEmployeeDirectory().createEmployee(name);
            String username = "pc_" + faker.name().username();
            String password = "pc" + faker.number().digits(3);
            petCareOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new PetCareTakerRole());
        }

        // 6.3 Boarding Service 员工
        for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            Employee e = boardingServiceOrg.getEmployeeDirectory().createEmployee(name);
            String username = "bs_" + faker.name().username();
            String password = "bs" + faker.number().digits(3);
            boardingServiceOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new BoardingManagerRole());
        }
        Employee pct1 = boardingServiceOrg.getEmployeeDirectory().createEmployee("Test Pet Care Taker");
        boardingServiceOrg.getUserAccountDirectory().createUserAccount(
                "pct1", "pct1", pct1, new PetCareTakerRole());

        // 6.4 Vet Doctor
        for (int i = 0; i < 3; i++) {
            String name = "Dr. " + faker.name().lastName();
            Employee e = vetDoctorOrg.getEmployeeDirectory().createEmployee(name);
            String username = "doc_" + faker.name().username();
            String password = "doc" + faker.number().digits(3);
            vetDoctorOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new VetDoctorRole());
        }

        // 6.5 Lab Assistant
        for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            Employee e = vetLabOrg.getEmployeeDirectory().createEmployee(name);
            String username = "lab_" + faker.name().username();
            String password = "lab" + faker.number().digits(3);
            vetLabOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new LabAssistantRole());
        }

        // 6.6 Insurance Policy Advisor
        for (int i = 0; i < 2; i++) {
            String name = faker.name().fullName();
            Employee e = policyOrg.getEmployeeDirectory().createEmployee(name);
            String username = "pol_" + faker.name().username();
            String password = "pol" + faker.number().digits(3);
            policyOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new InsuranceAgentRole());
        }

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
        String coverageLevel = faker.options().option("Full Coverage", "Partial Coverage"); // 两种任选
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
        for (int i = 0; i < 5; i++) {
            LabTestRequest req = new LabTestRequest();
            req.setMessage("Lab test for pet: " + faker.dog().name());
            req.setStatus("Pending");
            vetDoctorOrg.getWorkQueue().getWorkRequestList().add(req);
        }

        // 7.3 Insurance Claim 请求
        for (int i = 0; i < 5; i++) {

            InsuranceClaimRequest req = new InsuranceClaimRequest();

            // ===== 基础信息 =====
            req.setMessage("Claim for " + faker.name().fullName());
            req.setStatus("Pending");              // 初始都是 Pending
            req.setClaimAmount(0);                 // 先设为 0，等 Claim Processor 审批时再按规则计算

            // 用于表格 / 详情展示的字段
            req.setPatientId("PT" + faker.number().digits(4));
            req.setPolicyId("PL" + faker.number().digits(4));
            req.setHolderName(faker.name().fullName());   // 宠物主人
            req.setPetName(faker.dog().name());
            req.setSymptom(faker.medical().symptoms());
            req.setLabResult(faker.medical().diseaseName());

            double treatmentCost = faker.number()
                    .randomDouble(2, 50, 500);             // 治疗费用
            req.setTreatmentCost(treatmentCost);

            // ===== 保险相关三项 =====
            req.setInsuranceCompany(faker.company().name());

            // Basic / Standard / Premium 随机一个，将来按它算 50%/70%/100%
            String level = faker.options().option("Basic", "Standard", "Premium");
            req.setCoverageLevel(level);

            // 生成未来 365 天内的到期日（格式好看一点）
            java.util.Date futureDate =
                    faker.date().future(365, java.util.concurrent.TimeUnit.DAYS);
            java.text.SimpleDateFormat sdf =
                    new java.text.SimpleDateFormat("yyyy-MM-dd");
            req.setExpirationDate(sdf.format(futureDate));

            // ===== 决策相关：一开始不决定，全交给 Claim Processor =====
            req.setCoverageDecision(null);         // 或者写成 "Pending" 也可以
            req.setClaimDecision(null);           // 如果你还用这个字段，也一起清空

            // Sender
            req.setSender(insuranceAdminAccount);

            // 加入 Insurance Claim Org 的工作队列
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
    

