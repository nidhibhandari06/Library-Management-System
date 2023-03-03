/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.* ;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author lenovo
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String studentName,course,branch;
        int studentId;
        DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }

    //To set the Student details into the table
    public void setStudentDetailsToTable(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/library_ms","root","");
            Statement st=con.createStatement();
            ResultSet rs= st.executeQuery("select * from student_details");
            
            while(rs.next()){
                String studentId=rs.getString("student_id");
                String studentName=rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
            
                Object[] obj={studentId,studentName,course,branch};
                model =(DefaultTableModel) tbl_studentsDetails.getModel();
                model.addRow(obj);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    // To add book into the book_details table  
    public boolean addStudent(){
        boolean isAdded=false;
        studentId=Integer.parseInt(txt_studentId.getText());
        studentName=txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql="insert into student_details values(?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isAdded = true;
            }else{
                isAdded = false;
            }
                
                    
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return isAdded;
    }
    //To Update Student details
    public boolean updateStudent(){
        boolean isUpdated=false;
        studentId=Integer.parseInt(txt_studentId.getText());
        studentName=txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql="update student_details set name = ?, course = ?, branch = ? where student_id=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isUpdated = true;
            }else{
                isUpdated = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isUpdated;
    }
        
    //Method to Delete book from book_details table
    public boolean deleteStudent(){
        boolean isDeleted=false;
        studentId=Integer.parseInt(txt_studentId.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql="delete from student_details where student_id=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            
            pst.setInt(1, studentId);
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isDeleted = true;
            }else{
                isDeleted = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isDeleted;
    }
        
    
    //Method to Clear Table
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel) tbl_studentsDetails.getModel();
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

        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_bookId1 = new app.bolivia.swing.JCTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txt_bookName1 = new app.bolivia.swing.JCTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txt_autherName1 = new app.bolivia.swing.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_quantity1 = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle4 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle5 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle6 = new necesario.RSMaterialButtonCircle();
        jPanel13 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new necesario.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new necesario.RSMaterialButtonCircle();
        combo_branch = new javax.swing.JComboBox<>();
        combo_CourseName = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentsDetails = new rojerusan.RSTableMetro();
        jLabel6 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();

        jPanel10.setBackground(new java.awt.Color(102, 102, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 51, 51));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel5.setText("Back");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel20.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Enter Book Id");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 170, -1));

        jLabel21.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 50));

        txt_bookId1.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId1.setPlaceholder("Enter Username...");
        txt_bookId1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookId1FocusLost(evt);
            }
        });
        txt_bookId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookId1ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, -1));

        jLabel22.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Enter Book Name");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 170, -1));

        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, 50));

        txt_bookName1.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName1.setPlaceholder("Enter Book Name...");
        txt_bookName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookName1FocusLost(evt);
            }
        });
        txt_bookName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookName1ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_bookName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, -1));

        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Auther Name");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 170, -1));

        jLabel25.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, -1));

        txt_autherName1.setBackground(new java.awt.Color(102, 102, 255));
        txt_autherName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_autherName1.setPlaceholder("Auther Name...");
        txt_autherName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_autherName1FocusLost(evt);
            }
        });
        txt_autherName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_autherName1ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_autherName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 250, -1));

        jLabel26.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Quantity");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 170, -1));

        jLabel27.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 60, 50));

        txt_quantity1.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity1.setPlaceholder("Quantity...");
        txt_quantity1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantity1FocusLost(evt);
            }
        });
        txt_quantity1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantity1ActionPerformed(evt);
            }
        });
        jPanel10.add(txt_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 250, -1));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle4.setText("DELETE");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 110, 60));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle5.setText("ADD");
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 110, 60));

        rSMaterialButtonCircle6.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle6.setText("UPDATE");
        rSMaterialButtonCircle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle6ActionPerformed(evt);
            }
        });
        jPanel10.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 110, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(102, 102, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7jLabel2MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, -1));

        jPanel13.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Enter Student Id");
        jPanel13.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 170, -1));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel13.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 60, 50));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel13.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 250, -1));

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Enter Student Name");
        jPanel13.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 170, -1));

        jLabel17.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel13.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 60, 50));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setPlaceholder("Enter Student Name...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel13.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select Course");
        jPanel13.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 170, -1));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel13.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 60, -1));

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Select Branch");
        jPanel13.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 170, -1));

        jLabel19.setFont(new java.awt.Font("Microsoft JhengHei", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel13.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 60, 50));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle1MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel13.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 110, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel13.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 110, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel13.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 110, 60));

        combo_branch.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "PLAIN", "ELECTRONICS", " " }));
        jPanel13.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 250, 20));

        combo_CourseName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        jPanel13.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 250, 20));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 660));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentsDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentsDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentsDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentsDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentsDetails.setRowHeight(25);
        tbl_studentsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentsDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentsDetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 570, 220));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel6.setText("Manage Students");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 350, -1));

        jPanel14.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 350, 5));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 880, 660));

        setSize(new java.awt.Dimension(1310, 668));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5jLabel2MouseClicked

    private void txt_bookId1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookId1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookId1FocusLost

    private void txt_bookId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookId1ActionPerformed

    private void txt_bookName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookName1FocusLost

    private void txt_bookName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookName1ActionPerformed

    private void txt_autherName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_autherName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_autherName1FocusLost

    private void txt_autherName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_autherName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_autherName1ActionPerformed

    private void txt_quantity1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantity1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantity1FocusLost

    private void txt_quantity1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantity1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantity1ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle6ActionPerformed

    private void jLabel7jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7jLabel2MouseClicked
    HomePage home=new HomePage();
    home.setVisible(true);
    dispose();
    }//GEN-LAST:event_jLabel7jLabel2MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost

    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void tbl_studentsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentsDetailsMouseClicked

        int rowNo=tbl_studentsDetails.getSelectedRow();
        TableModel model= tbl_studentsDetails.getModel();

        txt_studentId.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo,1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tbl_studentsDetailsMouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
    if(addStudent()==true){
        JOptionPane.showMessageDialog(this, "Student Added");
        clearTable();
        setStudentDetailsToTable();
    }else{
        JOptionPane.showMessageDialog(this, "Student Addtion Failed");
    }
        
        
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
     if(updateStudent()==true){
        JOptionPane.showMessageDialog(this, "Student Updated");
        clearTable();
        setStudentDetailsToTable();
    }else{
        JOptionPane.showMessageDialog(this, "Student Updation Failed");
    }
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void rSMaterialButtonCircle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1MouseClicked
    if(deleteStudent()==true){
        JOptionPane.showMessageDialog(this, "Student Deleted");
        clearTable();
        setStudentDetailsToTable();
    }else{
        JOptionPane.showMessageDialog(this, "Student Deletion Failed");
    }
    }//GEN-LAST:event_rSMaterialButtonCircle1MouseClicked

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
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private rojerusan.RSTableMetro tbl_studentsDetails;
    private app.bolivia.swing.JCTextField txt_autherName1;
    private app.bolivia.swing.JCTextField txt_bookId1;
    private app.bolivia.swing.JCTextField txt_bookName1;
    private app.bolivia.swing.JCTextField txt_quantity1;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
