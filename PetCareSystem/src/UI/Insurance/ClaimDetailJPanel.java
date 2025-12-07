/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Insurance;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Business.Pet.Pet;
import Business.Pet.PetOwner;
import Business.WorkQueue.InsuranceClaimRequest;
import java.awt.Dimension;

/**
 *
 * @author Eve Dou
 */
public class ClaimDetailJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer; // Parent container using CardLayout
    private InsuranceClaimRequest claim; // The claim being viewed in this detail panel
    private ClaimProcessorWorkAreaJPanel parentPanel;


    public ClaimDetailJPanel() {
        initComponents();     
    }

    
    // Receives parent container and the selected InsuranceClaimRequest
    public ClaimDetailJPanel(JPanel userProcessContainer,
                         InsuranceClaimRequest claim,
                         ClaimProcessorWorkAreaJPanel parentPanel) {
                            this();          
                            this.userProcessContainer = userProcessContainer;
                            this.claim = claim;
                            this.parentPanel = parentPanel;

                            populateFields();             
}
    
    
    /*  Populate all sections (Claim / Pet / Owner / Medical / Insurance)
        from the InsuranceClaimRequest object. */
    private void populateFields() {
            if (claim == null) {
                return;
            }

            // Claim Info
            txtPatientID.setText(claim.getPatientId());
            txtClaimID.setText("CLM-" + claim.getPolicyId());
            txtClaimReason.setText(claim.getMessage());
            txtClaimAmount.setText(String.valueOf(claim.getClaimAmount()));

            if (claim.getRequestDate() != null) {
                txtRequestDate.setText(claim.getRequestDate().toString());
            } else {
                txtRequestDate.setText("");
            }
            txtStatus.setText(claim.getStatus() == null ? "" : claim.getStatus());

            if (claim.getSender() != null) {
                txtSender.setText(claim.getSender().getUsername());
            } else {
                txtSender.setText("");
            }

            // Pet Info 
            Pet pet = claim.getPet();
            if (pet != null) {
                // Pet attached on the claim
                txtPetName.setText(pet.getPetName() == null ? "" : pet.getPetName());
                txtSpecies.setText(pet.getSpecies() == null ? "" : pet.getSpecies());
                txtAge.setText(String.valueOf(pet.getAge()));
                txtWeight.setText(String.valueOf(pet.getWeight()));
                txtAllergy.setText(pet.getFoodAllergy() == null ? "" : pet.getFoodAllergy());
            } else {
                // Fallback: only basic pet name stored on the claim
                txtPetName.setText(claim.getPetName() == null ? "" : claim.getPetName());
                txtSpecies.setText("");
                txtAge.setText("");
                txtWeight.setText("");
                txtAllergy.setText("");
            }

            // Owner Info
            PetOwner owner = claim.getOwner();
            if (owner == null && pet != null) {
                // Fallback: sometimes owner is only linked through Pet
                owner = pet.getPetOwner();
            }

            if (owner != null) {
                txtOwnerName.setText(owner.getOwnerName() == null ? "" : owner.getOwnerName());
                txtPhone.setText(owner.getPhone() == null ? "" : owner.getPhone());
                txtEmail.setText(owner.getEmail() == null ? "" : owner.getEmail());
                txtAddress.setText(owner.getAddress() == null ? "" : owner.getAddress());
                txtEmergency.setText(owner.getEmergencyContact() == null ? "" : owner.getEmergencyContact());
            } else {
                // Fallback: only holderName is stored in the claim
                txtOwnerName.setText(claim.getHolderName() == null ? "" : claim.getHolderName());
                txtPhone.setText("");
                txtEmail.setText("");
                txtAddress.setText("");
                txtEmergency.setText("");
            }


                // Medical Info

                // Doctor Assigned
                txtDiagnosis.setText(
                        claim.getDoctorName() == null ? "" : claim.getDoctorName()
                );

                // Lab Test Result
                txtLabResult.setText(
                        claim.getLabResult() == null ? "" : claim.getLabResult()
                );

                // Treatment Needed
                txtDoctor.setText(
                        claim.getTreatmentNeeded() == null ? "" : claim.getTreatmentNeeded()
                );

                // Total treatment cost
                txtCost.setText(String.valueOf(claim.getTreatmentCost()));


                // Insurance Info
                txtInsuranceCompany.setText(
                        claim.getInsuranceCompany() == null ? "" : claim.getInsuranceCompany()
                );
                txtPolicyID.setText(
                        claim.getPolicyId() == null ? "" : claim.getPolicyId()
                );
                txtCoverageLevel.setText(
                        claim.getCoverageLevel() == null ? "" : claim.getCoverageLevel()
                );
                txtExpirationDate.setText(
                        claim.getExpirationDate() == null ? "" : claim.getExpirationDate()
                );
    }

    private void setEditableFields(boolean editable) {

    // --- Claim Info ---
    txtClaimReason.setEditable(editable);
    txtClaimAmount.setEditable(editable);

    // --- Medical Info ---
    txtDiagnosis.setEditable(editable);   // Doctor Assigned
    txtLabResult.setEditable(editable);   // Lab Test Result
    txtDoctor.setEditable(editable);      // Treatment Needed
    txtCost.setEditable(editable);        // Treatment Cost

    // --- Insurance Info ---
    txtInsuranceCompany.setEditable(editable);
    txtCoverageLevel.setEditable(editable);
    txtExpirationDate.setEditable(editable);

    
    txtPatientID.setEditable(false);
    txtClaimID.setEditable(false);
    txtRequestDate.setEditable(false);
    txtStatus.setEditable(false);
    txtSender.setEditable(false);
    txtPetName.setEditable(false);
    txtSpecies.setEditable(false);
    txtAge.setEditable(false);
    txtWeight.setEditable(false);
    txtAllergy.setEditable(false);
    txtOwnerName.setEditable(false);
    txtPhone.setEditable(false);
    txtEmail.setEditable(false);
    txtAddress.setEditable(false);
    txtEmergency.setEditable(false);
    txtPolicyID.setEditable(false);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblViewDetails = new javax.swing.JLabel();
        lblClaimInfo = new javax.swing.JLabel();
        lblClaimID = new javax.swing.JLabel();
        txtPatientID = new javax.swing.JTextField();
        lblClaimReason = new javax.swing.JLabel();
        txtClaimReason = new javax.swing.JTextField();
        lblClaimAmount = new javax.swing.JLabel();
        txtClaimAmount = new javax.swing.JTextField();
        lblRequestDate = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblSender = new javax.swing.JLabel();
        txtRequestDate = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtSender = new javax.swing.JTextField();
        lblPet = new javax.swing.JLabel();
        lblPetName = new javax.swing.JLabel();
        txtPetName = new javax.swing.JTextField();
        lblSpecies = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        txtSpecies = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtAllergy = new javax.swing.JTextField();
        lblMedicalInfo = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        lblDiagnosis = new javax.swing.JLabel();
        lblLabResult = new javax.swing.JLabel();
        txtDoctor = new javax.swing.JTextField();
        txtLabResult = new javax.swing.JTextField();
        txtDiagnosis = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblPatientID = new javax.swing.JLabel();
        txtClaimID = new javax.swing.JTextField();
        lblAllergy = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblOwnerName = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblEmergency = new javax.swing.JLabel();
        txtOwnerName = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmergency = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        lblInsuranceInfo = new javax.swing.JLabel();
        lblOwner = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        lblPolicyID = new javax.swing.JLabel();
        lblCoverageLevel = new javax.swing.JLabel();
        lblExpirationDate = new javax.swing.JLabel();
        txtInsuranceCompany = new javax.swing.JTextField();
        txtPolicyID = new javax.swing.JTextField();
        txtCoverageLevel = new javax.swing.JTextField();
        txtExpirationDate = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(242, 242, 242));

        lblViewDetails.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblViewDetails.setText("Claim Details");

        lblClaimInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblClaimInfo.setText("Claim Information");

        lblClaimID.setText("Claim ID:  ");

        txtPatientID.setEditable(false);

        lblClaimReason.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblClaimReason.setText("Claim Reason: ");

        lblClaimAmount.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblClaimAmount.setText("Claim Amount:");

        lblRequestDate.setText("Request Date:");

        lblStatus.setText("Status:");

        lblSender.setText("Sender: ");

        txtRequestDate.setEditable(false);

        txtStatus.setEditable(false);

        txtSender.setEditable(false);

        lblPet.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPet.setText("Pet Information");

        lblPetName.setText("Pet Name: ");

        txtPetName.setEditable(false);

        lblSpecies.setText("Species:");

        lblAge.setText("Age:");

        lblWeight.setText("Weight:");

        txtSpecies.setEditable(false);
        txtSpecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpeciesActionPerformed(evt);
            }
        });

        txtAge.setEditable(false);
        txtAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgeActionPerformed(evt);
            }
        });

        txtAllergy.setEditable(false);

        lblMedicalInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblMedicalInfo.setText("Medical Information");

        lblDoctor.setText("Doctor Assigned:");

        lblDiagnosis.setText("Treatment Needed:");

        lblLabResult.setText("Lab Test Result:");

        txtDoctor.setEditable(false);

        txtLabResult.setEditable(false);

        txtDiagnosis.setEditable(false);
        txtDiagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiagnosisActionPerformed(evt);
            }
        });

        btnBack.setText("<<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPatientID.setText("Patient ID: ");

        txtClaimID.setEditable(false);

        lblAllergy.setText("Food Allergy:");

        txtWeight.setEditable(false);

        lblEmail.setText("Email:");

        lblOwnerName.setText("Owner Name:");

        lblPhone.setText("Phone:");

        lblAddress.setText("Address:  ");

        lblEmergency.setText("Emergency Contact:");

        txtOwnerName.setEditable(false);

        txtPhone.setEditable(false);

        txtEmail.setEditable(false);

        txtAddress.setEditable(false);

        txtEmergency.setEditable(false);

        lblCost.setText("Treatment Cost:");

        txtCost.setEditable(false);

        lblInsuranceInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblInsuranceInfo.setText("Insurance Information");

        lblOwner.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblOwner.setText("Pet Owner Information");

        lblCompany.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblCompany.setText("Insurance Company:");

        lblPolicyID.setText("Policy ID:");

        lblCoverageLevel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblCoverageLevel.setText("Coverage Level:");

        lblExpirationDate.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblExpirationDate.setText("Expiration Date:");

        txtPolicyID.setEditable(false);

        btnModify.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(lblClaimInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMedicalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(167, 167, 167)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCompany)
                                        .addGap(23, 23, 23)
                                        .addComponent(txtInsuranceCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblInsuranceInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)))))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)
                                .addComponent(lblExpirationDate))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblLabResult, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblDoctor)
                                            .addGap(12, 12, 12)))
                                    .addComponent(lblDiagnosis))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiagnosis)
                                    .addComponent(txtLabResult)
                                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(lblPolicyID))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(lblCoverageLevel)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCoverageLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblViewDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblClaimAmount)
                                    .addComponent(lblClaimReason, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(lblClaimID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblPatientID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblPetName)
                                            .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblAllergy)
                                            .addComponent(lblWeight))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAllergy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtClaimReason, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtClaimID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPatientID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(lblPet, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblRequestDate)
                                                .addGap(34, 34, 34))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(lblSender)
                                                        .addGap(27, 27, 27))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(28, 28, 28)))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(txtSender, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtRequestDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblEmergency)
                                                        .addGap(30, 30, 30))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lblPhone)
                                                            .addComponent(lblOwnerName))
                                                        .addGap(33, 33, 33))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lblAddress)
                                                        .addGap(22, 22, 22)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(txtEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(3, 3, 3)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lblOwner)
                                                .addGap(28, 28, 28)))))
                                .addGap(150, 150, 150))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnModify)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViewDetails)
                    .addComponent(btnBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblClaimInfo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPatientID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClaimID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClaimID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClaimReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClaimReason))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClaimAmount))
                        .addGap(18, 18, 18)
                        .addComponent(lblPet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPetName)
                                    .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(146, 146, 146))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSpecies))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAge))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblWeight))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAllergy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAllergy)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRequestDate)
                            .addComponent(txtRequestDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSender)
                            .addComponent(txtSender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOwner)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOwnerName)
                            .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmergency)
                            .addComponent(txtEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedicalInfo)
                    .addComponent(lblInsuranceInfo))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDoctor)
                    .addComponent(lblCompany)
                    .addComponent(txtInsuranceCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLabResult)
                    .addComponent(txtLabResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPolicyID)
                    .addComponent(txtPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiagnosis)
                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCoverageLevel)
                    .addComponent(txtCoverageLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCost)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpirationDate)
                    .addComponent(txtExpirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnModify))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSpeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpeciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpeciesActionPerformed

    private void txtAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAgeActionPerformed

    private void txtDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiagnosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiagnosisActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    if (userProcessContainer == null) {
        return;
    }
    userProcessContainer.remove(this);
    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        setEditableFields(true);
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
     if (claim == null) {
        return;
    }

    try {
        // 1. 从界面读值并做基本校验
        String claimReason = txtClaimReason.getText().trim();
        double claimAmount = Double.parseDouble(txtClaimAmount.getText().trim());
        double cost        = Double.parseDouble(txtCost.getText().trim());

        String doctorAssigned  = txtDiagnosis.getText().trim();
        String labResult       = txtLabResult.getText().trim();
        String treatmentNeeded = txtDoctor.getText().trim();

        String insuranceCompany = txtInsuranceCompany.getText().trim();
        String coverageLevel    = txtCoverageLevel.getText().trim();
        String expirationDate   = txtExpirationDate.getText().trim();

        // 2. 写回 InsuranceClaimRequest 对象
        claim.setMessage(claimReason);
        claim.setClaimAmount(claimAmount);

        claim.setDoctorName(doctorAssigned);
        claim.setLabResult(labResult);
        claim.setTreatmentNeeded(treatmentNeeded);
        claim.setTreatmentCost(cost);

        claim.setInsuranceCompany(insuranceCompany);
        claim.setCoverageLevel(coverageLevel);
        claim.setExpirationDate(expirationDate);

        // 3. 关闭编辑
        setEditableFields(false);

        // 4. 刷新父面板表格
        if (parentPanel != null) {
            parentPanel.refreshTable();   // 下面第 ④ 步会加这个方法
        }

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Claim details have been updated.",
                "Success",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );

    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please enter valid numbers for Claim Amount and Treatment Cost.",
                "Input Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblAllergy;
    private javax.swing.JLabel lblClaimAmount;
    private javax.swing.JLabel lblClaimID;
    private javax.swing.JLabel lblClaimInfo;
    private javax.swing.JLabel lblClaimReason;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblCoverageLevel;
    private javax.swing.JLabel lblDiagnosis;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmergency;
    private javax.swing.JLabel lblExpirationDate;
    private javax.swing.JLabel lblInsuranceInfo;
    private javax.swing.JLabel lblLabResult;
    private javax.swing.JLabel lblMedicalInfo;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblOwnerName;
    private javax.swing.JLabel lblPatientID;
    private javax.swing.JLabel lblPet;
    private javax.swing.JLabel lblPetName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPolicyID;
    private javax.swing.JLabel lblRequestDate;
    private javax.swing.JLabel lblSender;
    private javax.swing.JLabel lblSpecies;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblViewDetails;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtAllergy;
    private javax.swing.JTextField txtClaimAmount;
    private javax.swing.JTextField txtClaimID;
    private javax.swing.JTextField txtClaimReason;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtCoverageLevel;
    private javax.swing.JTextField txtDiagnosis;
    private javax.swing.JTextField txtDoctor;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmergency;
    private javax.swing.JTextField txtExpirationDate;
    private javax.swing.JTextField txtInsuranceCompany;
    private javax.swing.JTextField txtLabResult;
    private javax.swing.JTextField txtOwnerName;
    private javax.swing.JTextField txtPatientID;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPolicyID;
    private javax.swing.JTextField txtRequestDate;
    private javax.swing.JTextField txtSender;
    private javax.swing.JTextField txtSpecies;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
