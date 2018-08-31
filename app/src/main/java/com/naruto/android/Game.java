package com.naruto.android;

import android.widget.ImageView;
import android.widget.TextView;

public class Game {

    int gameImage;
    String gameName;

    public Game(int gameImage,String gameName)
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
