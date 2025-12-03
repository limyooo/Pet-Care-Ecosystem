package UI.Insurance;

import Business.Enterprise.PetInsuranceEnterprise;
import Business.Organization.Organization;
import Business.Pet.InsurancePolicy;
import Business.Pet.Pet;
import Business.Pet.PetOwner;
import Business.PetInsuranceOrganization.InsurancePolicyOrganization;
import Business.Petsystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Component;
import UI.Insurance.AgentWorkAreaJPanel;

public class AgentManagePolicyJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private InsurancePolicyOrganization organization;
    private PetInsuranceEnterprise enterprise;
    private Petsystem system;

    private InsurancePolicy policy;   // 当前选中的那条保单

        // 设计器用
    public AgentManagePolicyJPanel() {
        initComponents();
    }

    // 运行时用：从 AgentWorkAreaJPanel 跳转过来会调用这个
    public AgentManagePolicyJPanel(JPanel userProcessContainer,
                                   UserAccount account,
                                   InsurancePolicyOrganization organization,
                                   PetInsuranceEnterprise enterprise,
                                   Petsystem system,
                                   InsurancePolicy policy) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        this.policy = policy;

        // 初始化下拉框选项
        initComboBoxes();
        
        // 用这条 policy 把界面上的字段填上
        populateForm();
    }
        // 给 Coverage / Status 设置一个固定的选项
    // 给 Coverage / Status 设置一个固定的选项
        private void initComboBoxes() {
            cbxCoverageType.removeAllItems();
            cbxCoverageType.addItem("Full Coverage");
            cbxCoverageType.addItem("Partial Coverage");

            cbxStatus.removeAllItems();
            cbxStatus.addItem("Active");
            cbxStatus.addItem("Expired");
            cbxStatus.addItem("Cancelled");
        }


    // 用 policy -> pet -> owner 的信息填充 UI
    private void populateForm() {
        if (policy == null) {
            return;
        }

        // Policy 基本信息
        txtPolicyID.setText(policy.getPolicyId());
        txtStart.setText(policy.getStartDate());
        txtExpiration.setText(policy.getEndDate());

        // coverageType
        String coverageType = policy.getCoverageType();
        if (coverageType != null) {
            cbxCoverageType.setSelectedItem(coverageType);
        }

        // Status：从 policy 里取，如果为 null 就用 Active
        String status = policy.getStatus();
        if (status != null && !status.isEmpty()) {
            cbxStatus.setSelectedItem(status);
        } else {
            cbxStatus.setSelectedItem("Active");
        }


        // Pet & Owner
        Pet pet = policy.getPet();
        if (pet != null) {
            txtPetName.setText(pet.getPetName());
            txtSpecies.setText(pet.getSpecies());
            txtAge.setText(String.valueOf(pet.getAge()));
            txtWeight.setText(String.valueOf(pet.getWeight()));

            PetOwner owner = pet.getPetOwner();
            if (owner != null) {
                txtOwnerName.setText(owner.getOwnerName());
                txtPhone.setText(owner.getPhone());
                txtEmail.setText(owner.getEmail());
                txtAddress.setText(owner.getAddress());
                txtEmergency.setText(owner.getEmergencyContact());
            }
        }

        // 默认一开始是“查看模式”，不能改
        setEditMode(false);
    }

    // 控制哪些字段是可编辑（只允许改保单相关）
    private void setEditMode(boolean editable) {
        cbxCoverageType.setEnabled(editable);
        txtStart.setEditable(editable);
        txtExpiration.setEditable(editable);
        cbxStatus.setEnabled(editable);

        // 宠物 & owner 信息只读
        txtPetName.setEditable(false);
        txtSpecies.setEditable(false);
        txtAge.setEditable(false);
        txtWeight.setEditable(false);
        txtOwnerName.setEditable(false);
        txtPhone.setEditable(false);
        txtEmail.setEditable(false);
        txtAddress.setEditable(false);
        txtEmergency.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        lblPetInfo = new javax.swing.JLabel();
        lblPetName = new javax.swing.JLabel();
        txtPetName = new javax.swing.JTextField();
        lblSpecies = new javax.swing.JLabel();
        txtSpecies = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
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
        lblExpirationDate = new javax.swing.JLabel();
        txtStart = new javax.swing.JTextField();
        lblPolicyInfo = new javax.swing.JLabel();
        lblPolicyID = new javax.swing.JLabel();
        txtPolicyID = new javax.swing.JTextField();
        lblCoverageType = new javax.swing.JLabel();
        lblStartDate = new javax.swing.JLabel();
        txtExpiration = new javax.swing.JTextField();
        lblStatus = new javax.swing.JLabel();
        cbxCoverageType = new javax.swing.JComboBox<>();
        cbxStatus = new javax.swing.JComboBox<>();
        btnModify = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 3, 24)); // NOI18N
        lblTitle.setText("Manage Policy Detail");

        lblWeight.setText("Weight:");

        txtWeight.setEditable(false);

        lblPetInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPetInfo.setText("Pet Info:");

        lblPetName.setText("PetName:");

        txtPetName.setEditable(false);

        lblSpecies.setText("Species:");

        txtSpecies.setEditable(false);
        txtSpecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSpeciesActionPerformed(evt);
            }
        });

        lblAge.setText("Age:");

        txtAge.setEditable(false);

        lblOwnerInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblOwnerInfo.setText("Owner Info:");

        txtOwnerName.setEditable(false);

        lblOwnerName.setText("OwnerName:");

        txtPhone.setEditable(false);

        lblPhone.setText("Phone:");

        lblEmail.setText("Email:");

        lblAddress.setText("Address:");

        lblEmergency.setText("Emergency:");

        txtEmail.setEditable(false);

        txtAddress.setEditable(false);

        txtEmergency.setEditable(false);

        lblExpirationDate.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblExpirationDate.setText("ExpirationDate:");

        txtStart.setEditable(false);
        txtStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStartActionPerformed(evt);
            }
        });

        lblPolicyInfo.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        lblPolicyInfo.setText("Policy Info:");

        lblPolicyID.setText("PolicyID:");

        txtPolicyID.setEditable(false);

        lblCoverageType.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblCoverageType.setText("CoverageType:");

        lblStartDate.setText("StartDate:");

        lblStatus.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        lblStatus.setText("Status:");

        cbxCoverageType.setEditable(true);
        cbxCoverageType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxStatus.setEditable(true);
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(120, 120, 120)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEmergency)
                                                .addGap(27, 27, 27)
                                                .addComponent(txtEmergency))
                                            .addComponent(lblAddress)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblPhone)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblOwnerName)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPetInfo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblSpecies, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPetName, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(lblAge)
                                            .addComponent(lblWeight))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblOwnerInfo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblPolicyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblCoverageType)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbxCoverageType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblExpirationDate)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26)
                                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPetInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPetName)
                            .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSpecies)
                            .addComponent(txtSpecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAge)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWeight)
                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblOwnerInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPolicyInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPolicyID)
                            .addComponent(txtPolicyID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCoverageType)
                            .addComponent(cbxCoverageType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStartDate)
                            .addComponent(txtStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblExpirationDate)
                            .addComponent(txtExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatus)
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmergency)
                            .addComponent(txtEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnModify)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSpeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpeciesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSpeciesActionPerformed

    private void txtStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStartActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    if (userProcessContainer == null) {
        return;
    }

    // 先移除当前面板
    userProcessContainer.remove(this);

    // 拿到容器里剩下的组件，最后一个就是我们要回去的 WorkArea
    Component[] comps = userProcessContainer.getComponents();
    Component c = comps[comps.length - 1];

    if (c instanceof AgentWorkAreaJPanel) {
        AgentWorkAreaJPanel panel = (AgentWorkAreaJPanel) c;
        panel.populatePolicyTable();   // ⭐ 刷新表格
    }

    CardLayout layout = (CardLayout) userProcessContainer.getLayout();
    layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
    // 允许编辑 coverage / start / expiration / status
        setEditMode(true);
    }//GEN-LAST:event_btnModifyActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
             if (policy == null) return;

    String coverage = (String) cbxCoverageType.getSelectedItem();
    String start = txtStart.getText().trim();
    String end = txtExpiration.getText().trim();
    String status = (String) cbxStatus.getSelectedItem();   // ⭐ 新增

    if (coverage == null || start.isEmpty() || end.isEmpty()) {
        JOptionPane.showMessageDialog(this,
                "Coverage, StartDate, ExpirationDate cannot be empty.",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    policy.setCoverageType(coverage);
    policy.setStartDate(start);
    policy.setEndDate(end);
    policy.setStatus(status);   // ⭐ 一定要有这行！

    JOptionPane.showMessageDialog(this,
            "Policy updated successfully.",
            "Info",
            JOptionPane.INFORMATION_MESSAGE);

    setEditMode(false);

            // 5️⃣ 刷新前一个列表面板
            if (userProcessContainer != null) {
                for (Component comp : userProcessContainer.getComponents()) {
                    if (comp instanceof AgentWorkAreaJPanel) {
                        AgentWorkAreaJPanel panel = (AgentWorkAreaJPanel) comp;
                        panel.populatePolicyTable();   // 重新加载表格
                    }
                }
            }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxCoverageType;
    private javax.swing.JComboBox<String> cbxStatus;
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
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmergency;
    private javax.swing.JTextField txtExpiration;
    private javax.swing.JTextField txtOwnerName;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPolicyID;
    private javax.swing.JTextField txtSpecies;
    private javax.swing.JTextField txtStart;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
