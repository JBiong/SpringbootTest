package com.acadzen.acadzen.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblflashcard")
public class FlashcardEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flashcardID;

    private String question;

    private String answer;

    public FlashcardEntity(){

    }

    public FlashcardEntity(int flashcardID, String question, String answer){
        this.flashcardID = flashcardID;
        this.question = question;
        this.answer = answer;
    }

    public int getFlashcardID(){
        return flashcardID;
    }

    public void setFlashcardID(int flashcardID){
        this.flashcardID = flashcardID;
    }

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }
}
