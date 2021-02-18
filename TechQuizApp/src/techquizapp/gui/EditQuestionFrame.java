/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.gui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JOptionPane;
import techquizapp.dao.QuestionDAO;
import techquizapp.pojo.QuestionStore;
import techquizapp.pojo.Exam;
import techquizapp.pojo.Question;
import techquizapp.pojo.UserProfile;

/**
 *
 * @author DELL
 */
public class EditQuestionFrame extends javax.swing.JFrame {
   private Exam newEx =null;
   private QuestionStore qstore = null;
   private HashMap<String,String> options;
   private int qno,pos=0;
   String question,op1,op2,op3,op4,language,correct,correctOp; 
    public EditQuestionFrame() {
        initComponents();
        setTitle("Tech-Quiz Application");
        setLocationRelativeTo(null);
        lblAdminName.setText("Hello,"+UserProfile.getUsername());
        qstore = new QuestionStore();
        options = new HashMap<>();
        options.put("Option 1","Answer1"); 
        options.put("Option 2","Answer2");
        options.put("Option 3","Answer3");
        options.put("Option 4","Answer4");
        qno=1;
        lblCurrQues.setText("Question no "+qno);
    }
    public EditQuestionFrame(Exam e){
        this();
        newEx = e;
        lblSetTitle.setText("EDITIONG "+newEx.getLanguage().toUpperCase()+" PAPER");
        loadQuestions();
        showQuestion();
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
        jLabel8 = new javax.swing.JLabel();
        lblCurrQues = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtQues = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JTextField();
        txtOption2 = new javax.swing.JTextField();
        txtOption3 = new javax.swing.JTextField();
        txtOption4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcbCorrectOption = new javax.swing.JComboBox<>();
        btnDone = new javax.swing.JButton();
        lblAdminName = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        lblSetTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\onlineexam\\questionpaper4.jpg")); // NOI18N
        jLabel8.setText("jLabel8");

        lblCurrQues.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblCurrQues.setForeground(new java.awt.Color(204, 255, 255));
        lblCurrQues.setText("Question : 1");

        txtQues.setColumns(20);
        txtQues.setRows(5);
        jScrollPane1.setViewportView(txtQues);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Option : 1 ");

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Option : 2 ");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Option : 3 ");

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Option : 4 ");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Correct Answer :");

        jcbCorrectOption.setMaximumRowCount(4);
        jcbCorrectOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Option 1", "Option 2", "Option 3", "Option 4" }));

        btnDone.setBackground(new java.awt.Color(0, 0, 0));
        btnDone.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnDone.setForeground(new java.awt.Color(204, 204, 204));
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        lblAdminName.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblAdminName.setForeground(new java.awt.Color(204, 255, 255));

        btnLogOut.setBackground(new java.awt.Color(51, 51, 51));
        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(204, 255, 255));
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(204, 204, 204));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 0, 0));
        btnNext.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnNext.setForeground(new java.awt.Color(204, 204, 204));
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPrevious.setBackground(new java.awt.Color(0, 0, 0));
        btnPrevious.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        btnPrevious.setForeground(new java.awt.Color(204, 204, 204));
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        lblSetTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        lblSetTitle.setForeground(new java.awt.Color(153, 255, 204));
        lblSetTitle.setText("QUESTIONS REMAINING");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(340, 340, 340))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNext)
                        .addGap(57, 57, 57)
                        .addComponent(btnPrevious)
                        .addGap(57, 57, 57)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogOut)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblSetTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(35, 35, 35)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(73, 73, 73)
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcbCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lblCurrQues)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(66, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut))
                .addGap(2, 2, 2)
                .addComponent(lblSetTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addGap(290, 290, 290)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDone)
                    .addComponent(btnCancel)
                    .addComponent(btnNext)
                    .addComponent(btnPrevious))
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(238, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCurrQues))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtOption2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(26, 26, 26))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jcbCorrectOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(123, 123, 123)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
      try{
          QuestionDAO.updateQuestions(qstore);
          JOptionPane.showMessageDialog(null,"All Questions has been sent to Datebade","Updated",JOptionPane.INFORMATION_MESSAGE);
          EditPaperFrame editFrame = new EditPaperFrame();
          editFrame.setVisible(true);
          this.dispose();
        } 
      catch(SQLException ex){
          JOptionPane.showMessageDialog(null,"Error in Updateting question to DB","Error",JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int ans = JOptionPane.showConfirmDialog(null,"Do you want to Log out ? ","Log Out",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
        if(ans==JOptionPane.YES_OPTION){
            LoginFrame logIn = new LoginFrame();
            logIn.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
       int res = JOptionPane.showConfirmDialog(null,"Are you Sure ,you want to go back to Admin Panel " ,"Cancel",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(res==JOptionPane.YES_OPTION){
            AdminOptionsFrame adminFrame = new AdminOptionsFrame();
            adminFrame.setVisible(true);
            this.dispose();
        }     
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
     if(validateAll()){
           JOptionPane.showMessageDialog(null,"Please Fill all Details","Error",JOptionPane.ERROR_MESSAGE);
           return;
        }
        question = txtQues.getText().trim();
        op1 = txtOption1.getText().trim();
        op2 = txtOption2.getText().trim();
        op3 = txtOption3.getText().trim();
        op4 = txtOption4.getText().trim();
        correct = jcbCorrectOption.getSelectedItem().toString().trim(); 
        correctOp = options.get(correct); 
        Question quesObj = new Question();
        quesObj.setQuestion(question);
        quesObj.setAnswer1(op1);
        quesObj.setAnswer2(op2);
        quesObj.setAnswer3(op3);
        quesObj.setAnswer4(op4);
        quesObj.setCorrectAns(correctOp);
        quesObj.setExamid(newEx.getExamId());
        quesObj.setNoOfQuestion(newEx.getNoOFQuestions());
        quesObj.setSubject(newEx.getLanguage());
        qstore.removeQuestion(pos);
        qstore.setQuestionAt(pos, quesObj);
        pos++;
        System.out.println("Pos "+pos+"  qstore.getCount +"+qstore.getCount());
        if(pos>=qstore.getCount()){
            JOptionPane.showMessageDialog(null,"All Question Are Successfully Set \n Click Done button to Save Paper to Database ","Exam Edited",JOptionPane.INFORMATION_MESSAGE);
            pos=0;
        }
        showQuestion();
        qno++;
        if(qno>qstore.getCount()){
            qno=1;
        }
        lblCurrQues.setText("Question no."+qno);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
       if(validateAll()){
           JOptionPane.showMessageDialog(null,"Please Fill all Details","Error",JOptionPane.ERROR_MESSAGE);
           return;
        }
        question = txtQues.getText().trim();
        op1 = txtOption1.getText().trim();
        op2 = txtOption2.getText().trim();
        op3 = txtOption3.getText().trim();
        op4 = txtOption4.getText().trim();
        correct = jcbCorrectOption.getSelectedItem().toString().trim(); 
        correctOp = options.get(correct); 
        Question quesObj = new Question();
        quesObj.setQuestion(question);
        quesObj.setAnswer1(op1);
        quesObj.setAnswer2(op2);
        quesObj.setAnswer3(op3);
        quesObj.setAnswer4(op4);
        quesObj.setCorrectAns(correctOp);
        quesObj.setExamid(newEx.getExamId());
        quesObj.setNoOfQuestion(newEx.getNoOFQuestions());
        quesObj.setSubject(newEx.getLanguage());
        qstore.removeQuestion(pos);
        qstore.setQuestionAt(pos, quesObj);
        pos--;
        if(pos<0){
            JOptionPane.showMessageDialog(null,"All Question Are Successfully Set \n Click Done button to Save Paper to Database ","Exam Edited",JOptionPane.INFORMATION_MESSAGE);
            pos=qstore.getCount()-1;
        }
        showQuestion();
        qno--;
        if(qno<=0){
            qno=qstore.getCount();
        }
        lblCurrQues.setText("Question no."+qno);
    }//GEN-LAST:event_btnPreviousActionPerformed

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
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestionFrame().setVisible(true);
            }
        });
    }
    private boolean validateAll(){
      if(txtQues.getText().isEmpty()==true||txtOption1.getText().isEmpty()==true||txtOption2.getText().isEmpty()==true||
                 txtOption3.getText().isEmpty()==true||txtOption4.getText().isEmpty()==true)
          return true;
      return false;
    }
    public void loadQuestions(){
        try{
            ArrayList<Question> questionlist = QuestionDAO.getQuestionsByExamId(newEx.getExamId());
            for(Question obj : questionlist){
                qstore.addQuestion(obj);
            }
           }
          catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Problem in get Question from DB ","Error",JOptionPane.ERROR_MESSAGE);
           ex.printStackTrace();
          }
      }
    public void showQuestion(){
        Question q = qstore.getQuestion(pos);
        txtQues.setText(q.getQuestion());
        txtOption1.setText(q.getAnswer1());
        txtOption2.setText(q.getAnswer2());
        txtOption3.setText(q.getAnswer3());
        txtOption4.setText(q.getAnswer4());
        String correctAns = q.getCorrectAns(); System.out.println("Correct Ans "+correctAns);
        String correctop = getKeyValuePair(correctAns);  System.out.println("Correct Op "+correctop);
        jcbCorrectOption.setSelectedItem(correctop);
    }
    public String getKeyValuePair(String value){
        Set<String>keys = options.keySet();
         for(String key:keys){
             String currValue = options.get(key);
             if(currValue.equals(value)){
                 return key;
             }
            }
         return null;
       }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCorrectOption;
    private javax.swing.JLabel lblAdminName;
    private javax.swing.JLabel lblCurrQues;
    private javax.swing.JLabel lblSetTitle;
    private javax.swing.JTextField txtOption1;
    private javax.swing.JTextField txtOption2;
    private javax.swing.JTextField txtOption3;
    private javax.swing.JTextField txtOption4;
    private javax.swing.JTextArea txtQues;
    // End of variables declaration//GEN-END:variables
}
