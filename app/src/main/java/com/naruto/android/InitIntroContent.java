package com.naruto.android;

import java.util.ArrayList;
import java.util.List;

public class InitIntroContent {
    private List<Intro>introList;

    public List<Intro>getIntroList(){return introList;}

    public InitIntroContent()
    {
        this.introList=new ArrayList<>();
    }

    public void init()
    {
        for (int i = 0; i < 10; i++) {
            Intro apple = new Intro("Intro1");
            introList.add(apple);
            Intro apple1 = new Intro("Intro2");
            introList.add(apple1);
            Intro apple2 = new Intro("Intro3");
            introList.add(apple2);
            Intro apple3 = new Intro("Intro4");
            introList.add(apple3);
            Intro apple4 = new Intro("Intro5");
            introList.add(apple4);
        }
    }
}
