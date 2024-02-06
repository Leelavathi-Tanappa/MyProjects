package com.org.springboot.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String quizTitle;
    @ManyToMany
    private List<Questions> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }
    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", quizTitle='" + quizTitle + '\'' +
                ", questions=" + questions +
                '}';
    }
}
