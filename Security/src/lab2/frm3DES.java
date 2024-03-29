/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.spec.KeySpec;
import javax.swing.JOptionPane;
import java.util.logging.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.DESedeKeySpec;

/**
 *
 * @author Admin
 */
public class frm3DES extends javax.swing.JFrame {

    /**
     * Creates new form frm3DES
     */
    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec  myKeySpec;
    private SecretKeyFactory mySecretKeyFactory;
    private Cipher cipher;
    byte[] keyAsBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    SecretKey key;
    public frm3DES() {
        initComponents();
    }
    
    public String encrypt(String unencryptedString){
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            //BASE64Encoder base64encoder = new BASE64Encoder();
            encryptedString = Base64.getEncoder().encodeToString(encryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedString;
    }
    
    public String decrypt(String encryptedString){
        String decryptedText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            //BASE64Decoder base64decoder = new BASE64Decoder();
            byte[] encryptedText = Base64.getDecoder().decode(encryptedString);
            byte[] plainText  = cipher.doFinal(encryptedText);
            String a = new String(plainText);
            System.out.println("Chuỗi plain text là: "+a);
            decryptedText = a;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtvanban = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtkhoa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGiaiMa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAllShow = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmahoa = new javax.swing.JTextArea();
        btnMaHoa = new javax.swing.JButton();
        btnMoFile = new javax.swing.JButton();
        btnGhiFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtvanban.setColumns(20);
        txtvanban.setRows(5);
        jScrollPane2.setViewportView(txtvanban);

        jLabel3.setText("Plain text");

        jLabel4.setText("Cipher text");

        jLabel1.setText("Input key");

        btnGiaiMa.setText("Giải mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });

        jLabel2.setText("DESEDE");

        btnAllShow.setText("All show");
        btnAllShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllShowActionPerformed(evt);
            }
        });

        txtmahoa.setColumns(20);
        txtmahoa.setRows(5);
        jScrollPane1.setViewportView(txtmahoa);

        btnMaHoa.setText("Mã hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });

        btnMoFile.setText("Hiển thị");
        btnMoFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoFileActionPerformed(evt);
            }
        });

        btnGhiFile.setText("Ghi file");
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGiaiMa)
                                .addGap(18, 18, 18)
                                .addComponent(btnAllShow))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnMaHoa)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnMoFile)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnGhiFile))
                                .addComponent(txtkhoa)
                                .addComponent(jScrollPane1)
                                .addComponent(jScrollPane2)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtkhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaHoa)
                    .addComponent(btnGhiFile)
                    .addComponent(btnMoFile))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaiMa)
                    .addComponent(btnAllShow))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        // TODO add your handling code here:
        try {
            myEncryptionKey = txtkhoa.getText();
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory =SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = mySecretKeyFactory.generateSecret(myKeySpec);
            System.out.println("Khóa mã hóa k: "+key);
            
            String plainText = txtmahoa.getText();
            String encrypted = decrypt(plainText);
            System.out.println("Encrypted Value: "+encrypted);
            txtvanban.setText(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnAllShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllShowActionPerformed
        // TODO add your handling code here:hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
    }//GEN-LAST:event_btnAllShowActionPerformed

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        // TODO add your handling code here:
        try {
            myEncryptionKey = txtkhoa.getText();
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
            myKeySpec = new DESedeKeySpec(keyAsBytes);
            mySecretKeyFactory =SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = mySecretKeyFactory.generateSecret(myKeySpec);
            System.out.println("Khóa mã hóa k: "+key);
            
            String plainText = txtvanban.getText();
            String encrypted = encrypt(plainText);
            System.out.println("Encrypted Value: "+encrypted);
            txtmahoa.setText(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMaHoaActionPerformed

    private void btnMoFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoFileActionPerformed
        // TODO add your handling code here:
        try {
            BufferedReader br = null;
            String fileName = "D:\\EnDes.txt";
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Đã mở file");
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();

            System.out.println("Du lieu la: "+sb);
            String chuoi = sb.toString();
            txtmahoa.setText(chuoi);
        } catch (IOException e) {
            Logger.getLogger(frm3DES.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btnMoFileActionPerformed

    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        // TODO add your handling code here:
        try {
            BufferedWriter bw = null;
            String fileName = "D:\\Des.txt";
            String s = txtvanban.getText();
            bw = new BufferedWriter(new FileWriter(fileName));

            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null, "Đã ghi file");
            txtmahoa.setText(s);
        } catch (IOException e) {
            Logger.getLogger(frm3DES.class.getName()).log(Level.SEVERE,null,e);
        }
    }//GEN-LAST:event_btnGhiFileActionPerformed

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
            java.util.logging.Logger.getLogger(frm3DES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm3DES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm3DES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm3DES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm3DES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllShow;
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnMoFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtkhoa;
    private javax.swing.JTextArea txtmahoa;
    private javax.swing.JTextArea txtvanban;
    // End of variables declaration//GEN-END:variables
}
