/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Rashmina Senadheera
 */
public class DefaulterList extends javax.swing.JFrame {

    /**
     * Creates new form DefaulterList
     */
    DefaultTableModel model;
    Color headerFontColor = new Color(102,102,255);
    
    public DefaulterList() {
        initComponents();
        setDefaulterList();
    }
    public void tableHeader(){
        JTableHeader theader = tbl_defaulterList.getTableHeader();
        theader.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
        theader.setForeground(headerFontColor);
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.setViewportBorder(null);
    }
    
    public void setDefaulterList(){
        long l = System.currentTimeMillis();
        java.sql.Date todayDate = new java.sql.Date(l);
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from issue_book_details where due_date<?and status=?");
            pst.setDate(1,todayDate);
            pst.setString(2,"Pending");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String StudentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                Object[] obj = {id,bookName,StudentName,issueDate,dueDate,status};
                model = (DefaultTableModel)tbl_defaulterList.getModel();
                model.addRow(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableHeader();
    
    
    
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_defaulterList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/warning.png"))); // NOI18N
        jLabel2.setText(" Defaulter List");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 370, 80));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 480, 5));

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

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 140, 40));

        jPanel2.setBackground(new java.awt.Color(103, 103, 255));

        jLabel1.setBackground(new java.awt.Color(103, 103, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, 50, 50));

        jPanel4.setBackground(new java.awt.Color(255, 244, 233));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 244, 233));
        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(255, 244, 233));
        jScrollPane2.setFocusable(false);
        jScrollPane2.setOpaque(false);

        tbl_defaulterList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbl_defaulterList.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tbl_defaulterList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_defaulterList.setRowHeight(30);
        tbl_defaulterList.setSelectionBackground(new java.awt.Color(255, 51, 51));
        tbl_defaulterList.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_defaulterList);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 1092, 379));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1412, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 803, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(3, 3, 3)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefaulterList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DefaulterList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_defaulterList;
    // End of variables declaration//GEN-END:variables
}
