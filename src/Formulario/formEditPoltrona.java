/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import DAO.ClassesDB.Status;
import DAO.ClassesDB.VooPoltrona;
import Utilidades.Facade;
import Utilidades.FormUtils;
import Utilidades.VooPoltronaTableModel;
import java.awt.Image;


/**
 *
 * @author diego.soares
 */
public class formEditPoltrona extends javax.swing.JFrame {
    private FormUtils formUtils;
    private VooPoltrona poltrona;
    private VooPoltronaTableModel tblModel;
    private Object[] objectArray;
    /**
     * Creates new form formEditPoltrona
     * @param obj
     * @param indiceLinha
     */
    public formEditPoltrona(Object obj, int indiceLinha) {
        initComponents();
        formUtils = new FormUtils();
        formUtils.carregaComboBoxStatus(cmbStatus);
        tblModel = (VooPoltronaTableModel) obj;
        poltrona = tblModel.getVooPoltrona(indiceLinha);
        objectArray = new Object[4];
        objectArray[0] = lbStatusPoltrona;
        objectArray[1] = lbNumPoltrona;
        objectArray[2] = cmbStatus;
        objectArray[3] = poltrona;
        formUtils.montaFormEditarPoltrona(objectArray);
    }

    private formEditPoltrona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbNumPoltrona = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbStatusPoltrona = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAcao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        lbNumPoltrona.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbNumPoltrona.setForeground(new java.awt.Color(255, 255, 255));
        lbNumPoltrona.setText("10");
        jPanel1.add(lbNumPoltrona);
        lbNumPoltrona.setBounds(195, 20, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Formulario/images/chair.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 250, 250);

        jLabel3.setText("Status:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(270, 10, 60, 15);

        lbStatusPoltrona.setText("jLabel4");
        jPanel1.add(lbStatusPoltrona);
        lbStatusPoltrona.setBounds(330, 10, 200, 15);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cmbStatus);
        cmbStatus.setBounds(270, 60, 220, 24);

        jLabel5.setText("Status da Poltrona:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(270, 40, 140, 15);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(280, 220, 93, 25);

        btnAcao.setText("Gravar");
        btnAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcaoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAcao);
        btnAcao.setBounds(400, 220, 90, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcaoActionPerformed
        poltrona.setStatus(new Status((cmbStatus.getSelectedIndex()+1)));
        Facade.getInstance().updateDataDB("update", poltrona);
        this.dispose();
    }//GEN-LAST:event_btnAcaoActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formEditPoltrona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new formEditPoltrona().setVisible(true);
                
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcao;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNumPoltrona;
    private javax.swing.JLabel lbStatusPoltrona;
    // End of variables declaration//GEN-END:variables
}

