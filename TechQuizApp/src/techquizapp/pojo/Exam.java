
package techquizapp.pojo;

public class Exam {
    private String language;
    private String examId;
    private int noOFQuestions;
    
    public Exam(){
        
    }
    public Exam(String examId,String language,int noOfQuestions){
        this.examId = examId;
        this.language = language;
        this.noOFQuestions = noOfQuestions;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getNoOFQuestions() {
        return noOFQuestions;
    }

    public void setNoOFQuestions(int noOFQuestions) {
        this.noOFQuestions = noOFQuestions;
    }
}
