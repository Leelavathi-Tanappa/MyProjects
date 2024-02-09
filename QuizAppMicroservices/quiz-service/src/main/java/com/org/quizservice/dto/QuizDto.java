package com.org.quizservice.dto;

public class QuizDto {
    private String category;
    private int numQ;
    private String quizTitle;

    public QuizDto() {
    }

    public QuizDto(String category, int numQ, String quizTitle) {
        this.category = category;
        this.numQ = numQ;
        this.quizTitle = quizTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumQ() {
        return numQ;
    }

    public void setNumQ(int numQ) {
        this.numQ = numQ;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }
}
