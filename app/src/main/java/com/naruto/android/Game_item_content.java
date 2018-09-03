package com.naruto.android;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

//游戏内容
public class Game_item_content extends AppCompatActivity {

    private List<Intro>mIntrolist=new ArrayList<>();

    private RecyclerView recyclerView;

    //ViewPage
    private ViewPager mViewPager;
    View StrategyContent,IntroContent;
    private List<View> viewList;//view数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item_content);

        initIntro();

        Toolbar toolbar = (Toolbar) findViewById(R.id.home_page_gamecontent);
        setSupportActionBar(toolbar);

        StrategyContent=getLayoutInflater().inflate(R.layout.game_item_strategycontent, null);
        IntroContent=getLayoutInflater().inflate(R.layout.game_item_introcontent, null);
        viewList = new ArrayList<View>();
        viewList.add(StrategyContent);
        viewList.add(IntroContent);

        mViewPager = (ViewPager) findViewById(R.id.view_gamecontent_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs_gamecontent);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.setAdapter(pagerAdapter);

        recyclerView=(RecyclerView)IntroContent.findViewById(R.id.recycler_intro);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        IntroAdapter adapter=new IntroAdapter(mIntrolist);
        recyclerView.setAdapter(adapter);

    }

    //TabLayout(PagerAdapter)
    PagerAdapter pagerAdapter = new PagerAdapter() {

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(viewList.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }
    };

    private void initIntro() {
        for (int i = 0; i < 10; i++) {
            Intro apple = new Intro("Intro", R.drawable.ic_dashboard_black_24dp);
            mIntrolist.add(apple);
            Intro apple1 = new Intro("Intro", R.drawable.ic_dashboard_black_24dp);
            mIntrolist.add(apple1);
            Intro apple2 = new Intro("Intro", R.drawable.ic_dashboard_black_24dp);
            mIntrolist.add(apple2);
            Intro apple3 = new Intro("Intro", R.drawable.ic_dashboard_black_24dp);
            mIntrolist.add(apple3);
            Intro apple4 = new Intro("Intro", R.drawable.ic_dashboard_black_24dp);
            mIntrolist.add(apple4);
        }
    }
}
