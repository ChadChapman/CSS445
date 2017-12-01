/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

/**
 *
 * @author Chad Chapman, Keegan Kell, hui ting cai, Hanan J Abdo 
 */
public class AdminPanel extends java.awt.Frame {

    /**
     * Creates new form AdminPanel
     */
    public AdminPanel() {
        initComponents();
        this.listStudents.add("Student 1");
        this.listOrganisations.add("Org 1");
        listOrgInternships.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        listStudents = new java.awt.List();
        label2 = new java.awt.Label();
        listOrganisations = new java.awt.List();
        label3 = new java.awt.Label();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        listOrgInternships = new java.awt.List();
        lblOrgName = new java.awt.Label();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        label1.setText("Admin Portal");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 753, -1));
        add(listStudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 210, 430));

        label2.setText("Students");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, -1));
        add(listOrganisations, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 220, 430));

        label3.setText("Organisations");
        add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        button1.setLabel("Add Organisation");
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button1MouseClicked(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, -1, -1));

        button2.setLabel("Add Student");
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });
        add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));
        add(listOrgInternships, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 250, 430));

        lblOrgName.setAlignment(java.awt.Label.CENTER);
        lblOrgName.setText("Org 1 Internships");
        add(lblOrgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 250, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        this.dispose();
        try {
            LoginPanel frame = new LoginPanel();
            frame.setVisible(true);
            frame.setTitle("Login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exitForm

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        // TODO Add Student Code
        try {
            AddStudentForm panel = new AddStudentForm();
            panel.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_button2MouseClicked

    private void button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseClicked
        // TODO Add organisation Code
        try {
            AddOrgForm panel = new AddOrgForm();
            panel.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_button1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPanel().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label lblOrgName;
    private java.awt.List listOrgInternships;
    private java.awt.List listOrganisations;
    private java.awt.List listStudents;
    // End of variables declaration//GEN-END:variables
}