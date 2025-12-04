package UI.Insurance;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PetBoardingEnterprise;
import Business.UserAccount.UserAccount;
import Business.Petsystem;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.CustomerService;
import Business.PetBoardingOrganization.CustomerService;
import Business.PetInsuranceOrganization.InsuranceClaimOrganization;
import Business.WorkQueue.CompensationNotificationRequest;
import Business.WorkQueue.HealthCareCheckRequest;
import Business.WorkQueue.InsuranceClaimRequest;
import Business.WorkQueue.WorkRequest;
import UI.admin.MainJFrame;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eve Dou
 */
    public class ClaimProcessorWorkAreaJPanel extends javax.swing.JPanel {
        private JPanel userProcessContainer; // Parent container used for CardLayout navigation
        private UserAccount account; // Logged-in claim processor account
        private InsuranceClaimOrganization organization; //  Claim organization this processor belongs to
        private PetInsuranceEnterprise enterprise;
        private Petsystem system;
        private InsuranceClaimOrganization claimOrg; 

    
    public ClaimProcessorWorkAreaJPanel(JPanel userProcessContainer,
                                        UserAccount account,
                                        InsuranceClaimOrganization organization,
                                        PetInsuranceEnterprise enterprise,
                                        Petsystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.claimOrg = organization; 
        this.enterprise = enterprise;
        this.system = system;
        
        populateTable();
    }
    
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblInsuranceClaim.getModel();
        model.setRowCount(0);

        for (WorkRequest req : claimOrg.getWorkQueue().getWorkRequestList()) {
            if (req instanceof InsuranceClaimRequest) {
                InsuranceClaimRequest claim = (InsuranceClaimRequest) req;


                Object[] row = new Object[12];

                row[0]  = claim.getPatientId(); 
                row[1]  = claim.getPolicyId();           
                row[2]  = claim.getHolderName();         
                row[3]  = claim.getPetName();           
                row[4]  = claim.getSymptom();            
                row[5]  = claim.getLabResult();          
                row[6]  = claim.getTreatmentCost();      
                row[7]  = claim.getCoverageLevel();      
                row[8]  = claim.getClaimAmount();      
                row[9]  = claim.getSender();             
                row[10] = claim.getStatus();            
                row[11] = claim.getCoverageDecision();   

                model.addRow(row);
        }
    }

}
        private void autoDecideCoverage(InsuranceClaimRequest claim) {
            // Coverage level, Full Coverage / Partial Coverage 
            String level = claim.getCoverageLevel();
            double ratio;

            // Full coverage → 100%, otherwise → 50%
            if (level != null && level.toLowerCase().contains("full")) {
                ratio = 1.0;   // full coverage
            } else {
                ratio = 0.5;   // partial coverage
            }
            
            // Approved amount = treatment cost * ratio
            double approvedAmount = claim.getTreatmentCost() * ratio;
            claim.setClaimAmount(approvedAmount);

            if (ratio == 1.0) {
                claim.setStatus("Approved");
                claim.setCoverageDecision("Full Coverage");
                claim.setClaimDecision("Approved");
            } else {
                claim.setStatus("Approved");
                claim.setCoverageDecision("Partial Coverage");
                claim.setClaimDecision("Approved");
            }
        }
        
        
        /* Converts an approved InsuranceClaimRequest into a CompensationNotificationRequest
            and routes it to the CustomerService organization under the Pet Boarding Enterprise.
        */
        private void sendCompensationNotification(InsuranceClaimRequest claim) {

            // Attempt to retrieve the related boarding record (if linked through HealthCareCheckRequest)
            HealthCareCheckRequest healthReq = claim.getHealthRequest();
            String boardingRecordId = null;
            if (healthReq != null) {
                boardingRecordId = healthReq.getBoardingRecordId();
            }

            // Create a new compensation notification request
            CompensationNotificationRequest compReq = new CompensationNotificationRequest();
            compReq.setSender(account);   // 当前 Claim Processor
            compReq.setMessage("Compensation for claim " + claim.getClaimId());
            compReq.setCompensationAmount(claim.getClaimAmount());
            compReq.setNote("Decision: " + claim.getCoverageDecision());

            
            compReq.setBoardingRecordId(boardingRecordId);

            // Locate the CustomerService organization inside Pet Boarding Enterprise
            // and add the notification to its work queue
            for (Network net : system.getNetworkList()) {
                for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {

                    if (ent instanceof PetBoardingEnterprise) {  // only search inside Boarding Enterprise
                        for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {

                            if (org instanceof CustomerService) { // target: Customer Service org
                                org.getWorkQueue().getWorkRequestList().add(compReq);

                                // Also record it under the sender’s own queue
                                account.getWorkQueue().getWorkRequestList().add(compReq);
                                return; // Stop searching once found
                            }
                        }
                    }
                }
            }

            System.out.println("WARN: No PetBoarding CustomerService found for compensation notification.");

        }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInsuranceClaimProcess = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInsuranceClaim = new javax.swing.JTable();
        btnPolicyRecord = new javax.swing.JButton();
        btnViewDetail = new javax.swing.JButton();
        lblClaimList = new javax.swing.JLabel();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnSendCompensation = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        lblInsuranceClaimProcess.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblInsuranceClaimProcess.setText("Welcome Insurance Claim Management ");

        btnLogOut.setText("Logout");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        tblInsuranceClaim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient ID", "Policy ID", "Holder Name", "Pet Name", "Symptom", "Lab Result", "Treatment Cost", "Coverage Level", "Claim Amount", "Sender", "Status", "Decision"
            }
        ));
        jScrollPane1.setViewportView(tblInsuranceClaim);

        btnPolicyRecord.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnPolicyRecord.setText("View Policy Record");
        btnPolicyRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPolicyRecordActionPerformed(evt);
            }
        });

        btnViewDetail.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnViewDetail.setText("View Claim Details");
        btnViewDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailActionPerformed(evt);
            }
        });

        lblClaimList.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblClaimList.setText("Claim List:");

        btnApprove.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnReject.setText("Reject");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        btnSendCompensation.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        btnSendCompensation.setText("Send Compensation");
        btnSendCompensation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendCompensationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInsuranceClaimProcess)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogOut)
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClaimList, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(1056, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPolicyRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(btnSendCompensation, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInsuranceClaimProcess)
                    .addComponent(btnLogOut))
                .addGap(34, 34, 34)
                .addComponent(lblClaimList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetail)
                    .addComponent(btnApprove))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReject)
                    .addComponent(btnPolicyRecord)
                    .addComponent(btnSendCompensation))
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        java.awt.Window window = SwingUtilities.getWindowAncestor(this);
        
        if (window instanceof MainJFrame) {
            MainJFrame mainFrame = (MainJFrame) window; 
            mainFrame.triggerLogout();
        } else {
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
    }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnViewDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailActionPerformed
        // Get selected row; if none selected, warn user
        int selectedRow = tblInsuranceClaim.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a claim first.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Extract policy ID from table (column index 1)
        String policyId = (String) tblInsuranceClaim.getValueAt(selectedRow, 1);
        
        // Search the work queue for the matching InsuranceClaimRequest
        InsuranceClaimRequest targetClaim = null;
        for (WorkRequest req : claimOrg.getWorkQueue().getWorkRequestList()) {
            if (req instanceof InsuranceClaimRequest) {
                InsuranceClaimRequest ic = (InsuranceClaimRequest) req;
                if (policyId.equals(ic.getPolicyId())) {
                    targetClaim = ic;
                    break;
                }
            }
        }

        // If not found, show error
        if (targetClaim == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cannot find this claim in work queue.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Open the detail panel for the selected claim
        ClaimDetailJPanel detailPanel = new ClaimDetailJPanel(userProcessContainer, targetClaim);
        userProcessContainer.add("ClaimDetailJPanel", detailPanel);
        
        // Switch card layout to the detail panel
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewDetailActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // Get selected row; if none selected, stop    
        int selectedRow = tblInsuranceClaim.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select a claim first.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            // Retrieve policy ID from the selected table row
            String policyId = (String) tblInsuranceClaim.getValueAt(selectedRow, 1);

            // Locate the corresponding InsuranceClaimRequest in the work queue
            InsuranceClaimRequest targetClaim = null;
            for (WorkRequest req : claimOrg.getWorkQueue().getWorkRequestList()) {
                if (req instanceof InsuranceClaimRequest) {
                    InsuranceClaimRequest ic = (InsuranceClaimRequest) req;
                    if (policyId.equals(ic.getPolicyId())) {
                        targetClaim = ic;
                        break;
                    }
                }
            }
            
            // If no matching claim is found
            if (targetClaim == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Cannot find this claim in work queue.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            // Prevent double processing (approved / rejected already)
            if ("Approved".equalsIgnoreCase(targetClaim.getStatus())) {
                JOptionPane.showMessageDialog(
                        this,
                        "This claim is already approved.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
            if ("Rejected".equalsIgnoreCase(targetClaim.getStatus())) {
                JOptionPane.showMessageDialog(
                        this,
                        "This claim has been rejected.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
            
               // Automatically calculate approval amount and update claim status
               autoDecideCoverage(targetClaim);
               
               // Show result summary to user
                JOptionPane.showMessageDialog(
                        this,
                        "Claim processed.\n"
                        + "Status: " + targetClaim.getStatus() + "\n"
                        + "Decision: " + targetClaim.getCoverageDecision() + "\n"
                        + "Amount: " + targetClaim.getClaimAmount(),
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                );
                
                // Refresh table to reflect updates
                populateTable();

    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
         // Ensure a row is selected in the table
        int selectedRow = tblInsuranceClaim.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a claim first.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

          // Retrieve policy ID from the selected row
        String policyId = (String) tblInsuranceClaim.getValueAt(selectedRow, 1);
       
        // Find the matching InsuranceClaimRequest in the work queue
        InsuranceClaimRequest targetClaim = null;
        for (WorkRequest req : claimOrg.getWorkQueue().getWorkRequestList()) {
            if (req instanceof InsuranceClaimRequest) {
                InsuranceClaimRequest ic = (InsuranceClaimRequest) req;
                if (policyId.equals(ic.getPolicyId())) {
                    targetClaim = ic;
                    break;
                }
            }
        }

        // Stop if claim cannot be found
        if (targetClaim == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cannot find this claim in work queue.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Prevent re-processing previously handled claims
        if ("Rejected".equalsIgnoreCase(targetClaim.getStatus())) {
            JOptionPane.showMessageDialog(
                    this,
                    "This claim is already rejected.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
        if ("Approved".equalsIgnoreCase(targetClaim.getStatus())) {
            JOptionPane.showMessageDialog(
                    this,
                    "This claim has been approved and cannot be rejected.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }
    
        // Ask for confirmation before rejecting the claim
        int result = JOptionPane.showConfirmDialog(
                this,
                "Are you sure to reject this claim?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );
        
        if (result != JOptionPane.YES_OPTION) {
            return;
        }

             // Update claim’s final status and coverage decision
            targetClaim.setStatus("Rejected");
            targetClaim.setClaimDecision("Rejected");
            targetClaim.setCoverageDecision("No Coverage"); 


        JOptionPane.showMessageDialog(
                this,
                "Claim rejected.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Refresh the table to show updates
        populateTable();
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnPolicyRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPolicyRecordActionPerformed
    ClaimPolicyRecordJPanel panel = new ClaimPolicyRecordJPanel(userProcessContainer, claimOrg);
    userProcessContainer.add("ClaimPolicyRecordJPanel", panel);
    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPolicyRecordActionPerformed

    private void btnSendCompensationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendCompensationActionPerformed
        // 1. Retrieve the selected claim from the table
        int selectedRow = tblInsuranceClaim.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please select a claim first.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Extract the policy ID from column index 1
        String policyId = (String) tblInsuranceClaim.getValueAt(selectedRow, 1);

        // 2. Locate the corresponding InsuranceClaimRequest in the work queue
        InsuranceClaimRequest targetClaim = null;
        for (WorkRequest req : claimOrg.getWorkQueue().getWorkRequestList()) {
            if (req instanceof InsuranceClaimRequest) {
                InsuranceClaimRequest ic = (InsuranceClaimRequest) req;
                if (policyId.equals(ic.getPolicyId())) {
                    targetClaim = ic;
                    break;
                }
            }
        }

        if (targetClaim == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Cannot find this claim in work queue.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 3. Only approved claims can trigger compensation notification
        if (!"Approved".equalsIgnoreCase(targetClaim.getStatus())) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please approve the claim before sending compensation notification.",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        // 4. Send the compensation notification to the Pet Boarding enterprise
        sendCompensationNotification(targetClaim);

        JOptionPane.showMessageDialog(
                this,
                "Compensation notification has been sent to Pet Boarding.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_btnSendCompensationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPolicyRecord;
    private javax.swing.JButton btnReject;
    private javax.swing.JButton btnSendCompensation;
    private javax.swing.JButton btnViewDetail;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClaimList;
    private javax.swing.JLabel lblInsuranceClaimProcess;
    private javax.swing.JTable tblInsuranceClaim;
    // End of variables declaration//GEN-END:variables
}
