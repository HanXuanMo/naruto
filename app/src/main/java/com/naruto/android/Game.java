package com.naruto.android;

public class Game {

    int gameImage;
    String gameName;

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
