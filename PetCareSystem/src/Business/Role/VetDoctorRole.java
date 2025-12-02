package Business.Role;

import Business.Petsystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetClinicOrganization.VetDoctorOrganization;
import Business.UserAccount.UserAccount;
import UI.petClinic.DoctorWorkAreaJPanel;
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

    // 确保 organization 是 VetDoctorOrganization
    VetDoctorOrganization docOrg = (VetDoctorOrganization) organization;
    

    return new DoctorWorkAreaJPanel(
            userProcessContainer,
            account,
            docOrg,
            enterprise
        );
    }
}