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
                "boardingAdmin",          // 用户名
                "Boarding@123",           // 密码（你可以自己改强一点）
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

        return system;
    }
}
