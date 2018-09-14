package com.naruto.android;

import java.util.ArrayList;
import java.util.List;

public class InitHomeContent {

    private List<Home> homeList;

    public List<Home> getHomeList() {
        return homeList;
    }

    public InitHomeContent() {
        this.homeList = new ArrayList<>();
    }

    public void initVideo() {
        for (int i = 0; i < 10; i++) {
            Home home1 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home1);
            Home home2 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home2);
            Home home3 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home3);
            Home home4 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home4);
            Home home5 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home5);
            Home home6 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home6);
            Home home7 = new Home("新闻1","新闻2","新闻3","http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
            homeList.add(home7);
        }
    }
}
