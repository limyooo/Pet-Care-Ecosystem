package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Organization.Organization;
import Business.PetInsuranceOrganization.InsuranceClaimOrganization;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import UI.Insurance.ClaimProcessorWorkAreaJPanel;
import javax.swing.JPanel;

public class ClaimProcessorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem system) {

        return new ClaimProcessorWorkAreaJPanel(
                userProcessContainer,
                account,
                (InsuranceClaimOrganization) organization,
                (PetInsuranceEnterprise) enterprise,
                system
        );
    }

    @Override
    public String toString() {
        return "Claim Processor";
    }
}
