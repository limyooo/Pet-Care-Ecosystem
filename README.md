# Pet Care Ecosystem

A teaching-oriented Java Swing system simulating the full workflow of **pet service enterprises**, including **Pet Boarding**, **Pet Clinic**, and **Pet Insurance**.  
The system integrates operational processes, health event handling, laboratory workflows, insurance claim processing, and compensation notifications, forming a complete end-to-end lifecycle for pet care.

---

## 1. System Overview

The system uses a layered architecture with Java Swing for UI.  
Core objects include:  

- `Petsystem`  
- `Network`  
- `Enterprise`  
- `Organization`  
- `Employee`  
- `UserAccount`  
- `WorkQueue` / `WorkRequest`  
- `Pet` / `PetOwner`  
- `InsurancePolicy`  
- `BoardingRecord`  

Three enterprises interact closely through `WorkRequest` objects:  

- **Pet Boarding Enterprise**  
- **Pet Clinic Enterprise**  
- **Pet Insurance Enterprise**  

Demo data is automatically generated through `ConfigureABusiness`.

---

## 2. Pet Boarding Module

### **Module Objective**
Manages the full lifecycle of pet lodging services.  
Key responsibilities:  

- Pet check-in/check-out registration  
- Daily care logging  
- Health observation and escalation  
- Client communication regarding urgent health events  

### **Organizations and Roles**

**Pet Care Taker**  
- **Example Account:** `pct1 / pct1`  
- **Responsibilities:**  
  - Register boarding check-in/check-out  
  - Log daily care records  
  - Submit `HealthCareCheckRequest`  

**Customer Service**  
- **Example Account:** `cs1 / cs1`  
- **Responsibilities:**  
  - Receive clinic diagnosis, treatment needed, and treatment cost  
  - Track insurance status  
  - Call or email pet owners regarding treatment & payment  

**Boarding Manager**  
- **Example Account:** `bm1 / bm1`  
- **Responsibilities:**  
  - Staff management  
  - Resource allocation  
  - Operations oversight  

**PetBoarding Enterprise Admin**  
- **Example Account:** `boardingadmin / boardingadmin`  
- **Responsibilities:**  
  - Configure enterprise, organizations, employees, and system settings  

### **Core Boarding Workflows**

**Service Lifecycle Workflow**  

1. **Check-In Registration:** Care Taker creates a `PetBoardingRecord`.  
2. **Daily Care Log:** Logs feeding, activities, behavior, and health observations.  
3. **Information Review:** All details accessible anytime.  
4. **Check-Out & Billing:** Mark record as Completed.

---

## 3. Pet Clinic Module

### **Organizations and Roles**

**Front Desk Organization — Front Desk**  
- **Example Account:** `fd1 / 1111`  
- **Responsibilities:**  
  - Receive `HealthCareCheckRequest`  
  - Assign Vet Doctors  
  - Receive lab test results  
  - Submit `InsuranceClaimRequest`  

**Vet Doctor Organization — Doctor**  
- **Example Accounts:** `doc1/doc1 … doc6/doc6`  
- **Responsibilities:**  
  - Receive `HealthCareCheckRequest`  
  - Issue `LabTestRequest`  
  - Diagnose and determine treatment needed & cost  

**Vet Lab Organization — Lab Assistant**  
- **Example Account:** `lab1 / lab1`  
- **Responsibilities:**  
  - Receive `LabTestRequest`  
  - Complete lab tests  
  - Return test results to the doctor  

---

## 4. Insurance Module

### **Organizations and Roles**

**Insurance Policy Organization — Insurance Agent**  
- **Example Account:** `agent / 12345`  
- **Functions:**  
  - Create and view policies  
  - Manage policy details  
  - View insurance overview  

**Insurance Claim Organization — Claim Processor**  
- **Example Account:** `claim / 12345`  
- **Functions:**  
  - Manage insurance claims  
  - Approve or reject claims  
  - Calculate claim amount  
  - Send compensation notifications  

