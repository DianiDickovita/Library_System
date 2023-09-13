
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

//import static jFrame.DBConnection.con;
import java.awt.Color;
import java.awt.Font;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
//import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class ManageCategory extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    
    String categoryName,status;
    int categoryId;
    DefaultTableModel model;
    Color headerFontColor = new Color(102,102,255);
    
    public ManageCategory() {
        initComponents();
        setCategoryDetailsToTable();
    }
    public void tableHeader(){
        JTableHeader theader = tbl_categoryDetails.getTableHeader();
        theader.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
        theader.setForeground(headerFontColor);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setViewportBorder(null);
    }
    
    //to set the category details into the table
    public void setCategoryDetailsToTable(){
        
        try{
            
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from category_details");
            
            while(rs.next()){
                String CategoryId = rs.getString("category_id");
                String CategoryName = rs.getString("name");
                
                
                
                Object[] obj = {CategoryId,CategoryName,status};
                model =(DefaultTableModel) tbl_categoryDetails.getModel();
                model.addRow(obj);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableHeader();
    }
    
    //to add category to category_details table
    public boolean addCategory(){
        boolean isAdded = false;
        categoryId = Integer.parseInt(txt_categoryId.getText());
        categoryName = txt_categoryName.getText();
        
        
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into category_details values(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, categoryId);
            pst.setString(2, categoryName);
            
            
            
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
    
    //to update category details
    public boolean updateCategory(){
        boolean isUpdaded = false;
        categoryId = Integer.parseInt(txt_categoryId.getText());
        categoryName = txt_categoryName.getText();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update category_details set name = ? where category_id =?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, categoryName);
            pst.setInt(2, categoryId);
            
            
            
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
    
    //Method to delete category detail
    public boolean deleteCategory(){
        boolean isDeleted = false;
        categoryId = Integer.parseInt(txt_categoryId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from category_details where category_id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, categoryId);
            
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
        DefaultTableModel model = (DefaultTableModel) tbl_categoryDetails.getModel();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_add = new rojerusan.RSMaterialButtonRectangle();
        btn_update = new rojerusan.RSMaterialButtonRectangle();
        btn_delete = new rojerusan.RSMaterialButtonRectangle();
        txt_categoryId = new javax.swing.JTextField();
        txt_categoryName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_categoryDetails = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setText("Category Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setText("Category Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        btn_add.setBackground(new java.awt.Color(102, 102, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 110, 60));

        btn_update.setBackground(new java.awt.Color(102, 102, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 110, 60));

        btn_delete.setBackground(new java.awt.Color(102, 102, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 110, 60));

        txt_categoryId.setBackground(new java.awt.Color(255, 255, 153));
        txt_categoryId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        txt_categoryId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_categoryId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 290, 40));

        txt_categoryName.setBackground(new java.awt.Color(255, 255, 153));
        txt_categoryName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        txt_categoryName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_categoryName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoryNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_categoryName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 290, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 450, 630));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 244, 233));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 244, 233));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 244, 233));

        tbl_categoryDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbl_categoryDetails.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_categoryDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Id", "Category Name"
            }
        ));
        tbl_categoryDetails.setGridColor(new java.awt.Color(0, 204, 255));
        tbl_categoryDetails.setRowHeight(30);
        tbl_categoryDetails.setSelectionBackground(new java.awt.Color(232, 57, 95));
        tbl_categoryDetails.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_categoryDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_categoryDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_categoryDetails);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 900, 215));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 620));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 960, 640));

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

        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/categories.png"))); // NOI18N
        jLabel7.setText(" Manage Category");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 380, 80));

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

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_categoryDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_categoryDetailsMouseClicked
        int rowNo = tbl_categoryDetails.getSelectedRow();
        TableModel model = tbl_categoryDetails.getModel();
        
        txt_categoryId.setText(model.getValueAt(rowNo, 0).toString());
        txt_categoryName.setText(model.getValueAt(rowNo, 1).toString());
        
        
    }//GEN-LAST:event_tbl_categoryDetailsMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

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
        ;
    }//GEN-LAST:event_jLabel11MouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (addCategory() == true) {
            JOptionPane.showMessageDialog(this, "Category Added");
            clearTable();
            setCategoryDetailsToTable();
            txt_categoryId.setText("");
            txt_categoryName.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Category Addition failed");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (updateCategory() == true) {
            JOptionPane.showMessageDialog(this, "Category Updated");
            clearTable();
            setCategoryDetailsToTable();
            txt_categoryId.setText("");
            txt_categoryName.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "Category Updation failed");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if (deleteCategory() == true) {
            JOptionPane.showMessageDialog(this, "Category Deleted");
            clearTable();
            setCategoryDetailsToTable();
            txt_categoryId.setText("");
            txt_categoryName.setText("");
        }else {
            JOptionPane.showMessageDialog(this, "Category Deletion failed");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_categoryNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryNameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ManageCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_add;
    private rojerusan.RSMaterialButtonRectangle btn_delete;
    private rojerusan.RSMaterialButtonRectangle btn_update;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_categoryDetails;
    private javax.swing.JTextField txt_categoryId;
    private javax.swing.JTextField txt_categoryName;
    // End of variables declaration//GEN-END:variables
}
