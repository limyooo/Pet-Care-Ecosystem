package UI.enterpriseAdmin;

import Business.Enterprise.Enterprise;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class EnterpriseAdminWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Petsystem system;
    private UserAccount account;

    
    public EnterpriseAdminWorkAreaJPanel(JPanel userProcessContainer,
                                         UserAccount account,
                                         Enterprise enterprise,
                                         Petsystem system) {
        initComponents(); 

        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.account = account;

        lblWelcome.setText("Welcome, " + account.getUsername() + "!");

        txtEnterprise.setText(enterprise.getName());
        txtEnterprise.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseJPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTitle = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        txtEnterprise = new javax.swing.JTextField();
        btnManageOrg = new javax.swing.JButton();
        btnManageEmployees = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        btnViewReports = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        lblWelcome.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblWelcome.setText("Welcome, Enterprise Admin! ");

        btnLogOut.setText("Log Out ");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        lblTitle.setText("Enterprise Admin Work Area");

        lblEnterprise.setText("Enterprise:");

        txtEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnterpriseActionPerformed(evt);
            }
        });

        btnManageOrg.setText("Manage Organizations");
        btnManageOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrgActionPerformed(evt);
            }
        });

        btnManageEmployees.setText("Manage Employees");
        btnManageEmployees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmployeesActionPerformed(evt);
            }
        });

        btnManageUsers.setText("Manage Users");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        btnViewReports.setText("View Reports");
        btnViewReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enterpriseJPanelLayout = new javax.swing.GroupLayout(enterpriseJPanel);
        enterpriseJPanel.setLayout(enterpriseJPanelLayout);
        enterpriseJPanelLayout.setHorizontalGroup(
            enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterpriseJPanelLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterpriseJPanelLayout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addGap(78, 78, 78)
                        .addComponent(btnLogOut)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterpriseJPanelLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
                    .addGroup(enterpriseJPanelLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnManageOrg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(enterpriseJPanelLayout.createSequentialGroup()
                                    .addComponent(lblEnterprise)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnManageEmployees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnManageUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnViewReports, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE))
        );
        enterpriseJPanelLayout.setVerticalGroup(
            enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterpriseJPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut))
                .addGap(42, 42, 42)
                .addComponent(lblTitle)
                .addGap(39, 39, 39)
                .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnterprise)
                    .addComponent(txtEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnManageOrg)
                .addGap(42, 42, 42)
                .addComponent(btnManageEmployees)
                .addGap(36, 36, 36)
                .addComponent(btnManageUsers)
                .addGap(41, 41, 41)
                .addComponent(btnViewReports)
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(enterpriseJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enterpriseJPanelLayout.createSequentialGroup()
                    .addContainerGap(65, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(425, Short.MAX_VALUE)))
        );

        add(enterpriseJPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed

        java.awt.Component comp = this;

    // Traverse up the component tree until MainJFrame is found 向上遍历组件树，直到找到 MainJFrame
    while (comp != null && !(comp instanceof UI.admin.MainJFrame)) {
        comp = comp.getParent();
    }

    if (comp instanceof UI.admin.MainJFrame) {
        // Invoke the public triggerLogout() method on MainJFrame 调用新的公共代理方法
        ((UI.admin.MainJFrame) comp).triggerLogout(); 
    } else {
        // If MainJFrame not found, fallback: clear the container and refresh UI 找不到 MainJFrame，执行后备方案
        if (userProcessContainer != null) {
            userProcessContainer.removeAll();
            userProcessContainer.revalidate();
            userProcessContainer.repaint();
        }
    }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void txtEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnterpriseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnterpriseActionPerformed

    private void btnManageOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrgActionPerformed
    ManageOrganizationJPanel panel =
            new ManageOrganizationJPanel(userProcessContainer, enterprise);
    userProcessContainer.add("ManageOrganizationJPanel", panel);
    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageOrgActionPerformed

    private void btnManageEmployeesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmployeesActionPerformed
    ManageEmployeeJPanel panel = new ManageEmployeeJPanel(userProcessContainer, enterprise);

    userProcessContainer.add("ManageEmployeeJPanel", panel);
    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEmployeesActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
    ManageUserAccountJPanel panel =
        new ManageUserAccountJPanel(userProcessContainer, enterprise, system);
    userProcessContainer.add("ManageUserAccountJPanel", panel);
    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnViewReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportsActionPerformed
        // TODO add your handling code here:
        ViewReportsJPanel panel = new ViewReportsJPanel(userProcessContainer, enterprise, system);

        userProcessContainer.add("ViewReportsJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewReportsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManageEmployees;
    private javax.swing.JButton btnManageOrg;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton btnViewReports;
    private javax.swing.JPanel enterpriseJPanel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTextField txtEnterprise;
    // End of variables declaration//GEN-END:variables
}
