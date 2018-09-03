package com.naruto.android;

import android.widget.ImageView;
import android.widget.TextView;

public class Game {

    private int gameImage;
    private String gameName;

    public Game(String gameName,int gameImage)
    {
        this.gameImage=gameImage;
        this.gameName=gameName;
    }

    public String getGameName()
    {
        return gameName;
    }

    public int getGameImage()
    {
        return gameImage;
    }


}
