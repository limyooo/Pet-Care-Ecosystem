package UI.enterpriseAdmin;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Eve Dou
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private Map<String, Organization> orgMap = new HashMap<>();

    /**
     * Creates new form ManageEmployeeJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;

        lblManageEmployees.setText("Manage Employees - " + enterprise.getName());

        populateOrganizationComboBox();
        String orgName = (String) cbxSelectOrg.getSelectedItem();
        Organization org = orgMap.get(orgName);
        populateEmployeeTable(org);

    }

    private void populateOrganizationComboBox() {
    cbxSelectOrg.removeAllItems();
    orgMap.clear();

    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        String name = org.getName();
        cbxSelectOrg.addItem(name);   // 下拉框显示名字
        orgMap.put(name, org);        // 记住名字对应哪个 org 对象
    }
}


    // 填充表格：显示选中 organization 的所有员工
    private void populateEmployeeTable(Organization organization) {
        DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();
        model.setRowCount(0);

        if (organization == null) return;

        for (Employee e : organization.getEmployeeDirectory().getEmployeeList()) {
            Object[] row = new Object[2];
            row[0] = e.getId();   // 如果没有 getId()，可以改成 e.hashCode() 或者留空
            row[1] = e.getName();
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblManageEmployees = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblEmployeeList = new javax.swing.JLabel();
        lblSelectOrg = new javax.swing.JLabel();
        cbxSelectOrg = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        lblNewEmployee = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnCreateEmployee = new javax.swing.JButton();

        lblManageEmployees.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        lblManageEmployees.setText("Manage Employees ");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblEmployeeList.setText("Employee List:");

        lblSelectOrg.setText("Select Organization: ");

        cbxSelectOrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxSelectOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSelectOrgActionPerformed(evt);
            }
        });

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ));
        jScrollPane1.setViewportView(tblEmployee);

        lblNewEmployee.setText("New Employee: ");

        lblName.setText("Name: ");

        btnCreateEmployee.setText("Create Employee");
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(103, 103, 103)
                        .addComponent(lblManageEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSelectOrg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblEmployeeList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(cbxSelectOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(lblNewEmployee))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCreateEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(txtName))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblManageEmployees))
                .addGap(36, 36, 36)
                .addComponent(lblEmployeeList)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectOrg)
                    .addComponent(cbxSelectOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewEmployee)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnCreateEmployee)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed
    String orgName = (String) cbxSelectOrg.getSelectedItem();
    Organization org = orgMap.get(orgName);

    if (org == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select an organization.");
        return;
    }

    String name = txtName.getText().trim();
    if (name.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Please enter employee name.");
        return;
    }

    org.getEmployeeDirectory().createEmployee(name);
    txtName.setText("");
    populateEmployeeTable(org);

    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void cbxSelectOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSelectOrgActionPerformed
        String orgName = (String) cbxSelectOrg.getSelectedItem();
        Organization org = orgMap.get(orgName);
        populateEmployeeTable(org);
    }//GEN-LAST:event_cbxSelectOrgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JComboBox<String> cbxSelectOrg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblManageEmployees;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewEmployee;
    private javax.swing.JLabel lblSelectOrg;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
