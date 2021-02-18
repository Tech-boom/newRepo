
package techquizapp.pojo;

public class Question {
    private String examid;
    private int noOfQuestion;
    private String subject;
    private String answer1,answer2,answer3,answer4;
   // private String option1,option2,option3,option4;
    private String correctAns;
    private String question;    

    public Question(String examid, int noOfQuestion, String question , String answer1, String answer2, String answer3, String answer4, String correctAns,String subject) {
        this.examid = examid;
        this.noOfQuestion = noOfQuestion;
        this.subject = subject;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAns = correctAns;
        this.question = question;
    }
    public Question(){}
     @Override
    public String toString() {
        return "Question{" + "examid=" + examid + ", noOfQuestion=" + noOfQuestion + ", subject=" + subject + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAns=" + correctAns + ", question=" + question + '}';
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public int getNoOfQuestion() {
        return noOfQuestion;
    }

    public void setNoOfQuestion(int noOfQuestion) {
        this.noOfQuestion = noOfQuestion;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String option1) {
        this.answer1 = option1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String option2) {
        this.answer2 = option2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String option3) {
        this.answer3 = option3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String option4) {
        this.answer4 = option4;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    @Override
    public boolean equals(Object obj) {
        Question other = (Question) obj;
        if (this.examid.equals(other.examid)==false) {
            return false;
        }
        if (this.noOfQuestion != other.noOfQuestion) {
            return false;
        }
        if (this.question.equals(other.question)==false) {
            return false;
        }
        if (this.answer1.equals(other.answer1)==false) {
            return false;
        }
        if (this.answer2.equals(other.answer2)==false) {
            return false;
        }
        if (this.answer3.equals(other.answer3)==false) {
            return false;
        }
        if (this.answer4.equals(other.answer4)==false) {
            return false;
        }
        if (this.correctAns.equals(other.correctAns)==false) {
            return false;
        }
        return true;
    }
}
