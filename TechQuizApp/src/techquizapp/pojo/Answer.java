package techquizapp.pojo;

import java.util.Objects;

public class Answer {

    private String subject, examid, chosenAnswer, correctAnswer;
    private int qno;

    @Override
    public boolean equals(Object obj) {
        Answer other = (Answer) obj;
        if (this.examid.equals(other.examid) == false) {
            return false;
        }
        if (this.subject.equals(other.subject) == false) {
            return false;
        }
        if (this.chosenAnswer.equals(other.chosenAnswer) == false) {
            return false;
        }
        if (this.correctAnswer.equals(other.correctAnswer) == false) {
            return false;
        }
        if (this.qno != (other.qno)) {
            return false;
        }
        return true;
    }

    public Answer(String subject, String examid, String userAnswer, String correctAnswer, int qno) {
        this.subject = subject;
        this.examid = examid;
        this.chosenAnswer = userAnswer;
        this.correctAnswer = correctAnswer;
        this.qno = qno;
    }

    @Override
    public String toString() {
        return "Answer{" + "subject=" + subject + ", examid=" + examid + ", chosenAnswer=" + chosenAnswer + ", correctAnswer=" + correctAnswer + ", qno=" + qno + '}';
    }

    public String getSubject() {
        return subject;
    }

    public String getExamid() {
        return examid;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getQno() {
        return qno;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }
}
