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
public class AddStudentForm extends java.awt.Frame {

    /**
     * Creates new form AddStudentForm
     */
    public AddStudentForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        textFieldStudentName = new java.awt.TextField();
        textFieldStudentID = new java.awt.TextField();
        button1 = new java.awt.Button();

        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(400, 200));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setText("Student Name    :");
        add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 20));

        label2.setText("Student ID           :");
        add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 100, 20));
        add(textFieldStudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 230, -1));
        add(textFieldStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 230, -1));

        button1.setLabel("Add Student");
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        this.dispose();
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudentForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.TextField textFieldStudentID;
    private java.awt.TextField textFieldStudentName;
    // End of variables declaration//GEN-END:variables
}
