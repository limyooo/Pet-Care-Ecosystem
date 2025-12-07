package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import Business.Role.Role;
import java.util.ArrayList;

public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter = 1;
    

    /*Enum representing all possible organization types.
      This helps identify specific organization categories when creating them.
    */
    public enum Type {
        PetCare("Pet Care Organization"),
        BoardingService("Boarding Service Organization"),
        VetDoctor("Vet Doctor Organization"),
        VetLab("Vet Lab Organization"),
        FrontDesk("Front Desk Organization"),
        InsurancePolicy("Insurance Policy Organization"),
        InsuranceClaim("Insurance Claim Organization"),
        CustomerService("Customer Service");  
        
        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        this.workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.organizationID = counter++; 
    }

    public abstract ArrayList<Role> getSupportedRole();

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID; 
    }
    
    @Override
    public String toString() {
    return this.getName();
}

}