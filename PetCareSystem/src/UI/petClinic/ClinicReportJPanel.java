/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.petClinic;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.PetClinicOrganization.VetDoctorOrganization;
import Business.PetClinicOrganization.VetLabOrganization;
import Business.WorkQueue.HealthCareCheckRequest;
import Business.WorkQueue.InsuranceClaimRequest;
import Business.WorkQueue.LabTestRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author jingyangwang
 */
public class ClinicReportJPanel extends javax.swing.JPanel {
     
    private JPanel userProcessContainer;
    private Enterprise enterprise;  
    /**
     * Creates new form ClinicReportJPanel
     */
    public ClinicReportJPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;

        generateReport();
    }
    
    private int countDoctors() {
    int count = 0;
    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        if (org instanceof Business.PetClinicOrganization.VetDoctorOrganization) {
            count += org.getEmployeeDirectory().getEmployeeList().size();
        }
    }
    return count;
    }
    
    private int countLabAssistants() {
    int count = 0;
    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        if (org instanceof Business.PetClinicOrganization.VetLabOrganization) {
            count += org.getEmployeeDirectory().getEmployeeList().size();
        }
    }
    return count;
    }
    
    private int countPatients() {

    java.util.HashSet<String> petSet = new java.util.HashSet<>();

    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        if (org instanceof Business.PetClinicOrganization.FrontDeskOrganization) {
            for (Business.WorkQueue.WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                if (wr instanceof Business.WorkQueue.HealthCareCheckRequest) {
                    Business.WorkQueue.HealthCareCheckRequest req = 
                        (Business.WorkQueue.HealthCareCheckRequest) wr;

                    if (req.getPet() != null) {
                        petSet.add(req.getPet().getPetId());  // 用 petId 去重
                    }
                }
            }
        }
    }

    return petSet.size();
    }
    
    private int countHealthChecks() {
    int count = 0;

    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        if (org instanceof Business.PetClinicOrganization.FrontDeskOrganization) {
            for (Business.WorkQueue.WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                if (wr instanceof Business.WorkQueue.HealthCareCheckRequest) {
                    count++;
                }
            }
        }
    }
    return count;
    }
    
    private int countLabTests() {
    int count = 0;

    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        if (org instanceof Business.PetClinicOrganization.VetLabOrganization) {
            for (Business.WorkQueue.WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                if (wr instanceof Business.WorkQueue.LabTestRequest) {
                    count++;
                }
            }
        }
    }
    return count;
    }
    
    private int countInsuranceClaims() {
    int count = 0;

    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        if (org instanceof Business.PetInsuranceOrganization.InsuranceClaimOrganization) {
            for (Business.WorkQueue.WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
                if (wr instanceof Business.WorkQueue.InsuranceClaimRequest) {
                    count++;
                }
            }
        }
    }
    return count;
    }
    
    private void countTreatments() {
    int med = 0, fluids = 0, imaging = 0, surgery = 0, hosp = 0;

    for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
        for (WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof HealthCareCheckRequest) {
                HealthCareCheckRequest req = (HealthCareCheckRequest) wr;
                String t = req.getTreatmentNeeded();

                switch (t) {
                    case "Medication Only ":
                        med++; break;
                    case "IV Fluids & Supportive Care ":
                        fluids++; break;
                    case "Diagnostic Imaging (X-ray / Ultrasound) ":
                        imaging++; break;
                    case "Surgery ":
                        surgery++; break;
                    case "Hospitalization ":
                        hosp++; break;
                }
            }
        }
    }

    fieldMedication.setText(String.valueOf(med));
    fieldFluids.setText(String.valueOf(fluids));
    fieldImaging.setText(String.valueOf(imaging));
    fieldSurgery.setText(String.valueOf(surgery));
    fieldHospitalization.setText(String.valueOf(hosp));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblTotalPatients = new javax.swing.JLabel();
        lblTotalHealthChecks = new javax.swing.JLabel();
        lblTotalLabAssistant = new javax.swing.JLabel();
        fieldTotalPatients = new javax.swing.JTextField();
        fieldTotalHealthChecks = new javax.swing.JTextField();
        fieldTotalLabAssistants = new javax.swing.JTextField();
        lblTotalDoctors = new javax.swing.JLabel();
        lblTotalLabTests = new javax.swing.JLabel();
        lblTotalInsuranceClaims = new javax.swing.JLabel();
        fieldTotalDoctors = new javax.swing.JTextField();
        fieldTotalLabTests = new javax.swing.JTextField();
        fieldTotalInsuranceClaims = new javax.swing.JTextField();
        lblMedication = new javax.swing.JLabel();
        lblFluids = new javax.swing.JLabel();
        lblImaging = new javax.swing.JLabel();
        lblSurgery = new javax.swing.JLabel();
        lblHospitalization = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        fieldMedication = new javax.swing.JTextField();
        fieldFluids = new javax.swing.JTextField();
        fieldImaging = new javax.swing.JTextField();
        fieldSurgery = new javax.swing.JTextField();
        fieldHospitalization = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel1.setText("Clinic Report Summary");

        btnBack.setText("<<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTotalPatients.setText("Total Patients:");

        lblTotalHealthChecks.setText("Total Health Checks:");

        lblTotalLabAssistant.setText("Total Lab Assistants:");

        lblTotalDoctors.setText("Total Doctors:");

        lblTotalLabTests.setText("Total Lab Tests:");

        lblTotalInsuranceClaims.setText("Total Insurance Claims:");

        lblMedication.setText("Medication Only：");

        lblFluids.setText("IV Fluids & Supportive Care：");

        lblImaging.setText("Diagnostic Imaging (X-ray / Ultrasound) :");

        lblSurgery.setText("Surgery:");

        lblHospitalization.setText("Hospitalization:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(167, 167, 167)
                .addComponent(btnBack)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblTotalLabAssistant)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldTotalLabAssistants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTotalHealthChecks)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fieldTotalHealthChecks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblTotalPatients)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldTotalPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblTotalLabTests)
                                .addComponent(lblTotalDoctors)
                                .addComponent(lblTotalInsuranceClaims))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldTotalDoctors, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldTotalLabTests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldTotalInsuranceClaims, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(lblMedication))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHospitalization, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSurgery, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblImaging, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFluids, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldImaging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldHospitalization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fieldMedication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldFluids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fieldSurgery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalPatients)
                            .addComponent(fieldTotalPatients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalHealthChecks)
                            .addComponent(fieldTotalHealthChecks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalLabAssistant)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldTotalLabAssistants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTotalInsuranceClaims))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalDoctors)
                            .addComponent(fieldTotalDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalLabTests)
                            .addComponent(fieldTotalLabTests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(fieldTotalInsuranceClaims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMedication)
                    .addComponent(fieldMedication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFluids)
                    .addComponent(fieldFluids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImaging)
                    .addComponent(fieldImaging, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurgery)
                    .addComponent(fieldSurgery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHospitalization)
                    .addComponent(fieldHospitalization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JTextField fieldFluids;
    private javax.swing.JTextField fieldHospitalization;
    private javax.swing.JTextField fieldImaging;
    private javax.swing.JTextField fieldMedication;
    private javax.swing.JTextField fieldSurgery;
    private javax.swing.JTextField fieldTotalDoctors;
    private javax.swing.JTextField fieldTotalHealthChecks;
    private javax.swing.JTextField fieldTotalInsuranceClaims;
    private javax.swing.JTextField fieldTotalLabAssistants;
    private javax.swing.JTextField fieldTotalLabTests;
    private javax.swing.JTextField fieldTotalPatients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblFluids;
    private javax.swing.JLabel lblHospitalization;
    private javax.swing.JLabel lblImaging;
    private javax.swing.JLabel lblMedication;
    private javax.swing.JLabel lblSurgery;
    private javax.swing.JLabel lblTotalDoctors;
    private javax.swing.JLabel lblTotalHealthChecks;
    private javax.swing.JLabel lblTotalInsuranceClaims;
    private javax.swing.JLabel lblTotalLabAssistant;
    private javax.swing.JLabel lblTotalLabTests;
    private javax.swing.JLabel lblTotalPatients;
    // End of variables declaration//GEN-END:variables

    private void generateReport() {
        fieldTotalPatients.setText(String.valueOf(countPatients()));
        fieldTotalDoctors.setText(String.valueOf(countDoctors()));
        fieldTotalLabAssistants.setText(String.valueOf(countLabAssistants()));
        fieldTotalHealthChecks.setText(String.valueOf(countHealthChecks()));
        fieldTotalLabTests.setText(String.valueOf(countLabTests()));
        fieldTotalInsuranceClaims.setText(String.valueOf(countInsuranceClaims()));

        countTreatments();
    }
}
