package Business.Role;

import javax.swing.JPanel;
import Business.UserAccount.UserAccount;
import Business.Organization.Organization;
import Business.Enterprise.Enterprise;
import Business.EcoSystem;

/**
 * Abstract Role class. 
 * Each Role defines what UI panel it creates for the user.
 */
public abstract class Role {
    
    public enum RoleType {
        PetCareTaker("PetCareTaker"),
        BoardingManager("BoardingManager"),
        CustomerSupporter("CustomerSupporter"),
        VetDoctor("VetDoctor"),
        HospitalFrontDesk("HospitalFrontDesk"),
        LabAssistant("LabAssistant"),
        InsuranceAgent("InsuranceAgent"),
        ClaimProcessor("ClaimProcessor");

        private String value;

        private RoleType(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        @Override
        public String toString(){
            return value;
        }
    }

    // Each role must create its own workspace panel (UI)
    public abstract JPanel createWorkArea(
            JPanel userProcessContainer,
            UserAccount account,
            Organization organization,
            Enterprise enterprise,
            EcoSystem system);
}
