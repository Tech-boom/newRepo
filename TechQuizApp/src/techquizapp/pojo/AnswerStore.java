
package techquizapp.pojo;

import java.util.ArrayList;

public class AnswerStore {
   ArrayList <Answer> answerList;
    public AnswerStore()
    {
       answerList=new ArrayList<>();
    }
    public void addAnswer(Answer ans){
        answerList.add(ans);
    }
    public Answer getAnswer(int pos){
        return answerList.get(pos);
    }
    public Answer getAnswerByQno(int qno)
    {
        for(Answer ans: answerList){
            if(ans.getQno()==qno)
                return ans;
        }
        return null;
    }
    public void removeAnswer(int pos){
        answerList.remove(pos);
    }
    public void setAnswerAt(int pos,Answer q){
        answerList.add(pos, q);
    }
    public ArrayList<Answer> getAllAnswer(){
        return answerList;
    }
    public int getCount(){
        return answerList.size();
    }    
    public int removeAnswer(Answer answer){
        int pos = answerList.indexOf(answer);
        answerList.remove(pos);
        return pos;
    }
}
