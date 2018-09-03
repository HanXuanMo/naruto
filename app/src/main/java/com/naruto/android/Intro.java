package com.naruto.android;

import android.widget.ImageView;

public class Intro  {

    String introContent;
    int introImage;

    public Intro(String IntroContent, int IntroImage) {
        this.introContent = IntroContent;
        this.introImage = IntroImage;
    }

    public String getIntroContent() {
        return introContent;
    }

    public int getIntroImage() {
        return introImage;
    }
}
