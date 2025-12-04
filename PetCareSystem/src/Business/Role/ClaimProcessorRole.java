package Business.Role;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Organization.Organization;
import Business.PetInsuranceOrganization.InsuranceClaimOrganization;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import UI.Insurance.ClaimProcessorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 * ClaimProcessorRole:
 * Defines the role of a claim processor who reviews and processes insurance claim requests.
 */

public class ClaimProcessorRole extends Role {

    //  Creates the main work area UI for the claim processor.
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem system) {

        // Return the UI for claim handling
        return new ClaimProcessorWorkAreaJPanel(
                userProcessContainer,
                account,
                (InsuranceClaimOrganization) organization,
                (PetInsuranceEnterprise) enterprise,
                system
        );
    }

    // Role name shown in UI tables or dropdowns.
    @Override
    public String toString() {
        return "Claim Processor";
    }
}
