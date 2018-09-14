package com.naruto.android;

public class Home {

    private String article1;
    private String article2;
    private String article3;
    private String video;

    public Home(String article1,String article2,String article3,String video)
    {
        this.article1=article1;
        this.article2=article2;
        this.article3=article3;
        this.video=video;
    }

    public String getArticle1() {
        return article1;
    }

    public String getArticle2() {
        return article2;
    }

    public String getArticle3() {
        return article3;
    }

    public String getVideo() {
        return video;
    }
}
