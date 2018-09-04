package com.naruto.android;

import java.util.ArrayList;
import java.util.List;

public class InitGameContent {

    private List<Game>gameList;

    public List<Game> getGameList() {
        return gameList;
    }

    public InitGameContent() {
        this.gameList = new ArrayList<>();
    }

    public void initGameps() {
        gameList.clear ();
        for (int i = 0; i < 10; i++) {
            Game apple = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(apple);
            Game banana = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(banana);
            Game orange = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(orange);
            Game watermelon = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(watermelon);
            Game pear = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(pear);
            Game grape = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(grape);
            Game pineapple = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(pineapple);
            Game strawberry = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(strawberry);
            Game cherry = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(cherry);
            Game mango = new Game("cyberpunk2077", R.drawable.cyberpunk2077);
            gameList.add(mango);
        }
    }
    public void initGamens() {
        gameList.clear ();
        for (int i = 0; i < 10; i++) {
            Game apple = new Game("AppleNS", R.drawable.ic_dashboard_black_24dp);
            gameList.add(apple);
            Game banana = new Game("Banana",R.drawable.ic_dashboard_black_24dp);
            gameList.add(banana);
            Game orange = new Game("Orange",R.drawable.ic_dashboard_black_24dp);
            gameList.add(orange);
            Game watermelon = new Game("Watermelon", R.drawable.ic_dashboard_black_24dp);
            gameList.add(watermelon);
            Game pear = new Game("Pear", R.drawable.ic_dashboard_black_24dp);
            gameList.add(pear);
            Game grape = new Game("Grape", R.drawable.ic_dashboard_black_24dp);
            gameList.add(grape);
            Game pineapple = new Game("Pineapple",R.drawable.ic_dashboard_black_24dp);
            gameList.add(pineapple);
            Game strawberry = new Game("Strawberry",R.drawable.ic_dashboard_black_24dp);
            gameList.add(strawberry);
            Game cherry = new Game("Cherry",R.drawable.ic_dashboard_black_24dp);
            gameList.add(cherry);
            Game mango = new Game("Mango",R.drawable.ic_dashboard_black_24dp);
            gameList.add(mango);
        }
    }
    public void initGamepc() {
        gameList.clear ();
        for (int i = 0; i < 10; i++) {
            Game apple = new Game("ApplePC", R.drawable.ic_dashboard_black_24dp);
            gameList.add(apple);
            Game banana = new Game("Banana",R.drawable.ic_dashboard_black_24dp);
            gameList.add(banana);
            Game orange = new Game("Orange",R.drawable.ic_dashboard_black_24dp);
            gameList.add(orange);
            Game watermelon = new Game("Watermelon", R.drawable.ic_dashboard_black_24dp);
            gameList.add(watermelon);
            Game pear = new Game("Pear", R.drawable.ic_dashboard_black_24dp);
            gameList.add(pear);
            Game grape = new Game("Grape", R.drawable.ic_dashboard_black_24dp);
            gameList.add(grape);
            Game pineapple = new Game("Pineapple",R.drawable.ic_dashboard_black_24dp);
            gameList.add(pineapple);
            Game strawberry = new Game("Strawberry",R.drawable.ic_dashboard_black_24dp);
            gameList.add(strawberry);
            Game cherry = new Game("Cherry",R.drawable.ic_dashboard_black_24dp);
            gameList.add(cherry);
            Game mango = new Game("Mango",R.drawable.ic_dashboard_black_24dp);
            gameList.add(mango);
        }
    }
    public void initGamexbox() {
        gameList.clear ();
        for (int i = 0; i < 10; i++) {
            Game apple = new Game("AppleXBOX", R.drawable.ic_dashboard_black_24dp);
            gameList.add(apple);
            Game banana = new Game("Banana",R.drawable.ic_dashboard_black_24dp);
            gameList.add(banana);
            Game orange = new Game("Orange",R.drawable.ic_dashboard_black_24dp);
            gameList.add(orange);
            Game watermelon = new Game("Watermelon", R.drawable.ic_dashboard_black_24dp);
            gameList.add(watermelon);
            Game pear = new Game("Pear", R.drawable.ic_dashboard_black_24dp);
            gameList.add(pear);
            Game grape = new Game("Grape", R.drawable.ic_dashboard_black_24dp);
            gameList.add(grape);
            Game pineapple = new Game("Pineapple",R.drawable.ic_dashboard_black_24dp);
            gameList.add(pineapple);
            Game strawberry = new Game("Strawberry",R.drawable.ic_dashboard_black_24dp);
            gameList.add(strawberry);
            Game cherry = new Game("Cherry",R.drawable.ic_dashboard_black_24dp);
            gameList.add(cherry);
            Game mango = new Game("Mango",R.drawable.ic_dashboard_black_24dp);
            gameList.add(mango);
        }
    }
}
