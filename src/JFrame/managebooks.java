/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

//import com.sun.jdi.connect.spi.Connection;
//import com.mysql.cj.protocol.Resultset;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
//import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;


/**
 *
 * @author HP
 */



public class managebooks extends javax.swing.JFrame {

    /**
     * Creates new form managebooks
     */
    String bookName,author,category;
    int bookId,quantity,category_id;
    DefaultTableModel model;
    Color headerFontColor = new Color(102,102,255);
    public managebooks() {
        initComponents();
        setBookDetailssToTable(); 
        //setbook details to table
        ComboCategory();
       
        
    }
    public void tableHeader(){
        JTableHeader theader = tbl_bookDetails.getTableHeader();
        theader.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
        theader.setForeground(headerFontColor);
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setViewportBorder(null);
    }
    
    public void setBookDetailssToTable(){
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery("select * from book_details ");
            
            while (rs.next()) {
                String bookId = rs.getString("book_id");
                String bookName=rs.getString("book_name");
                String author=rs.getString("author");
                String quantity=rs.getString("Quantity");
                int category = rs.getInt("category_id");
                
                
                Object[] obj={bookId,bookName,author,quantity,category};
                model=(DefaultTableModel) tbl_bookDetails.getModel();
                model.addRow(obj);
                
                
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        tableHeader();
    }
   
    public void ComboCategory(){
        String sql= "select * from category_details";
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                combo_category.addItem(rs.getString("category_id"));
 
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            
    
    }
    
    // add book_details
    public boolean addBook(){
        
        boolean isAdded=false;
        
        bookId= Integer.parseInt(txt_bookId.getText());
        bookName=txt_bookName.getText();
        author=txt_authorName.getText();
        quantity= Integer.parseInt( txt_quantity.getText());
        category = combo_category.getSelectedItem().toString();
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
            String sql="insert into book_details values(?,?,?,?,?)";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, bookName);
            pst.setString(3, author);
            pst.setInt(4, quantity);
            pst.setString(5, category);
           int rowCount= pst.executeUpdate();
            
            if (rowCount >0) {
                isAdded=true;
                
            }
            else{
            isAdded=false;}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
        
    }
    
    //update bookdetails
    
    public boolean updateBooks(){
        boolean isupdated=false;
        
        bookId= Integer.parseInt(txt_bookId.getText());
        bookName=txt_bookName.getText();
        author=txt_authorName.getText();
        quantity= Integer.parseInt( txt_quantity.getText());
        category = combo_category.getSelectedItem().toString();
        category_id = Integer.parseInt(category);
    
        try {
            Connection con= DBConnection.getConnection();
            String sql="update book_details set book_name=?,author=?,quantity=?,category_id=? where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            
            pst.setString(1, bookName);
            pst.setString(2, author);
            pst.setInt(3, quantity);
            pst.setInt(4, bookId);
            pst.setInt(5, category_id);
            
         int rowCount= pst.executeUpdate();
            if (rowCount>0) {
                isupdated=true;
                
            }else{
            isupdated=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isupdated;
    }//m to delete bookdetails
    
    public boolean deleteBook(){
        boolean isDeleted=false;
        bookId= Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con= DBConnection.getConnection();
            String sql="delete from book_details where book_id=?";
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount=pst.executeUpdate();
            
            if(rowCount>0){
            
                isDeleted=true;
            }
            else{
            isDeleted=false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
//cleartable
    public void clearTable(){
    DefaultTableModel model=(DefaultTableModel) tbl_bookDetails.getModel();
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

        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bookDetails = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JTextField();
        txt_bookName = new javax.swing.JTextField();
        txt_authorName = new javax.swing.JTextField();
        txt_quantity = new javax.swing.JTextField();
        btn_add = new rojerusan.RSMaterialButtonRectangle();
        btn_update = new rojerusan.RSMaterialButtonRectangle();
        btn_delete = new rojerusan.RSMaterialButtonRectangle();
        combo_category = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        jButton1.setBackground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setSize(new java.awt.Dimension(580, 830));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        tbl_bookDetails.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity", "Category"
            }
        ));
        tbl_bookDetails.setRequestFocusEnabled(false);
        tbl_bookDetails.setRowHeight(30);
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bookDetails);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 880, 270));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("Book Category");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/next (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, 250, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 1270, 650));

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/books.png"))); // NOI18N
        jLabel6.setText(" Manage Books");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 380, 80));

        jPanel7.setBackground(new java.awt.Color(103, 103, 255));

        jLabel8.setBackground(new java.awt.Color(103, 103, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 0, -1, -1));

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jLabel11.setText(" Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 180));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 2, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel2.setText("Enter Book Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 180, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setText("Enter Book Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel4.setText("Author Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 180, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel5.setText("Category");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 90, 30));

        txt_bookId.setBackground(new java.awt.Color(255, 255, 153));
        txt_bookId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 310, 30));

        txt_bookName.setBackground(new java.awt.Color(255, 255, 153));
        txt_bookName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 310, 30));

        txt_authorName.setBackground(new java.awt.Color(255, 255, 153));
        txt_authorName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_authorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authorNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 310, 30));

        txt_quantity.setBackground(new java.awt.Color(255, 255, 153));
        txt_quantity.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 70, 30));

        btn_add.setBackground(new java.awt.Color(102, 102, 255));
        btn_add.setText("ADD");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 110, 60));

        btn_update.setBackground(new java.awt.Color(102, 102, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 510, 110, 60));

        btn_delete.setBackground(new java.awt.Color(102, 102, 255));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 110, 60));

        jPanel1.add(combo_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 80, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 450, 630));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_authorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authorNameActionPerformed

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        // TODO add your handling code here:
        int rowNo = tbl_bookDetails.getSelectedRow();
        TableModel model = tbl_bookDetails.getModel();
        
        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_authorName.setText(model.getValueAt(rowNo, 2).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
        combo_category.setSelectedItem(model.getValueAt(rowNo, 4).toString());
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        if (addBook()==true) {
            JOptionPane.showMessageDialog(this, "Book Added");
            clearTable();
            setBookDetailssToTable();
            txt_bookId.setText("");
            txt_bookName.setText("");
            txt_authorName.setText("");
            txt_quantity.setText("");
            
        }
        else{
        JOptionPane.showMessageDialog(this, "Book Addition failed");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
       if (updateBooks()==true) {
            JOptionPane.showMessageDialog(this, "Book Updated");
            clearTable();
            setBookDetailssToTable();
            txt_bookId.setText("");
            txt_bookName.setText("");
            txt_authorName.setText("");
            txt_quantity.setText("");
            
        }
        else{
        JOptionPane.showMessageDialog(this, "Book Updation failed");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        if (deleteBook()==true) {
            JOptionPane.showMessageDialog(this, "Book Deleted");
            clearTable();
            setBookDetailssToTable();
            txt_bookId.setText("");
            txt_bookName.setText("");
            txt_authorName.setText("");
            txt_quantity.setText("");
            
        }
        else{
        JOptionPane.showMessageDialog(this, "Book Deletion failed");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        ManageCategory mCategory = new ManageCategory();
        mCategory.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new managebooks().setVisible(true);
                }
        });
    }  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle btn_add;
    private rojerusan.RSMaterialButtonRectangle btn_delete;
    private rojerusan.RSMaterialButtonRectangle btn_update;
    private javax.swing.JComboBox<String> combo_category;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_bookDetails;
    private javax.swing.JTextField txt_authorName;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_bookName;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
