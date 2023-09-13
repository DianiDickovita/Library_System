
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

//import static jFrame.DBConnection.con;
import JFrame.DBConnection;
import JFrame.HomePage;
import JFrame.HomePageLibrarian;
import JFrame.logInID;
import java.awt.Color;
import java.awt.Font;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.*;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Asus
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String studentName,course,branch;
    int studentId;
    DefaultTableModel model;
    Color headerFontColor = new Color(102,102,255);
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    public void tableHeader(){
        JTableHeader theader = tbl_studentDetails.getTableHeader();
        theader.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
        theader.setForeground(headerFontColor);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setViewportBorder(null);
    }
    //to set the book details into the table
    public void setStudentDetailsToTable(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()){
                int StudentId = rs.getInt("student_id");
                String StudentName = rs.getString("student_name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {StudentId,StudentName,course,branch};
                model =(DefaultTableModel) tbl_studentDetails.getModel();
                model.addRow(obj);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableHeader();
    }
    
    //to add student to student_details table
    public boolean addStudent(){
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_studentId1.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
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
    public boolean updateStudent(){
        boolean isUpdaded = false;
        studentId = Integer.parseInt(txt_studentId1.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set student_name = ?,course = ?,branch = ? where student_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
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
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId = Integer.parseInt(txt_studentId1.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            
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
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
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

        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_branch = new javax.swing.JComboBox<>();
        combo_CourseName = new javax.swing.JComboBox<>();
        txt_studentId1 = new javax.swing.JTextField();
        txt_studentName = new javax.swing.JTextField();
        btn_add = new rojerusan.RSMaterialButtonRectangle();
        btn_update = new rojerusan.RSMaterialButtonRectangle();
        btn_delete = new rojerusan.RSMaterialButtonRectangle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group.png"))); // NOI18N
        jLabel6.setText(" Manage Students");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 380, 80));

        jPanel6.setBackground(new java.awt.Color(103, 103, 255));

        jLabel1.setBackground(new java.awt.Color(103, 103, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, -1, -1));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jLabel11.setText(" Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 180));

        jPanel3.setBackground(new java.awt.Color(255, 244, 233));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 244, 233));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 244, 233));

        tbl_studentDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setGridColor(new java.awt.Color(0, 204, 255));
        tbl_studentDetails.setRowHeight(30);
        tbl_studentDetails.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tbl_studentDetails.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 888, 215));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 990, 803));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel2.setText("Select Branch");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setText("Enter Student Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setText("Enter Student Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel5.setText("Select Course ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        combo_branch.setBackground(new java.awt.Color(255, 255, 153));
        combo_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IS", "CS" }));
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 280, 40));

        combo_CourseName.setBackground(new java.awt.Color(255, 255, 153));
        combo_CourseName.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        jPanel1.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 280, 40));

        txt_studentId1.setBackground(new java.awt.Color(255, 255, 153));
        txt_studentId1.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        txt_studentId1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId1ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 280, 40));

        txt_studentName.setBackground(new java.awt.Color(255, 255, 153));
        txt_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 16)); // NOI18N
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 280, 40));

        btn_add.setBackground(new java.awt.Color(102, 102, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 110, 60));

        btn_update.setBackground(new java.awt.Color(102, 102, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 110, 60));

        btn_delete.setBackground(new java.awt.Color(102, 102, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 110, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 420, 670));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId1.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        int uId = Integer.parseInt(logInID.userId);
        
        try {
            Connection con = DBConnection.getConnection();
            
            PreparedStatement pst = con.prepareStatement("select * from users where id=?");
            pst.setInt(1, uId);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
            HomePage home = new HomePage();
            home.setVisible(true);
            this.dispose();
            
            
            }
            else{
            HomePageLibrarian homeLib = new HomePageLibrarian();
            homeLib.setVisible(true);
            this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (updateStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Updated");
            clearTable();
            setStudentDetailsToTable();
            txt_studentId1.setText("");
            txt_studentName.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "Student Updation failed");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (addStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Added");
            clearTable();
            setStudentDetailsToTable();
            txt_studentId1.setText("");
            txt_studentName.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Student Addition failed");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if (deleteStudent() == true) {
            JOptionPane.showMessageDialog(this, "Student Deleted");
            clearTable();
            setStudentDetailsToTable();
            txt_studentId1.setText("");
            txt_studentName.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "Student Deletion failed");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId1ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_add;
    private rojerusan.RSMaterialButtonRectangle btn_delete;
    private rojerusan.RSMaterialButtonRectangle btn_update;
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_studentDetails;
    private javax.swing.JTextField txt_studentId1;
    private javax.swing.JTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
