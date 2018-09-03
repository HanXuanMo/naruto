package com.naruto.android;

public class Video {

    int videoImage;
    String videoTitle;

    public Video(String videoTitle,int videoImage)
    {
        this.videoImage=videoImage;
        this.videoTitle=videoTitle;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public String getVideoName() {
        return videoTitle;
    }
}
