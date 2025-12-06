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

import Business.Pet.Pet;
import Business.Pet.PetOwner;
import Business.Pet.PetDirectory;
import Business.Pet.PetOwnerDirectory;
import Business.Pet.PetBoardingRecord;
import Business.Pet.BoardingRecordDirectory;
import Business.Pet.InsurancePolicy;

public class ConfigureABusiness {

    public static Petsystem configure() {

        // 1. Get the singleton system instance (获取唯一系统实例)
        Petsystem system = Petsystem.getInstance();
        
        InsurancePolicyDirectory policyDir = system.getInsurancePolicyDirectory();
        // Check if data has already been configured. Return if Network list is not empty.
        if (!system.getNetworkList().isEmpty()) {
            return system; 
        }

        // Java Faker: For generating random test data
        Faker faker = new Faker();

        // 2. Create a Network: Portland (创建一个Network)
        Network petNetwork = system.createAndAddNetwork("Portland");
        petNetwork.setName("Portland");

        // 3. Create 3 Enterprises in this Network (在该Network中创建3个Enterprise)
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
        
         // 3.Create an Enterprise Admin account for each Enterprise (fixed username/password for demo)
        // Boarding Enterprise Admin （固定用户名和密码，方便登录演示）
        Employee boardingAdminEmp = boardingEnt.getEmployeeDirectory()
                .createEmployee("Boarding Enterprise Admin");
        boardingEnt.getUserAccountDirectory().createUserAccount(
                "boardingadmin",          // 用户名
                "boardingadmin",           // 密码
                boardingAdminEmp,
                new EnterpriseAdminRole() 
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


        // 4. Create Organizations for each Enterprise(给每个Enterprise创建Organizations)
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

        // 5. System Admin
        Employee sysAdminEmp = system.getEmployeeDirectory()
                .createEmployee("System Admin");
        system.getUserAccountDirectory().createUserAccount(
                "sysadmin", "sysadmin", sysAdminEmp, new SystemAdminRole()
        );

        // 6. Generate employee accounts using Faker (demo data) 用Faker生成员工账号（演示数据）

        // 6.1 Front Desk staff
        for (int i = 0; i < 3; i++) {
            String name = faker.name().fullName();
            Employee e = frontDeskOrg.getEmployeeDirectory().createEmployee(name);
            String username = "fd_" + faker.name().username();
            String password = "fd" + faker.number().digits(3);
            frontDeskOrg.getUserAccountDirectory().createUserAccount(
                    username, password, e, new FrontDeskAgentRole());
        }
        // Pet boarding customer service account
        // Fixed Front Desk test account(固定FrontDesk测试账号)
        Employee frontDeskTest = frontDeskOrg.getEmployeeDirectory()
                .createEmployee("Test Front Desk");
        UserAccount frontDeskTestAccount = frontDeskOrg.getUserAccountDirectory()
                .createUserAccount(
                        "fd1",       
                        "1111",  
                        frontDeskTest,
                        new FrontDeskAgentRole()
        );

        
        
        // 6.2 Pet Care staff
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

        // 6.3 Boarding Service staff
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
        
        // Pet Boarding Customer Service fixed test account(固定测试账号)
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
        // 6.4.1 Fixed Doctor accounts (固定的Doctor账号)
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

            // Create Employee
            Employee doctorEmp = vetDoctorOrg.getEmployeeDirectory().createEmployee(fullName + " - " + specialty);

            // Create account
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
        
        // Fixed Lab Assistant test account (固定的Lab Assistant测试账号)
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
        
            // Fixed Insurance Agent test account (固定Insurance Agent测试账号)
            Employee testAgentEmp = policyOrg.getEmployeeDirectory()
                                             .createEmployee("Test Insurance Agent");
            policyOrg.getUserAccountDirectory().createUserAccount(
                    "agent",
                    "12345", 
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

        // Fixed Claim Processor test account (固定的Claim Processor测试账号)
        Employee cpTestEmp = claimOrg.getEmployeeDirectory()
                                     .createEmployee("Test Claim Processor");
        claimOrg.getUserAccountDirectory().createUserAccount(
                "claim",    
                "12345", 
                cpTestEmp,
                new ClaimProcessorRole()
        );
        
        // 7. Generate WorkRequest test data using Faker(用Faker生成WorkRequest测试数据)
        
        PetOwnerDirectory petOwnerDirectory = system.getPetOwnerDirectory();
        java.util.List<Pet> createdPets = new java.util.ArrayList<>();

        for (int i = 0; i < 5; i++) {

        // Create PetOwner
        String ownerId = "PO" + faker.number().digits(4);
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String email = faker.internet().emailAddress();
        String address = faker.address().fullAddress();
        String emergencyContact = faker.phoneNumber().phoneNumber();
        String insuranceCompany = faker.company().name() + " Insurance"; 
        String policyId = "PL" + faker.number().digits(6); 
        String coverageLevel = faker.options().option("Full Coverage 100%", "Partial Coverage 50%"); 
        String expirationDate = faker.date().future(300, java.util.concurrent.TimeUnit.DAYS).toString();

       PetOwner owner = petOwnerDirectory.addOwner(
                ownerId, name, phone, email, address, emergencyContact,
                insuranceCompany, policyId, coverageLevel, expirationDate);
        
        

        // Create Pet
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
        
        // Create an InsurancePolicy for this owner + pet, add to system's policyDir (为这个owner + pet创建一条InsurancePolicy，加到system的policyDir里)
        // Generate start and end dates (format: yyyy-MM-dd) 生成开始和结束日期
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.util.Date startDate = faker.date().past(60, java.util.concurrent.TimeUnit.DAYS);
        java.util.Date endDate   = faker.date().future(300, java.util.concurrent.TimeUnit.DAYS);

        String startDateStr = sdf.format(startDate);
        String endDateStr   = sdf.format(endDate);

        // Coverage type, status using options
        String coverageType = faker.options().option("Full Coverage", "Partial Coverage");
        double premium      = faker.number().randomDouble(2, 50, 300);
        String status       = faker.options().option("Active", "Expired", "Cancelled");

        policyDir.addPolicy(
                policyId,          
                insuranceCompany, 
                coverageType,      
                startDateStr,     
                endDateStr,   
                premium,     
                status,        
                pet,                
                owner            
    );
    }
    
    
    // Add Customer Service test data here(在这里添加Customer Service测试数据)
    for (int i = 0; i < Math.min(3, createdPets.size()); i++) {
    Pet pet = createdPets.get(i);
    
    HealthCareCheckRequest csRequest = new HealthCareCheckRequest();
    csRequest.setMessage("Customer notification needed for: " + pet.getPetName());
    csRequest.setStatus("Pending CS Review");
    csRequest.setPet(pet);
    csRequest.setSymptom(faker.medical().symptoms());
    
    csRequest.setBoardingRecordId("BR" + faker.number().digits(4));
    csRequest.setCheckResult("Health check completed");
    
     // Set treatment-related fields(设置治疗相关字段)
        csRequest.setTreatmentNeeded(faker.options().option(
        "Medication Only", 
        "IV Fluids & Supportive Care ", 
        "Diagnostic Imaging (X-ray / Ultrasound) ", 
        "Hospitalization",
        "Surgery"
    
    ));
    csRequest.setTreatmentCost(faker.number().randomDouble(2, 100, 1000));
        // Associate a Claim Request
        if (i == 0) {
            InsuranceClaimRequest claim = new InsuranceClaimRequest();
            claim.setClaimDecision("Pending Payment"); // Simulate approved claim 模拟已批准理赔
            claim.setClaimAmount(csRequest.getTreatmentCost() * 0.8); // 80% coverage
            csRequest.setInsuranceClaimRequest(claim);
        } else if (i == 1) {
            InsuranceClaimRequest claim = new InsuranceClaimRequest();
            claim.setClaimDecision("Approved"); 
            claim.setClaimAmount(csRequest.getTreatmentCost() * 0.5); // 50% coverage
            csRequest.setInsuranceClaimRequest(claim);
        }else{
            InsuranceClaimRequest claim = new InsuranceClaimRequest();
            claim.setClaimDecision("Approved"); 
            claim.setClaimAmount(csRequest.getTreatmentCost() * 1); // 100% coverage
            csRequest.setInsuranceClaimRequest(claim);
        }
        
        boardingCustomerServiceOrg.getWorkQueue().getWorkRequestList().add(csRequest);
    }
    
  

        // 7.1 Boarding -> Clinic：Health check 健康检查
        for (int i = 0; i < createdPets.size(); i++) {

        Pet pet = createdPets.get(i);

        HealthCareCheckRequest req = new HealthCareCheckRequest();
        req.setMessage("Health check for pet: " + pet.getPetName());
        req.setStatus("Pending");

        //Set pet
        req.setPet(pet);

        //Set symptom
        req.setSymptom(faker.medical().symptoms());
        

        //Add this request to clinic front desk queue 将这个request放到clinic front desk的队列里
        frontDeskOrg.getWorkQueue().getWorkRequestList().add(req);
        }

        // 7.2 Doctor -> Lab：Laboratory tests
        /*
        for (int i = 0; i < 5; i++) {
            LabTestRequest req = new LabTestRequest();
            req.setMessage("Lab test for pet: " + faker.dog().name());
            req.setStatus("Pending");
            vetLabOrg.getWorkQueue().getWorkRequestList().add(req);
        }*/

        // 7.3 Insurance Claim requests
        for (int i = 0; i < 5; i++) {

        InsuranceClaimRequest req = new InsuranceClaimRequest();

        // First find a pet + pet owner from createdPets
        if (!createdPets.isEmpty()) {
            // cycle through createdPets
            Pet pet = createdPets.get(i % createdPets.size());
            PetOwner owner = pet.getPetOwner();   // Pet 里应该有 getOwner()

            // Attach to claim
            req.setPet(pet);
            req.setOwner(owner);

        // Fill existing fields with real owner info for consistency
        if (owner != null) {
            req.setHolderName(owner.getOwnerName());
            req.setInsuranceCompany(owner.getInsuranceCompany());
            req.setPolicyId(owner.getPolicyId());
            req.setCoverageLevel(owner.getCoverageLevel());
            req.setExpirationDate(owner.getExpirationDate());
        }
    }

            // Basic information
            req.setMessage("Claim for " + req.getHolderName()); // Use random name if not set
            req.setStatus("Pending");
            req.setClaimAmount(0);

            // Display fields (can fill unfilled ones if already got from owner above)
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
                // can also use faker.medical().symptoms() or custom strings 也可以用 faker.medical().symptoms() 或者自定义字符串
            );
            // If coverageLevel not set from owner above, use original random logic 如果上面没有从 owner 那里 set 过 coverageLevel，就走原来的随机逻辑
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

            // Decision-related fields initially blank 决策相关一开始不填
            req.setCoverageDecision(null);
            req.setClaimDecision(null);

            req.setSender(frontDeskTestAccount);
            claimOrg.getWorkQueue().getWorkRequestList().add(req);
        }




        // 7.4 Compensation notifications
        for (int i = 0; i < 3; i++) {
            CompensationNotificationRequest req = new CompensationNotificationRequest();
            req.setMessage("Compensation notice");
            req.setCompensationAmount(
                    faker.number().randomDouble(2, 50, 1000));
            req.setStatus("Pending");
            policyOrg.getWorkQueue().getWorkRequestList().add(req);
        }
        
        // 8.2 Create PetBoardingRecord
        BoardingRecordDirectory boardingRecordDirectory = 
                ((PetBoardingEnterprise) boardingEnt).getBoardingRecordDirectory();

        int petIndex = 0;
        for (int i = 0; i < 7; i++) {
            if (createdPets.isEmpty()) break;
            Pet pet = createdPets.get(petIndex++ % createdPets.size());
            
            String recordId = "BR" + faker.number().digits(4);
            
            // Generate date 1-7 days ago as start date 生成过去 1-7 天的日期作为开始日期
            java.util.Date startDate = faker.date().past(7, java.util.concurrent.TimeUnit.DAYS);
            // Generate date 1-7 days in future as end date 生成未来 1-7 天的日期作为结束日期
            java.util.Date endDate = faker.date().future(7, java.util.concurrent.TimeUnit.DAYS); 
            
            // Status randomly selected from Checked In, Pending Check-out, Completed 状态从 Checked In, Pending Check-out, Completed 中随机选择
            String status = faker.options().option("Checked In", "Pending Check-out", "Completed");

            // Room Number: 楼层-房间号 (e.g., A-101)
            String roomNumber = faker.bothify("?-###", true); 

            // Use BoardingRecordDirectory.addRecord() method
            boardingRecordDirectory.addRecord(
                    recordId,
                    pet,
                    startDate.toString(),
                    endDate.toString(), 
                    roomNumber, 
                    faker.lorem().sentence(),
                    status
            );
        }
        // ======================================================================

        return system;
    }
        
    }
    

