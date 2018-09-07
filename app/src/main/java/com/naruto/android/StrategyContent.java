package com.naruto.android;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//游戏内容
public class StrategyContent {
    private String name;
    private int imageView;
    private String strategyView;

    StrategyContent(String name,int imageView,String strategyView)
    {
        this.name=name;
        this.imageView=imageView;
        this.strategyView=strategyView;
    }

    public String getName() {
        return name;
    }

    public int getImageView() {
        return imageView;
    }

    public String getStrategyView() {
        return strategyView;
    }
}
