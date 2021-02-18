
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import techquizapp.pojo.Question;
import techquizapp.dbutil.DBconnection;
import techquizapp.pojo.QuestionStore;
public class QuestionDAO {
    public static void addQuestions(QuestionStore qstore)throws SQLException
    {  try{
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<Question> questionsList = qstore.getAllQuestions();
        for(Question q:questionsList)
        {
            ps.setString(1, q.getExamid());
            ps.setInt(2, q.getNoOfQuestion());
            ps.setString(3, q.getQuestion());
            ps.setString(4,q.getAnswer1());
            ps.setString(5,q.getAnswer2());
            ps.setString(6,q.getAnswer3());
            ps.setString(7,q.getAnswer4());
            ps.setString(8, q.getCorrectAns());
            ps.setString(9,q.getSubject());
            ps.executeUpdate();
        }
      }
      catch(NullPointerException e){
          System.out.println("Error in QDAO Class" +e);
          e.printStackTrace();
      }
    }
    public static ArrayList<Question> getQuestionsByExamId(String examid)throws SQLException {
        Connection conn=DBconnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from questions where examid=? order by qno");
        ps.setString(1, examid);
        ResultSet rs = ps.executeQuery();
        ArrayList<Question> questionList = new ArrayList<>();
        while(rs.next()){
            int qno = rs.getInt(2);
            String question = rs.getString(3);
            String answer1 = rs.getString(4);
            String answer2 = rs.getString(5);
            String answer3 = rs.getString(6);
            String answer4 = rs.getString(7);
            String correctAns = rs.getString(8);
            String lang = rs.getString(9);
            Question obj = new Question(examid,qno,question,answer1,answer2,answer3,answer4,correctAns,lang);
            questionList.add(obj);
        }
        return questionList;
    }
    public static void updateQuestions(QuestionStore qstore)throws SQLException {
        Connection conn=DBconnection.getConnection();
        String qry = "update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where examid=? and qno=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ArrayList<Question> questionList = qstore.getAllQuestions();
       for(Question q : questionList){
           ps.setString(1, q.getQuestion());
           ps.setString(2, q.getAnswer1());
           ps.setString(3, q.getAnswer2());
           ps.setString(4, q.getAnswer3());
           ps.setString(5, q.getAnswer4());
           ps.setString(6, q.getCorrectAns());
           ps.setString(7, q.getExamid());
           ps.setInt(8, q.getNoOfQuestion());
           ps.executeUpdate();
        }
    }
    
}

