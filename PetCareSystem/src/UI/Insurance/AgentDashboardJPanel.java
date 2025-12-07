package UI.Insurance;
import Business.Petsystem;
import Business.UserAccount.UserAccount;

import Business.Pet.InsurancePolicy;
import Business.Pet.InsurancePolicyDirectory;

import Business.Network.Network;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Organization.Organization;

import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.InsuranceClaimRequest;
import Business.PetInsuranceOrganization.InsurancePolicyOrganization;
import javax.swing.JPanel;
import Business.PetInsuranceOrganization.InsuranceClaimOrganization;

/**
 *
 * @author Eve Dou
 */
        public class AgentDashboardJPanel extends javax.swing.JPanel {
            private JPanel userProcessContainer; // Parent container used for CardLayout navigation.
            private UserAccount account; // Logged-in user account (agent).
            private InsurancePolicyOrganization organization; // Policy organization for this agent
            private PetInsuranceEnterprise enterprise; // Insurance enterprise this agent belongs to.
            private Petsystem system;
    
        public AgentDashboardJPanel() {
            initComponents();
        }
    
        public AgentDashboardJPanel(JPanel userProcessContainer,
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

        // Populate dashboard with calculated metrics.
        populateDashboard();
    }
        
        private void populateDashboard() {
        if (system == null) return;

        // 1. Policy-related metrics
        InsurancePolicyDirectory policyDir = system.getInsurancePolicyDirectory();
        if (policyDir != null) {

            int totalPolicies = 0;
            int activePolicies = 0;
            int expiredPolicies = 0;
            int cancelledPolicies = 0;

            int fullPolicies = 0;
            int partialPolicies = 0;
            int activeFullPolicies = 0;
            int activePartialPolicies = 0;

            for (InsurancePolicy p : policyDir.getPolicyList()) {
                totalPolicies++;

                String status = p.getStatus();
                String type   = p.getCoverageType(); // Full Coverage / Partial Coverage

                if ("Active".equalsIgnoreCase(status)) {
                    activePolicies++;
                } else if ("Expired".equalsIgnoreCase(status)) {
                    expiredPolicies++;
                } else if ("Cancelled".equalsIgnoreCase(status)) {
                    cancelledPolicies++;
                }

                if ("Full Coverage".equalsIgnoreCase(type)) {
                    fullPolicies++;
                    if ("Active".equalsIgnoreCase(status)) {
                        activeFullPolicies++;
                    }
                } else if ("Partial Coverage".equalsIgnoreCase(type)) {
                    partialPolicies++;
                    if ("Active".equalsIgnoreCase(status)) {
                        activePartialPolicies++;
                    }
                }
            }

            double activeRate = (totalPolicies == 0)
                    ? 0.0
                    : (activePolicies * 100.0 / totalPolicies);

            txtTotalPolicy.setText(String.valueOf(totalPolicies));
            txtActivePolicy.setText(String.valueOf(activePolicies));
            txtExpiredPolicy.setText(String.valueOf(expiredPolicies));
            txtCancelledPolicy.setText(String.valueOf(cancelledPolicies));
            txtActiveRate.setText(String.format("%.1f%%", activeRate));

            txtFullCoverage.setText(String.valueOf(fullPolicies));
            txtPartialCoverage.setText(String.valueOf(partialPolicies));
            txtActiveFull.setText(String.valueOf(activeFullPolicies));
            txtActivePartial.setText(String.valueOf(activePartialPolicies));
        }

        // 2. Claim-related metrics
        int totalClaims = 0;
        int approvedClaims = 0;
        int rejectedClaims = 0;
        int pendingClaims = 0;
        double totalClaimAmount = 0.0;

        /* Traverse all networks → enterprises → organizations
           and aggregate all InsuranceClaimRequest from InsuranceClaimOrganization. */
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {

                if (ent instanceof PetInsuranceEnterprise) {
                    for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {

                
                        if (org instanceof InsuranceClaimOrganization) {

                            for (WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                             if (wr instanceof InsuranceClaimRequest) {
                                InsuranceClaimRequest req = (InsuranceClaimRequest) wr;

                                totalClaims++;

                                String decision = req.getClaimDecision(); // Approved / Rejected
                                String statusWr = req.getStatus();        // Pending

                                if ("Approved".equalsIgnoreCase(decision)) {
                                    approvedClaims++;
                                } else if ("Rejected".equalsIgnoreCase(decision)) {
                                    rejectedClaims++;
                                } else if ("Pending".equalsIgnoreCase(statusWr)) {
                                    pendingClaims++;
                                }

                                totalClaimAmount += req.getClaimAmount();
                        }
                    }
                }
            }
        }
    }
}

        double approvalRate = (totalClaims == 0)
                ? 0.0
                : (approvedClaims * 100.0 / totalClaims);

        double avgClaimAmount = (totalClaims == 0)
                ? 0.0
                : (totalClaimAmount / totalClaims);

        txtTotalClaims.setText(String.valueOf(totalClaims));
        txtApprovedClaims.setText(String.valueOf(approvedClaims));
        txtRejectedClaims.setText(String.valueOf(rejectedClaims));
        txtPendingClaims.setText(String.valueOf(pendingClaims));
        txtApprovalRate.setText(String.format("%.1f%%", approvalRate));
        txtAverageClaimAmount.setText(String.format("%.2f", avgClaimAmount));
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblPolicy = new javax.swing.JLabel();
        lblTotalPolicy = new javax.swing.JLabel();
        lblAcitivePolicy = new javax.swing.JLabel();
        lblExpiredPolicy = new javax.swing.JLabel();
        txtTotalPolicy = new javax.swing.JTextField();
        txtActivePolicy = new javax.swing.JTextField();
        txtExpiredPolicy = new javax.swing.JTextField();
        lblClaimOverview = new javax.swing.JLabel();
        lblTotalClaims = new javax.swing.JLabel();
        txtTotalClaims = new javax.swing.JTextField();
        lblApprovedClaims = new javax.swing.JLabel();
        txtApprovedClaims = new javax.swing.JTextField();
        lblRejectedClaims = new javax.swing.JLabel();
        txtRejectedClaims = new javax.swing.JTextField();
        lblPendingClaims = new javax.swing.JLabel();
        txtPendingClaims = new javax.swing.JTextField();
        lblCoverageOverview = new javax.swing.JLabel();
        lblFullCoverage = new javax.swing.JLabel();
        txtFullCoverage = new javax.swing.JTextField();
        lblPartialCoverage = new javax.swing.JLabel();
        txtPartialCoverage = new javax.swing.JTextField();
        lblCancelledPolicy = new javax.swing.JLabel();
        txtCancelledPolicy = new javax.swing.JTextField();
        lblActiveRate = new javax.swing.JLabel();
        txtActiveRate = new javax.swing.JTextField();
        lblApprovalRate = new javax.swing.JLabel();
        txtApprovalRate = new javax.swing.JTextField();
        lblAverageClaimAmount = new javax.swing.JLabel();
        txtAverageClaimAmount = new javax.swing.JTextField();
        lblActiveFull = new javax.swing.JLabel();
        txtActiveFull = new javax.swing.JTextField();
        lblActivePartial = new javax.swing.JLabel();
        txtActivePartial = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 255));

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setText("Insurance Operation Dashboard");

        btnBack.setText("<<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblPolicy.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPolicy.setText("Policy Overview");

        lblTotalPolicy.setText("Total Policies:");

        lblAcitivePolicy.setText("Active Policies:");

        lblExpiredPolicy.setText("Expired Policies:");

        txtTotalPolicy.setEditable(false);

        txtActivePolicy.setEditable(false);

        txtExpiredPolicy.setEditable(false);
        txtExpiredPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpiredPolicyActionPerformed(evt);
            }
        });

        lblClaimOverview.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblClaimOverview.setText("Claim Overview");

        lblTotalClaims.setText("Total Claims:");

        txtTotalClaims.setEditable(false);

        lblApprovedClaims.setText("Approved Claims:");

        txtApprovedClaims.setEditable(false);

        lblRejectedClaims.setText("Rejected Claims:");

        txtRejectedClaims.setEditable(false);

        lblPendingClaims.setText("Pending Claims:");

        txtPendingClaims.setEditable(false);

        lblCoverageOverview.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblCoverageOverview.setText("Coverage Overview");

        lblFullCoverage.setText("Full Coverage Policies:");

        txtFullCoverage.setEditable(false);

        lblPartialCoverage.setText("Partial Coverage Policies:");

        txtPartialCoverage.setEditable(false);

        lblCancelledPolicy.setText("Cancelled Policies:");

        txtCancelledPolicy.setEditable(false);

        lblActiveRate.setText("Active Rate:");

        txtActiveRate.setEditable(false);

        lblApprovalRate.setText("Approval Rate:");

        txtApprovalRate.setEditable(false);

        lblAverageClaimAmount.setText("Average Claim Amount:");

        txtAverageClaimAmount.setEditable(false);

        lblActiveFull.setText("Active Full Coverage Policies:");

        txtActiveFull.setEditable(false);

        lblActivePartial.setText("Active Partial Coverage Policies:");

        txtActivePartial.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCancelledPolicy)
                    .addComponent(lblActiveRate))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtActiveRate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCancelledPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClaimOverview, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblActivePartial)
                                .addComponent(lblActiveFull))
                            .addGap(37, 37, 37))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAverageClaimAmount)
                                        .addComponent(lblApprovalRate))
                                    .addGap(18, 18, 18)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblFullCoverage)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(188, 188, 188)
                                            .addComponent(txtFullCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblPartialCoverage)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPartialCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTotalClaims)
                                        .addComponent(lblRejectedClaims)
                                        .addComponent(lblPendingClaims)
                                        .addComponent(lblApprovedClaims))
                                    .addGap(50, 50, 50)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtApprovedClaims, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTotalClaims, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtRejectedClaims)
                                        .addComponent(txtPendingClaims, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblExpiredPolicy)
                                        .addComponent(lblTotalPolicy)
                                        .addComponent(lblAcitivePolicy))
                                    .addGap(66, 66, 66)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtActivePolicy, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtTotalPolicy, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtExpiredPolicy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCoverageOverview)
                                .addGap(200, 200, 200)))
                        .addGap(253, 253, 253)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnBack))
                    .addComponent(txtApprovalRate)
                    .addComponent(txtAverageClaimAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(txtActiveFull)
                    .addComponent(txtActivePartial))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnBack))
                .addGap(27, 27, 27)
                .addComponent(lblPolicy)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTotalPolicy)
                        .addGap(18, 18, 18)
                        .addComponent(lblAcitivePolicy)
                        .addGap(18, 18, 18)
                        .addComponent(lblExpiredPolicy))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTotalPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtActivePolicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCancelledPolicy)
                                    .addComponent(txtCancelledPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblActiveRate)
                                    .addComponent(txtActiveRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addComponent(txtExpiredPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(lblClaimOverview)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTotalClaims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTotalClaims))
                            .addGap(16, 16, 16)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtApprovedClaims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblApprovedClaims)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblApprovalRate)
                            .addGap(16, 16, 16)
                            .addComponent(lblAverageClaimAmount)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtApprovalRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(txtAverageClaimAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRejectedClaims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRejectedClaims))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPendingClaims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPendingClaims))
                .addGap(28, 28, 28)
                .addComponent(lblCoverageOverview)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullCoverage)
                    .addComponent(txtFullCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActiveFull)
                    .addComponent(txtActiveFull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPartialCoverage)
                    .addComponent(txtPartialCoverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblActivePartial)
                    .addComponent(txtActivePartial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtExpiredPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpiredPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpiredPolicyActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (userProcessContainer == null) return;
        userProcessContainer.remove(this);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblAcitivePolicy;
    private javax.swing.JLabel lblActiveFull;
    private javax.swing.JLabel lblActivePartial;
    private javax.swing.JLabel lblActiveRate;
    private javax.swing.JLabel lblApprovalRate;
    private javax.swing.JLabel lblApprovedClaims;
    private javax.swing.JLabel lblAverageClaimAmount;
    private javax.swing.JLabel lblCancelledPolicy;
    private javax.swing.JLabel lblClaimOverview;
    private javax.swing.JLabel lblCoverageOverview;
    private javax.swing.JLabel lblExpiredPolicy;
    private javax.swing.JLabel lblFullCoverage;
    private javax.swing.JLabel lblPartialCoverage;
    private javax.swing.JLabel lblPendingClaims;
    private javax.swing.JLabel lblPolicy;
    private javax.swing.JLabel lblRejectedClaims;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalClaims;
    private javax.swing.JLabel lblTotalPolicy;
    private javax.swing.JTextField txtActiveFull;
    private javax.swing.JTextField txtActivePartial;
    private javax.swing.JTextField txtActivePolicy;
    private javax.swing.JTextField txtActiveRate;
    private javax.swing.JTextField txtApprovalRate;
    private javax.swing.JTextField txtApprovedClaims;
    private javax.swing.JTextField txtAverageClaimAmount;
    private javax.swing.JTextField txtCancelledPolicy;
    private javax.swing.JTextField txtExpiredPolicy;
    private javax.swing.JTextField txtFullCoverage;
    private javax.swing.JTextField txtPartialCoverage;
    private javax.swing.JTextField txtPendingClaims;
    private javax.swing.JTextField txtRejectedClaims;
    private javax.swing.JTextField txtTotalClaims;
    private javax.swing.JTextField txtTotalPolicy;
    // End of variables declaration//GEN-END:variables
}
