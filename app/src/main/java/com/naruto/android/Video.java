package com.naruto.android;

import android.net.Uri;

public class Video {

    int videoImage;
    String videoTitle;
    String uri;

    public Video(String videoTitle,int videoImage,String uri)
    {
        this.videoImage=videoImage;
        this.videoTitle=videoTitle;
        this.uri=uri;
    }

    public int getVideoImage() {
        return videoImage;
    }

    public String getVideoName() {
        return videoTitle;
    }

    public String getUri() {
        return uri;
    }
}