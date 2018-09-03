package com.naruto.android;

public class Evaluation {

    int evaluationImage;
    String evaluationTitle;

    public Evaluation(String evaluationTitle, int evaluationImage)
    {
        this.evaluationImage=evaluationImage;
        this.evaluationTitle=evaluationTitle;
    }

    public int getEvaluationImage() {
        return evaluationImage;
    }

    public String getEvaluationTitle() {
        return evaluationTitle;
    }
}
