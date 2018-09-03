package com.naruto.android;

import android.widget.ImageView;

public class Article  {

    String articleContent;
    int articleImage;

    public Article(String articleContent, int articleImage) {
        this.articleContent = articleContent;
        this.articleImage = articleImage;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public int getArticleImage() {
        return articleImage;
    }
}
