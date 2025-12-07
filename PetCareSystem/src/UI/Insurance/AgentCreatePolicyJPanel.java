package UI.Insurance;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Pet.InsurancePolicy;
import Business.Pet.InsurancePolicyDirectory;
import Business.Pet.Pet;
import Business.Pet.PetDirectory;
import Business.Pet.PetOwner;
import Business.Pet.PetOwnerDirectory;
import Business.Petsystem;
import Business.PetInsuranceOrganization.InsurancePolicyOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Component;
import UI.Insurance.AgentWorkAreaJPanel;


public class AgentCreatePolicyJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer; //Parent container for CardLayout navigation.
    private UserAccount account; //Logged-in user (Insurance Agent).
    private InsurancePolicyOrganization organization; //Organization responsible for insurance policy management.
    private PetInsuranceEnterprise enterprise; //Insurance enterprise this agent belongs to.
    private Petsystem system;

    
    public AgentCreatePolicyJPanel() {
        initComponents();
    }

    
    public AgentCreatePolicyJPanel(JPanel userProcessContainer,
                                   UserAccount account,
                                   InsurancePolicyOrganization organization,
                                   PetInsuranceEnterprise enterprise,
                                   Petsystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lblPetInfo = new javax.swing.JLabel();
        lblPetName = new javax.swing.JLabel();
        txtPetName = new javax.swing.JTextField();
        lblSpecies = new javax.swing.JLabel();
        txtSpecies = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblWeight = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        lblOwnerInfo = new javax.swing.JLabel();
        txtOwnerName = new javax.swing.JTextField();
        lblOwnerName = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblEmergency = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmergency = new javax.swing.JTextField();
        lblPolicyInfo = new javax.swing.JLabel();
        lblPolicyID = new javax.swing.JLabel();
        txtPolicyID = new javax.swing.JTextField();
        lblCoverageType = new javax.swing.JLabel();
        txtCoverageType = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        txtExpiration = new javax.swing.JTextField();
        lblExpirationDate = new javax.swing.JLabel();
        txtStart = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 255));

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setText("Create New Policy");

        btnBack.setText("<<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblPetInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPetInfo.setText("Pet Information");

        lblPetName.setText("PetName:");

        lblSpecies.setText("Species:");

        txtSpecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpeciesActionPerformed(evt);
            }
        });

        lblAge.setText("Age:");

        lblWeight.setText("Weight:");

        lblOwnerInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblOwnerInfo.setText("Owner Information");

        lblOwnerName.setText("OwnerName:");

        lblPhone.setText("Phone:");

        lblEmail.setText("Email:");

        lblAddress.setText("Address:");

        lblEmergency.setText("Emergency:");

        lblPolicyInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPolicyInfo.setText("Policy Information");

        lblPolicyID.setText("PolicyID:");

        lblCoverageType.setText("CoverageType:");

        lblStartDate.setText("StartDate:");

        lblExpirationDate.setText("ExpirationDate:");

        txtStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartActionPerformed(evt);
            }
        });

        lblStatus.setText("Status:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPetInfo)
                    .addComponent(lblPolicyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblSpecies, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPetName, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblAge)
                            .addComponent(lblWeight))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPolicyID)
                                    .addComponent(lblCoverageType))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStartDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblExpirationDate)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCoverageType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblAddress)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOwnerInfo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblEmergency)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174)
                .addComponent(btnBack)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle)
                            .addComponent(btnBack))
                        .addGap(45, 45, 45)
                        .addComponent(lblOwnerInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(lblPetInfo)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOwnerName)
                            .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhone)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPetName)
                        .addGap(27, 27, 27)
                        .addComponent(lblSpecies)
                        .addGap(18, 18, 18)
                        .addComponent(lblAge)
                        .addGap(18, 18, 18)
                        .addComponent(lblWeight)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmergency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(lblPolicyInfo)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPolicyID)
                            .addComponent(txtPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStartDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblExpirationDate))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSave)
                                .addGap(3, 3, 3)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCoverageType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCoverageType)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSpeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpeciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpeciesActionPerformed

    private void txtStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (userProcessContainer != null) {
        userProcessContainer.remove(this); // Remove this panel from the container

        // Get the previous component from the container
        Component[] comps = userProcessContainer.getComponents();
        Component c = comps[comps.length - 1];

        // Refresh the policy table in the work area if we are returning there
        if (c instanceof AgentWorkAreaJPanel) {
            AgentWorkAreaJPanel panel = (AgentWorkAreaJPanel) c;
            panel.populatePolicyTable(); 
        }

        // Navigate back using CardLayout
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
           // 1. Read input from UI fields

           // Pet
           String petName   = txtPetName.getText().trim();
           String species   = txtSpecies.getText().trim();
           String ageStr    = txtAge.getText().trim();
           String weightStr = txtWeight.getText().trim();

           // Owner
           String ownerName = txtOwnerName.getText().trim();
           String phone     = txtPhone.getText().trim();
           String email     = txtEmail.getText().trim();
           String address   = txtAddress.getText().trim();
           String emergency = txtEmergency.getText().trim();

           // Policy
           String policyId       = txtPolicyID.getText().trim();
           String coverageType   = txtCoverageType.getText().trim(); 
           String startDate      = txtStart.getText().trim();
           String expirationDate = txtExpiration.getText().trim();
           String status         = txtStatus.getText().trim();

           
           // 2. Basic validation for required fields
           if (petName.isEmpty() || species.isEmpty() || ownerName.isEmpty()
                   || policyId.isEmpty() || coverageType.isEmpty()
                   || startDate.isEmpty() || expirationDate.isEmpty()) {

               JOptionPane.showMessageDialog(
                       this,
                       "Pet / Owner / Policy key fields cannot be empty!",
                       "Warning",
                       JOptionPane.WARNING_MESSAGE
               );
               return;
           }

           
           // 3. Convert age and weight to numeric values
           int age;
           double weight;
           try {
               age = Integer.parseInt(ageStr);
               weight = Double.parseDouble(weightStr);
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(
                       this,
                       "Please enter a valid number for Age and Weight.",
                       "Format Error",
                       JOptionPane.ERROR_MESSAGE
               );
               return;
           }

           
           // 4. Retrieve directories from system
           if (system == null) {
               JOptionPane.showMessageDialog(
                       this,
                       "System is not initialized.",
                       "System Error",
                       JOptionPane.ERROR_MESSAGE
               );
               return;
           }

           PetOwnerDirectory ownerDir = system.getPetOwnerDirectory();
           if (ownerDir == null) {
               JOptionPane.showMessageDialog(
                       this,
                       "PetOwnerDirectory is not initialized in the system.",
                       "System Error",
                       JOptionPane.ERROR_MESSAGE
               );
               return;
           }

           InsurancePolicyDirectory policyDir = system.getInsurancePolicyDirectory();
            if (policyDir == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "InsurancePolicyDirectory is not initialized in the system.",
                        "System Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }


           // 5. Create a PetOwner record
           String ownerId = "PO" + System.currentTimeMillis();

           String insuranceCompany = enterprise.getName();

           PetOwner owner = ownerDir.addOwner(
                   ownerId,
                   ownerName,
                   phone,
                   email,
                   address,
                   emergency,
                   insuranceCompany,
                   policyId,
                   coverageType,
                   expirationDate
           );

           
           // 6. Create a Pet under this owner
           PetDirectory petDir = owner.getPetDirectory();
           if (petDir == null) {
               JOptionPane.showMessageDialog(
                       this,
                       "PetDirectory is not initialized for this owner.",
                       "System Error",
                       JOptionPane.ERROR_MESSAGE
               );
               return;
           }

           
           String petId = "P" + System.currentTimeMillis();

           Pet pet = petDir.addPet(
                   petId,
                   petName,
                   species,
                   age,
                   weight,
                   "N/A",   // favoriteFood
                   "N/A",   // allergy
                   "N/A",   // medicalNotes
                   owner
           );

           
           // 7. Create an InsurancePolicy and store it in the system directory
              double premium = 0.0;

              InsurancePolicy policy = policyDir.addPolicy(
                                                    policyId,
                                                    insuranceCompany,
                                                    coverageType,
                                                    startDate,
                                                    expirationDate,
                                                    premium,
                                                    status,
                                                    pet,
                                                    owner
         );




           // 8. Show success message and clear fields
           JOptionPane.showMessageDialog(
                   this,
                   "Policy created successfully.",
                   "Success",
                   JOptionPane.INFORMATION_MESSAGE
           );

        
           txtPetName.setText("");
           txtSpecies.setText("");
           txtAge.setText("");
           txtWeight.setText("");

           txtOwnerName.setText("");
           txtPhone.setText("");
           txtEmail.setText("");
           txtAddress.setText("");
           txtEmergency.setText("");

           txtPolicyID.setText("");
           txtCoverageType.setText("");
           txtStart.setText("");
           txtExpiration.setText("");
           txtStatus.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCoverageType;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmergency;
    private javax.swing.JLabel lblExpirationDate;
    private javax.swing.JLabel lblOwnerInfo;
    private javax.swing.JLabel lblOwnerName;
    private javax.swing.JLabel lblPetInfo;
    private javax.swing.JLabel lblPetName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPolicyID;
    private javax.swing.JLabel lblPolicyInfo;
    private javax.swing.JLabel lblSpecies;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCoverageType;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmergency;
    private javax.swing.JTextField txtExpiration;
    private javax.swing.JTextField txtOwnerName;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPolicyID;
    private javax.swing.JTextField txtSpecies;
    private javax.swing.JTextField txtStart;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
