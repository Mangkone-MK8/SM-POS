/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPOS;

import java.awt.print.PrinterException;
import static java.time.LocalDateTime.now;
import javax.swing.table.TableModel;

/**
 *
 * @author IT-Laotelecom
 */
public class print extends javax.swing.JFrame {

    /**
     * Creates new form print
     */
    public print() {
        initComponents();
    }
    String total;
    String receive;
    String change;
    public print(String total,String receive,String change,TableModel TB_model) throws PrinterException {
        initComponents();
        this.total=total;
        this.receive=receive;
        this.change=change;
        
        txtprint.setText(txtprint.getText()+"\tSM-ມິນິມາກ\t\n\n");
        txtprint.setText(txtprint.getText()+now()+"\n\n");
        txtprint.setText(txtprint.getText()+"===============================\n");
        txtprint.setText(txtprint.getText()+"ຊື່ສິນຄ້າ\t"+"ຈຳນວນ\t"+"ລາຄາ\t");
        
        for(int i=0;i<TB_model.getRowCount();i++){
            String product_name = TB_model.getValueAt(i, 2).toString();
            String price= TB_model.getValueAt(i,3).toString();
            String quantity=TB_model.getValueAt(i,4).toString();
           
           txtprint.setText(txtprint.getText()+"\n");
           txtprint.setText(txtprint.getText()+product_name+"\t"+quantity+"\t"+price+" kip");
        }
        txtprint.setText(txtprint.getText()+"\n\nລວມ:\t"+total+" kip");
        txtprint.setText(txtprint.getText()+"\nຮັບມາ:\t"+receive+" kip");
        txtprint.setText(txtprint.getText()+"\nເງິນທອນ:\t"+change+" kip");
        txtprint.setText(txtprint.getText()+"\n================================\n");
        txtprint.setText(txtprint.getText()+"\t   ຂໍຂອບໃຈ");
        txtprint.print();
       
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtprint.setColumns(20);
        txtprint.setFont(new java.awt.Font("Phetsarath OT", 0, 12)); // NOI18N
        txtprint.setRows(5);
        jScrollPane1.setViewportView(txtprint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtprint;
    // End of variables declaration//GEN-END:variables
}
