package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 * VetDoctorRole:
 * Responsible for diagnosing pets, creating health check and lab test requests.
 */
public class VetDoctorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
                                 UserAccount account,
                                 Organization organization,
                                 Enterprise enterprise,
                                 Petsystem system) {
        // TODO: replace with real Vet Doctor work area panel
        // return new VetDoctorWorkAreaJPanel(userProcessContainer, account, organization, enterprise, system);
        return null;
    }
}