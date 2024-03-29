/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library_management_system;

import DatabaseOperations.StudentDboperation;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import model.Student;

/**
 *
 * @author DELL
 */
public class NocCertificate extends javax.swing.JFrame {
String id="";
    /**
     * Creates new form NocCertificate
     */
    public NocCertificate() {
       
        initComponents();
    }
    public void getReg(String reg){
     this.id=reg;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(240, 130));
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NOC Certificate");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 37, 363, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 100, 697, 434));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/close.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 57, 50));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 19, 31, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(808, 532, 132, 45));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        ArrayList<Student> list = StudentDboperation.getRecordsOnCreteria(id);
        Iterator<Student> itr = list.iterator();
        LocalDate dt= LocalDate.now();
        String date=dt.toString();
        Collections.reverse(list);
        
        
        if (itr.hasNext()) {
          
            Student st = itr.next();
            String reg=st.getRegistration();
            String name=st.getName();
           
            
            jTextArea1.setText("*********************************************************************************************************\n\n\n");
          jTextArea1.setText(jTextArea1.getText() +"*************************************     No Objection Certificate    *********************************\n");
              jTextArea1.setText(jTextArea1.getText() +"\n                                                               "+date+"    \n\n");

          jTextArea1.setText(jTextArea1.getText()+"           This is certify that "+ name.toUpperCase() +" having registration number "+ reg+" \n\n          of BCA department has returned all the books taken form library.\n");
          jTextArea1.setText(jTextArea1.getText()+"\n          He/She owns no due to the library.\n\n\n\n");
          jTextArea1.setText(jTextArea1.getText()+"\n\n                                                                                          Signature with SEAL");
          jTextArea1.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "No such student is present ");
        }  
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     try{
         jTextArea1.print();
     }catch(Exception e){
         JOptionPane.showMessageDialog(this,e.toString());
     }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NocCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NocCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NocCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NocCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NocCertificate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
