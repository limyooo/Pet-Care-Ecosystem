/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.enterpriseAdmin;

import Business.Enterprise.Enterprise;
import Business.Enterprise.PetInsuranceEnterprise;
import Business.Petsystem;
import java.awt.CardLayout;
import javax.swing.JPanel;
import UI.Insurance.AgentDashboardJPanel;


/**
 *
 * @author jingyangwang
 */
public class ViewReportsJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Petsystem system;
   
    public ViewReportsJPanel(JPanel userProcessContainer, Enterprise enterprise, Petsystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPetBoardingReport = new javax.swing.JButton();
        btnPetClinicReport = new javax.swing.JButton();
        btnPetInsuranceReport = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        btnPetBoardingReport.setText("Pet Boarding Report");
        btnPetBoardingReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetBoardingReportActionPerformed(evt);
            }
        });

        btnPetClinicReport.setText("Pet Clinic Report");
        btnPetClinicReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetClinicReportActionPerformed(evt);
            }
        });

        btnPetInsuranceReport.setText("Pet Insurance Report");
        btnPetInsuranceReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetInsuranceReportActionPerformed(evt);
            }
        });

        btnBack.setText("<<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPetInsuranceReport)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnPetClinicReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPetBoardingReport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(353, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnBack)
                .addGap(46, 46, 46)
                .addComponent(btnPetBoardingReport)
                .addGap(34, 34, 34)
                .addComponent(btnPetClinicReport)
                .addGap(33, 33, 33)
                .addComponent(btnPetInsuranceReport)
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPetClinicReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetClinicReportActionPerformed
        PetClinicReportJPanel panel = new PetClinicReportJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("ClinicReportJPanel", panel);
        ((CardLayout) userProcessContainer.getLayout()).next(userProcessContainer);
    }//GEN-LAST:event_btnPetClinicReportActionPerformed

    private void btnPetInsuranceReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetInsuranceReportActionPerformed
        // Check enterprise type
    if (!(enterprise instanceof PetInsuranceEnterprise)) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "This dashboard is only available for Pet Insurance Enterprise.");
        return;
    }

    PetInsuranceEnterprise insEnt = (PetInsuranceEnterprise) enterprise;

   
    AgentDashboardJPanel panel = new AgentDashboardJPanel(
            userProcessContainer,
            null,                      // UserAccount
            null,                      // InsurancePolicyOrganization
            insEnt,
            system
    );

    userProcessContainer.add("AgentDashboardJPanel", panel);
    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.next(userProcessContainer);
    }//GEN-LAST:event_btnPetInsuranceReportActionPerformed

    private void btnPetBoardingReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetBoardingReportActionPerformed
      // 1. Find a boarding-related Organization (for incident rate calculation) 查找 Boarding 相关的 Organization（用于 Incident Rate 的计算）
    Business.Organization.Organization targetOrganization = null;

    if (enterprise.getOrganizationDirectory() != null) {
        // Enterprise admin can access all organizations under the enterprise Enterprise Admin 可以访问企业下的所有组织
        for (Business.Organization.Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            
            // Assume we look for BoardingServiceOrganization or PetCareOrganization 假设我们查找 Boarding Service 组织或 Pet Care 组织
            if (org instanceof Business.PetBoardingOrganization.BoardingServiceOrganization || 
                org instanceof Business.PetBoardingOrganization.PetCareOrganization) {
                targetOrganization = org;
                break;
            }
        }
    }

    // 2. Create and switch to OperationIndicatorsReportJPanel 创建并切换到 OperationIndicatorsReportJPanel
    OperationIndicatorsReportJPanel panel = new OperationIndicatorsReportJPanel(
        userProcessContainer, 
        targetOrganization,
        enterprise,       
        system           
    );
    
    // 3: Add the panel to container and name it
    userProcessContainer.add("OperationIndicatorsReportJPanel", panel);
    
    // 4: Switch to the new panel
    ((CardLayout) userProcessContainer.getLayout()).next(userProcessContainer);  
    }//GEN-LAST:event_btnPetBoardingReportActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPetBoardingReport;
    private javax.swing.JButton btnPetClinicReport;
    private javax.swing.JButton btnPetInsuranceReport;
    // End of variables declaration//GEN-END:variables
}
