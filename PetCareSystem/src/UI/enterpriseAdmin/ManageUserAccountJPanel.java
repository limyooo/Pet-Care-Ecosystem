package UI.enterpriseAdmin;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Petsystem;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eve Dou
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Petsystem system;

    //  Maps to convert combo box display strings back to real objects
    private Map<String, Organization> orgMap = new HashMap<>();
    private Map<String, Employee> empMap = new HashMap<>();
    private Map<String, Role> roleMap = new HashMap<>();

    
    public ManageUserAccountJPanel(JPanel userProcessContainer,
                                   Enterprise enterprise,
                                   Petsystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;

        // 填充组织下拉框并填充用户表格
        // Populate organization combo box and user table
        populateOrganizationComboBox();
        populateUserTable();

        // 当组织选择变化时，刷新员工与角色下拉框
        // When selected organization changes, refresh employee & role combo boxes
        cbxOrg.addActionListener(e -> onOrganizationChanged());
    }

    
    public ManageUserAccountJPanel() {
        initComponents();
    }
    
    // Populate organization combo box: read from enterprise's organization directory 填充组织下拉框
    private void populateOrganizationComboBox() {
        if (enterprise == null) return;

        cbxOrg.removeAllItems();
        orgMap.clear();

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            String name = org.getName();
            cbxOrg.addItem(name);
            orgMap.put(name, org);
        }

        // When default selection is set, refresh employees and roles accordingly 默认选中第一个组织时，顺便填充员工和角色
        onOrganizationChanged();
    }

    // Handle organization change: refresh employee and role combo boxes 当前组织改变时，刷新员工 & 角色下拉框
    private void onOrganizationChanged() {
        String orgName = (String) cbxOrg.getSelectedItem();
        if (orgName == null) return;

        Organization org = orgMap.get(orgName);
        populateEmployeeComboBox(org);
        populateRoleComboBox(org);
    }

    // Populate employee combo box: list employees within the organization and store mapping 填充员工下拉框
    private void populateEmployeeComboBox(Organization org) {
        cbxEmployee.removeAllItems();
        empMap.clear();
        if (org == null) return;

        for (Employee emp : org.getEmployeeDirectory().getEmployeeList()) {
            String name = emp.getName();
            cbxEmployee.addItem(name);
            empMap.put(name, emp);
        }
    }

    // Populate role combo box: list supported roles of the organization and store mapping 填充角色下拉框
    private void populateRoleComboBox(Organization org) {
        cbxRole.removeAllItems();
        roleMap.clear();
        if (org == null) return;

        for (Role r : org.getSupportedRole()) {
            String name = r.toString();
            cbxRole.addItem(name);
            roleMap.put(name, r);
        }
    }

    // Populate user table: list user accounts (username + role) across enterprise organizations
    private void populateUserTable() {
        DefaultTableModel model = (DefaultTableModel) tblUsersList.getModel();
        model.setRowCount(0);

        if (enterprise == null) return;

        for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                Object[] row = new Object[2];
                row[0] = ua.getUsername();
                row[1] = ua.getRole();
                model.addRow(row);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblManageUsers = new javax.swing.JLabel();
        lblUsersList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsersList = new javax.swing.JTable();
        lblOrg = new javax.swing.JLabel();
        lblEmployee = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        cbxOrg = new javax.swing.JComboBox<>();
        cbxEmployee = new javax.swing.JComboBox<>();
        cbxRole = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblManageUsers.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblManageUsers.setText("Manage Users   ");

        lblUsersList.setText("Users List:");

        tblUsersList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Name", "Role"
            }
        ));
        jScrollPane1.setViewportView(tblUsersList);

        lblOrg.setText("Organization: ");

        lblEmployee.setText("Employee:  ");

        lblRole.setText("Role:   ");

        lblUserName.setText("User Name: ");

        lblPassword.setText("Password:");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        cbxOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrgActionPerformed(evt);
            }
        });

        cbxEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText(" New User:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbxRole, 0, 122, Short.MAX_VALUE)
                                            .addComponent(cbxEmployee, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbxOrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblUserName)
                                            .addComponent(lblPassword))
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btnCreate))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUsersList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(120, 120, 120)
                        .addComponent(lblManageUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblManageUsers))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsersList)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrg)
                            .addComponent(cbxOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmployee))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserName)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(btnCreate)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    if (userProcessContainer == null) {
            return;
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
     String username = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "User name and password cannot be empty.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String orgName = (String) cbxOrg.getSelectedItem();
        String empName = (String) cbxEmployee.getSelectedItem();
        String roleName = (String) cbxRole.getSelectedItem();

        if (orgName == null || empName == null || roleName == null) {
            JOptionPane.showMessageDialog(this,
                    "Please select organization, employee and role.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Organization org = orgMap.get(orgName);
        Employee emp = empMap.get(empName);
        Role role = roleMap.get(roleName);

        if (org == null || emp == null || role == null) {
            JOptionPane.showMessageDialog(this,
                    "Internal mapping error. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        UserAccount ua = org.getUserAccountDirectory()
                .createUserAccount(username, password, emp, role);

        if (ua == null) {
            JOptionPane.showMessageDialog(this,
                    "Failed to create user account.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "User account created successfully.",
                "Info",
                JOptionPane.INFORMATION_MESSAGE);

        txtUserName.setText("");
        txtPassword.setText("");

        populateUserTable();                                   

    }//GEN-LAST:event_btnCreateActionPerformed

    private void cbxOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<String> cbxEmployee;
    private javax.swing.JComboBox<String> cbxOrg;
    private javax.swing.JComboBox<String> cbxRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JLabel lblManageUsers;
    private javax.swing.JLabel lblOrg;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUsersList;
    private javax.swing.JTable tblUsersList;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
