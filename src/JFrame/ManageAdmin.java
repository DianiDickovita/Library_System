
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

//import static jFrame.DBConnection.con;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Diani
 */
public class ManageAdmin extends javax.swing.JFrame {

    
    //String AdminName,Apassword,Aemail,Acontact;
    //int AdminId;
    DefaultTableModel model;
    
    public ManageAdmin() {
        initComponents();
        setAdminDetailsToTable();
        
    }
    
    //to set the book details into the table
    public void setAdminDetailsToTable(){

        
        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            
            while(rs.next()){
                String AdminId = rs.getString("id");
                String AdminName = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String contact = rs.getString("contact");
                
                Object[] obj = {AdminId,AdminName,password,email,contact};
                model =(DefaultTableModel) tbl_adminDetails.getModel();
                model.addRow(obj);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //to add student to student_details table
    public boolean addAdmin(){
        boolean isAdded = false;
        int AdminId = Integer.parseInt(txt_adminId.getText());
        String AdminName = txt_adminname.getText();
        String password = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into users values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, AdminId);
            pst.setString(2, AdminName);
            pst.setString(3, password);
            pst.setString(4, email);
            pst.setString(5, contact);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;
            }else {
                isAdded = false;
            }    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    //to update student details
    public boolean updateAdmin(){
        boolean isUpdaded = false;
        int AdminId = Integer.parseInt(txt_adminId.getText());
        String AdminName = txt_adminname.getText();
        String password = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update users set name = ?,password = ?,email = ?,contact = ?  where id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, AdminName);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setString(4, contact);
            pst.setInt(5, AdminId);
            
            int rowCount =  pst.executeUpdate();
            if (rowCount > 0) {
                isUpdaded = true;
            } else {
                isUpdaded = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isUpdaded;
    }
    
    //Method to delete student detail
    public boolean deleteAdmin(){
        boolean isDeleted = false;
        int AdminId = Integer.parseInt(txt_adminId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from users where id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, AdminId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isDeleted = true; 
            }else {
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isDeleted;
    }
    
    //Method to Clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_adminDetails.getModel();
        model.setRowCount(0); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_adminDetails = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_adminId = new javax.swing.JTextField();
        txt_adminname = new javax.swing.JTextField();
        txt_password = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_contact = new javax.swing.JTextField();
        btn_add = new rojerusan.RSMaterialButtonRectangle();
        btn_update = new rojerusan.RSMaterialButtonRectangle();
        btn_delete = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_adminDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admin Id", "Admin Name", "Password", "Email", "Contact"
            }
        ));
        tbl_adminDetails.setGridColor(new java.awt.Color(0, 204, 255));
        tbl_adminDetails.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tbl_adminDetails.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_adminDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_adminDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_adminDetails);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 1110, 640));

        jPanel6.setBackground(new java.awt.Color(255, 204, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jLabel10.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user (4).png"))); // NOI18N
        jLabel10.setText(" Manage Admin");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 380, 80));

        jPanel8.setBackground(new java.awt.Color(103, 103, 255));

        jLabel8.setBackground(new java.awt.Color(103, 103, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, -1, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 255));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jLabel11.setText(" Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 180));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel2.setText("Contact No");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setText("Enter Admin Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setText("Enter Admin Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel9.setText("E-mail");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        txt_adminId.setBackground(new java.awt.Color(255, 255, 153));
        txt_adminId.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txt_adminId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_adminId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_adminIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_adminId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 280, 30));

        txt_adminname.setBackground(new java.awt.Color(255, 255, 153));
        txt_adminname.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txt_adminname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_adminname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 280, 30));

        txt_password.setBackground(new java.awt.Color(255, 255, 153));
        txt_password.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 280, 30));

        txt_email.setBackground(new java.awt.Color(255, 255, 153));
        txt_email.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 280, 30));

        txt_contact.setBackground(new java.awt.Color(255, 255, 153));
        txt_contact.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 280, 30));

        btn_add.setBackground(new java.awt.Color(102, 102, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 110, 60));

        btn_update.setBackground(new java.awt.Color(102, 102, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 110, 60));

        btn_delete.setBackground(new java.awt.Color(102, 102, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 110, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 420, 620));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_adminDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_adminDetailsMouseClicked
        int rowNo = tbl_adminDetails.getSelectedRow();
        TableModel model = tbl_adminDetails.getModel();
        
        txt_adminId.setText(model.getValueAt(rowNo, 0).toString());
        txt_adminname.setText(model.getValueAt(rowNo, 1).toString());
        txt_password.setText(model.getValueAt(rowNo, 2).toString());
        txt_email.setText(model.getValueAt(rowNo, 3).toString());
        txt_contact.setText(model.getValueAt(rowNo, 4).toString());
    }//GEN-LAST:event_tbl_adminDetailsMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void txt_adminIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_adminIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_adminIdActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (addAdmin()== true) {
            JOptionPane.showMessageDialog(this, "Admin Added");
            clearTable();
            setAdminDetailsToTable();
            txt_adminId.setText("");
            txt_adminname.setText("");
            txt_password.setText("");
            txt_contact.setText("");
            txt_email.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Admin Addition failed");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (updateAdmin() == true) {
            JOptionPane.showMessageDialog(this, "Admin Updated");
            clearTable();
            setAdminDetailsToTable();
            txt_adminId.setText("");
            txt_adminname.setText("");
            txt_password.setText("");
            txt_contact.setText("");
            txt_email.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "Admin Updation failed");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if (deleteAdmin()== true) {
            JOptionPane.showMessageDialog(this, "Admin Deleted");
            clearTable();
            setAdminDetailsToTable();
            txt_adminId.setText("");
            txt_adminname.setText("");
            txt_password.setText("");
            txt_contact.setText("");
            txt_email.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "Admin Deletion failed");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_add;
    private rojerusan.RSMaterialButtonRectangle btn_delete;
    private rojerusan.RSMaterialButtonRectangle btn_update;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_adminDetails;
    private javax.swing.JTextField txt_adminId;
    private javax.swing.JTextField txt_adminname;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_password;
    // End of variables declaration//GEN-END:variables
}
