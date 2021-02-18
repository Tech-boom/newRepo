
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.dbutil.DBconnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.Question;
import techquizapp.pojo.StudentScore;

public class PerformanceDAO {
    private static Connection conn = null;
    public static void addPerformance(Performance per) throws SQLException{
        conn = DBconnection.getConnection();
        String qry = "insert into performance values(?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(qry);
        pst.setString(1,per.getUserid());
        pst.setString(2, per.getExamid());
        pst.setInt(3, per.getRight());
        pst.setInt(4, per.getWrong());
        pst.setInt(5, per.getUnattempted());
        pst.setDouble(6, per.getPer());
        pst.setString(7, per.getLanguage());
        pst.executeUpdate();
    }
    public static ArrayList<StudentScore> getperformance(String userid)throws SQLException {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid,per,language from performance where userid=?");
        ps.setString(1, userid);
        ResultSet rs = ps.executeQuery();
        ArrayList<StudentScore> performList = new ArrayList<>();
        while(rs.next()){
            String examid = rs.getString(1);
            double per = rs.getDouble(2);
            String lang = rs.getString(3);
            StudentScore obj = new StudentScore(examid,per,lang);
            performList.add(obj);
        }
        return performList;
    }
    public static ArrayList<Performance> getAllStudentPerformance()throws SQLException {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from performance");
        ResultSet rs = ps.executeQuery();
        ArrayList<Performance> performList = new ArrayList<>();
        while(rs.next()){
            String userid = rs.getString(1);
            String examid = rs.getString(2);
            int right = rs.getInt(3);
            int wrong = rs.getInt(4);
            int unattem = rs.getInt(5);
            double per = rs.getDouble(6);
            String lang = rs.getString(7);
            Performance obj = new Performance(userid, examid, lang, right, wrong, unattem, per);
            performList.add(obj);
        }
        return performList;
    }
}