---

## 5. Cross-Module Workflows

### **A. Health Care Check Request Workflow**
- **Sender:** Pet Care Taker (Boarding)  
- **Receiver:** Front Desk (Clinic)  

**Process Flow:**  
1. Care Taker issues `HealthCareCheckRequest`  
2. Front Desk assigns to a doctor  
3. Doctor issues `LabTestRequest` if needed  
4. Lab Assistant completes the test  
5. Doctor updates diagnosis, treatment needed, and treatment cost  
6. Front Desk issues `InsuranceClaimRequest` if coverage applies  

---

### **B. Lab Test Request Workflow**
- **Sender:** Vet Doctor  
- **Receiver:** Lab Assistant  

**Process Flow:**  
1. Doctor issues `LabTestRequest`  
2. Lab Assistant performs test  
3. Lab Assistant returns results to doctor  
4. Doctor updates `HealthCareCheckRequest`  

---

### **C. Insurance Claim Workflow**
- **Sender:** Front Desk (Clinic)  
- **Receiver:** Claim Processor (Insurance)  

**Process Flow:**  
1. Front Desk sends `InsuranceClaimRequest`  
2. Claim Processor checks policy validity, expiration, and coverage  
3. Claim Processor approves/rejects claim  
4. Claim amount is calculated  
5. Claim results updated for Clinic  

---

### **D. Compensation Notification Workflow**
- **Sender:** Claim Processor (Insurance)  
- **Receiver:** Customer Service (Boarding)  

**Process Flow:**  
1. Claim Processor calculates compensation  
2. Notification is sent to Boarding Customer Service  
3. Customer Service contacts pet owner  
4. Request is closed after communication  

---

## 6. WorkRequest Summary

- `HealthCareCheckRequest`: Boarding → Clinic, contains symptoms, treatment needed, cost, lab results  
- `LabTestRequest`: Doctor → Lab Assistant  
- `InsuranceClaimRequest`: Clinic Front Desk → Insurance Claim Processor  
- `CompensationNotificationRequest`: Claim Processor → Boarding Customer Service  

---

## 7. Demo Initialization (ConfigureABusiness)

- **Network:** Portland  
- **Enterprises:** Boarding, Clinic, Insurance  
- **Enterprise Admins:** Created for all enterprises  
- **Fixed role accounts:** `pct1`, `fd1`, `doc1`…`doc6`, `lab1`, `cs1`, `claim`, `agent`  
- **Random employees, pets, pet owners, insurance policies** generated  
- **Sample health care requests and claim requests** created  
- WorkQueue connections automatically linked  

---

## 8. Demo Login Accounts

**System Admin:** `sysadmin / sysadmin`  

**Pet Boarding:**  
- Enterprise Admin: `boardingadmin / boardingadmin`  
- Pet Care Taker: `pct1 / pct1`  
- Boarding Manager: `bm1 / bm1`  
- Customer Service: `cs1 / cs1`  

**Pet Clinic:**  
- Enterprise Admin: `ClinicAdmin / ClinicAdmin`  
- Front Desk: `fd1 / 1111`  
- Doctors: `doc1`..`doc6 / doc1`..`doc6`  
- Lab Assistant: `lab1 / lab1`  

**Pet Insurance:**  
- Enterprise Admin: `insAdmin / ins@123`  
- Insurance Agent: `agent / 12345`  
- Claim Processor: `claim / 12345`  

---

## 9. How to Run the Demo

1. Launch the system (`Petsystem` auto-loads demo data)  
2. Log in with any role account above  
3. Use Pet Care Taker (`pct1`) to register boarding & submit health care requests  
4. Use Clinic roles to assign doctors, perform lab tests, diagnose, and submit insurance claims  
5. Use Claim Processor to approve or reject claims  
6. Use Customer Service to review compensation notifications and contact pet owners
