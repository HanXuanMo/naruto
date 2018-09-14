package com.naruto.android;

public class Evaluation {

    int evaluationImage;
    String evaluationName;

    public Evaluation(String evaluationName, int evaluationImage)
    {
        this.evaluationImage=evaluationImage;
        this.evaluationName=evaluationName;
    }

    public int getEvaluationImage() {
        return evaluationImage;
    }

    public String getEvaluationName() {
        return evaluationName;
    }
}
