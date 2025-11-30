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

public class ConfigureABusiness {

    public static Petsystem configure() {

        // 1. 获取唯一系统实例
        Petsystem system = Petsystem.getInstance();

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
                "1111",           // 密码（你可以自己改强一点）
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
        insuranceEnt.getUserAccountDirectory().createUserAccount(
                "insuranceAdmin",
                "Insurance@123",
                insuranceAdminEmp,
                new EnterpriseAdminRole()
        );

        // 4. 给每个 Enterprise 创建 Organizations（要求你已经有 OrganizationDirectory.createOrganization(Type)）
        // 4.1 Boarding enterprise
        Organization frontDeskOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.FrontDesk);
        Organization petCareOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.PetCare);
        Organization boardingServiceOrg = boardingEnt.getOrganizationDirectory()
                .createOrganization(Type.BoardingService);

        // 4.2 Clinic enterprise
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
                "fd1",    
                "1111",   
                frontDeskTest,
                new FrontDeskAgentRole()
        );

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
        Employee bmEmp = boardingServiceOrg.getEmployeeDirectory().createEmployee("Test Boarding Manager");
        boardingServiceOrg.getUserAccountDirectory().createUserAccount(
                "bm1", "1234", bmEmp, new BoardingManagerRole());

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

        // 7.1 Boarding -> Clinic：健康检查
        for (int i = 0; i < 5; i++) {
            String petName = faker.dog().name();
            HealthCareCheckRequest req = new HealthCareCheckRequest();
            req.setMessage("Health check for pet: " + petName);
            req.setStatus("Pending");
            petCareOrg.getWorkQueue().getWorkRequestList().add(req);
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
            req.setMessage("Claim for " + faker.name().fullName());
            req.setClaimAmount(
                    faker.number().randomDouble(2, 100, 3000));
            req.setStatus("Pending");
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
        // 8.1 创建 PetOwner 和 Pet
        // *** 关键假设：Petsystem 有 getPetOwnerDirectory() 方法 ***
        // *** 实际中您可能需要去 Petsystem.java 中实现这个方法 ***
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
            
            // 使用 PetOwnerDirectory.addOwner() 方法
            PetOwner owner = petOwnerDirectory.addOwner(
                    ownerId, name, phone, email, address, emergencyContact);
            // 创建 Pet
            // *** 关键假设：PetOwner 有 getPetDirectory() 方法，返回 PetDirectory 实例 ***
            // *** 实际中您可能需要去 PetOwner.java 中实现 getPetDirectory() ***
            PetDirectory petDirectory = owner.getPetDirectory(); 
            
            String petId = "P" + faker.number().digits(4);
            String petName = faker.dog().name();
            String species = (i % 2 == 0) ? "Dog" : "Cat"; // 随机生成 Dog 或 Cat
            int age = faker.number().numberBetween(1, 10);
            double weight = faker.number().randomDouble(2, 5, 50);
            String foodPreference = faker.food().dish();
            String foodAllergy = faker.food().ingredient();
            String healthNotes = faker.lorem().sentence();

            // 使用 PetDirectory.addPet() 方法
            Pet pet = petDirectory.addPet(
                    petId, petName, species, age, weight,
                    foodPreference, foodAllergy, healthNotes, owner);

            createdPets.add(pet);
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
    

