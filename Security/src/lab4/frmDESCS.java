
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class frmDESCS extends javax.swing.JFrame {

    /**
     * Creates new form frmDESCS
     */
    public frmDESCS() {
        initComponents();
    }
//    public frmDESCS(int i) {
//        if(i==0)
//            lblform.setText("DESCS của Alice");
//        if(i==1)
//            lblform.setText("DESCS của Bob");
//        initComponents();
//    }
    private int mode;

    private static void doCopy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[4];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            os.write(bytes, 0, numBytes);
        }
        os.flush();
        os.close();
        is.close();
    }

    private static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }

    private static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }

    private static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");

        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblform = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtKey = new javax.swing.JTextField();
        btnMaHoa = new javax.swing.JButton();
        btnMoKhoaA = new javax.swing.JButton();
        btnMoKhoaB = new javax.swing.JButton();
        btnGhiFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlainText = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCipherText = new javax.swing.JTextArea();
        btnGiaiMa = new javax.swing.JButton();
        btnAllShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblform.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblform.setText("DESCS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Input Key:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Plaintext:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Ciphertext:");

        btnMaHoa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMaHoa.setText("Mã Hóa");
        btnMaHoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaHoaActionPerformed(evt);
            }
        });

        btnMoKhoaA.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMoKhoaA.setText("Mở Khóa A");
        btnMoKhoaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoKhoaAActionPerformed(evt);
            }
        });

        btnMoKhoaB.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMoKhoaB.setText("Mở Khóa B");
        btnMoKhoaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoKhoaBActionPerformed(evt);
            }
        });

        btnGhiFile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGhiFile.setText("Ghi File");
        btnGhiFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhiFileActionPerformed(evt);
            }
        });

        txtPlainText.setColumns(20);
        txtPlainText.setRows(5);
        jScrollPane1.setViewportView(txtPlainText);

        txtCipherText.setColumns(20);
        txtCipherText.setRows(5);
        jScrollPane2.setViewportView(txtCipherText);

        btnGiaiMa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnGiaiMa.setText("Giải Mã");
        btnGiaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaiMaActionPerformed(evt);
            }
        });

        btnAllShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAllShow.setText("All Show");
        btnAllShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(lblform))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnMaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGiaiMa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAllShow)
                                .addGap(99, 99, 99))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMoKhoaA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(btnMoKhoaB, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGhiFile, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblform)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoKhoaA, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoKhoaB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGhiFile, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGiaiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAllShow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoKhoaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoKhoaAActionPerformed
        try {
            BufferedReader br = null;
            String fileName = "C:\\KhoaABAlice.txt"; 
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();

            JOptionPane.showMessageDialog(null, "Đã mở file");
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();

            System.out.println("Du lieu la:" + " " + sb);
            String chuoi = sb.toString();
            txtKey.setText(chuoi);
        } catch (IOException ex) {
            Logger.getLogger(frmDESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMoKhoaAActionPerformed

    private void btnMoKhoaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoKhoaBActionPerformed
        try {
            BufferedReader br = null;
            String fileName = "C:\\KhoaABBob.txt"; 
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();

            JOptionPane.showMessageDialog(null, "Đã mở file");
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();

            System.out.println("Du lieu la:" + " " + sb);
            String chuoi = sb.toString();
            txtKey.setText(chuoi);
        } catch (IOException ex) {
            Logger.getLogger(frmDESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMoKhoaBActionPerformed

    private void btnGhiFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhiFileActionPerformed
        try {
            BufferedWriter bw = null;
            String fileName = "C:\\Des.txt";
            String s = txtPlainText.getText();
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null, "Đã ghi file");
            txtCipherText.setText(s);
        } catch (IOException ex) {
            Logger.getLogger(frmDESCS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGhiFileActionPerformed

    private void btnMaHoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaHoaActionPerformed
        try {
            String key = txtKey.getText();
            String fileDes = "C:\\Des.txt";
            FileInputStream fis = new FileInputStream(fileDes);
            String fileEnDes = "C:\\EnDes.txt";
            FileOutputStream fos = new FileOutputStream(fileEnDes);
            encrypt(key, fis, fos);
            JOptionPane.showMessageDialog(null, "Đã mã hóa văn bản");
           
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMaHoaActionPerformed

    private void btnGiaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaiMaActionPerformed
        FileInputStream fis2 = null;
        try {
            String key = txtKey.getText();
            String fileEnDes = "C:\\EnDes.txt";
            fis2 = new FileInputStream(fileEnDes);

            String fileDeDes = "C:\\DeDes.txt";
            FileOutputStream fos2 = new FileOutputStream(fileDeDes);
            decrypt(key, fis2, fos2);
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(fileDeDes));
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Đã giải mã");
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            System.out.println("Du lieu la:" + " " + sb);
            String chuoi = sb.toString();
            txtCipherText.setText(chuoi);
        } catch (Throwable ex) {
            Logger.getLogger(frmDESCS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis2.close();
            } catch (IOException ex) {
                Logger.getLogger(frmDESCS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGiaiMaActionPerformed

    private void btnAllShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllShowActionPerformed
        try {
            BufferedReader br = null;
            String fileDeDes = "C:\\DeDes.txt";
            br = new BufferedReader(new FileReader(fileDeDes));
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, " Da and file");
            char[] ca = new char[5];
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();

            String fileEnDes = "C:\\EnDes.txt";
            br = new BufferedReader(new FileReader(fileEnDes));
            StringBuffer sbl = new StringBuffer();
            char[] cal = new char[5];
            while (br.ready()) {
                int len = br.read(cal);
                sbl.append(cal, 0, len);
            }
            //xuat chuoi 
            System.out.println("Du Lieu la :" + " " + sb);
            String plaintext = sb.toString();
            String ciphertext = sbl.toString();
            txtPlainText.setText(plaintext);
            txtCipherText.setText(ciphertext);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_btnAllShowActionPerformed

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
            java.util.logging.Logger.getLogger(frmDESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDESCS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDESCS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllShow;
    private javax.swing.JButton btnGhiFile;
    private javax.swing.JButton btnGiaiMa;
    private javax.swing.JButton btnMaHoa;
    private javax.swing.JButton btnMoKhoaA;
    private javax.swing.JButton btnMoKhoaB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblform;
    private javax.swing.JTextArea txtCipherText;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtPlainText;
    // End of variables declaration//GEN-END:variables
}
