
package techquizapp.pojo;

public class StudentScore {
  private String examid;
  private double percentage;
  private String subject;
    
  public StudentScore(String examid, double percentage, String subject) {
        this.examid = examid;
        this.percentage = percentage;
        this.subject = subject;
    }
    public String getExamid() {
        return examid;
    }

    

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
  
}
