
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBconnection;
import techquizapp.pojo.Exam;
public class ExamDAO {
    private static Connection conn;
    public static String getExamID() throws SQLException{
        conn = DBconnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select count(*) from exam");
        rs.next();
        int examid = rs.getInt(1);
        String newId = "EX-"+(examid+1);
        return newId;
    }
    public static boolean addExam(Exam exam) throws SQLException{
        conn = DBconnection.getConnection();
        PreparedStatement  pst = conn.prepareStatement("insert into exam values(?,?,?)");
        pst.setString(1, exam.getExamId());
        pst.setString(2, exam.getLanguage());
        pst.setInt(3, exam.getNoOFQuestions());
        int ans = pst.executeUpdate();
        return ans==1;
    }
    public static ArrayList<String> getExamIDbySubject(String subj) throws SQLException{
        conn = DBconnection.getConnection();
        PreparedStatement  pst = conn.prepareStatement("select examid from exam where language =?");
        pst.setString(1, subj);
        ArrayList<String> examidList = new ArrayList<>();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            examidList.add(rs.getString(1));
        }
        return examidList;
    }
    public static int getNoOfQues(String examid) throws SQLException{
        conn = DBconnection.getConnection();
        PreparedStatement  pst = conn.prepareStatement("select TOTAL_QUESTION from exam where examid =?");
        pst.setString(1 , examid );
        ResultSet rs = pst.executeQuery();
        int totalQ=0;
        while(rs.next()){
            totalQ = rs.getInt(1);
        }
        return totalQ;
        
    }
    public static boolean isPaperSet(String subjectName) throws SQLException {
        conn = DBconnection.getConnection();
        PreparedStatement  pst = conn.prepareStatement("select 1 from exam where language =?");
        pst.setString(1, subjectName);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }
    public static ArrayList<String> getExamIdbySubject(String userName,String subject) throws SQLException {
       String qry =" select examid from exam where language=? minus select examid from performance where userid =?";
       conn = DBconnection.getConnection();
        PreparedStatement  pst = conn.prepareStatement(qry);
        pst.setString(1, subject);
        pst.setString(2, userName);
        ResultSet rs = pst.executeQuery();
        ArrayList<String> arrList = new ArrayList<>();
        while(rs.next()){
           arrList.add(rs.getString(1));
        }
        return arrList;
    }
}
