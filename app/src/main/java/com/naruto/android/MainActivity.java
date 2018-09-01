package com.naruto.android;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Drawable drawable_0,drawable_1,drawable_2,drawable_3;
    //
    private  ViewGroup mViewGroup;
    private static Drawable ID;

    //按钮距离
    private static final int DISTANCE = 300;
    private static final int DISTANCE2 = 220;

    //FloatingActionButton
    private FloatingActionButton actionButton, actionButton1, actionButton2, actionButton3;
    private boolean mMenuOpen = false;
    private View mFlMenu;

    //Game监听器
    private List<Game>gameList=new ArrayList<>();

    //ViewPage
    private ViewPager mViewPager;
    View homepageContent, articleContent, gameContent, videoContent, evaluationContent;
    private List<View> viewList;//view数组

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //滑动菜单点击事件
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);//获取滑动菜单事件
        navigationView.setCheckedItem(R.id.navigation_home);//默认选择navigation_home

        //设置监听器
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:

                        break;
                    case R.id.navigation_collect:

                        break;
                    case R.id.navigation_balance:

                        break;
                    case R.id.navigation_transaction:

                        break;
                    case R.id.navigation_synchronization:

                        break;
                    case R.id.navigation_support:

                        break;
                    case R.id.navigation_cooperation:

                        break;
                    default:
                }
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        //ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_page);
        setSupportActionBar(toolbar);

        //滑动菜单
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        //View声明
        homepageContent = getLayoutInflater().inflate(R.layout.content_home_page, null);
        articleContent = getLayoutInflater().inflate(R.layout.content_article, null);
        gameContent = getLayoutInflater().inflate(R.layout.game_item, null);
        videoContent = getLayoutInflater().inflate(R.layout.content_video, null);
        evaluationContent = getLayoutInflater().inflate(R.layout.content_evaluation, null);
        viewList = new ArrayList<View>();
        viewList.add(homepageContent);
        viewList.add(articleContent);
        viewList.add(gameContent);
        viewList.add(videoContent);
        viewList.add(evaluationContent);

        //TabLayout
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        mViewPager.setAdapter(pagerAdapter);

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
            //载入FloatingActionButton
            initView();
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

    };

    private void initView() {
        mFlMenu = findViewById(R.id.fl_menu);

        actionButton = (FloatingActionButton) findViewById(R.id.float_btn);
        actionButton1 = (FloatingActionButton) findViewById(R.id.float_btn1);
        actionButton2 = (FloatingActionButton) findViewById(R.id.float_btn2);
        actionButton3 = (FloatingActionButton) findViewById(R.id.float_btn3);

        drawable_0=actionButton.getDrawable();
        drawable_1=actionButton1.getDrawable();
        drawable_2=actionButton2.getDrawable();
        drawable_3=actionButton3.getDrawable();



        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMenuOpen) {
                    hideMenu();
                }else {
                    showMenu();
                }
            }
        });
        //触发按钮
        actionButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //获取原按钮及点击按钮图片
                Drawable drawable = actionButton.getDrawable();
                Drawable drawable1 = actionButton1.getDrawable();
                ID = drawable1;
                //交换原按钮及点击按钮图片
                actionButton1.setImageDrawable(drawable);
                actionButton.setImageDrawable(drawable1);

                hideMenu();
            }
        });

        actionButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Drawable drawable = actionButton.getDrawable();
                Drawable drawable2 = actionButton2.getDrawable();
                ID = drawable2;
                actionButton2.setImageDrawable(drawable);
                actionButton.setImageDrawable(drawable2);

                hideMenu();
            }
        });

        actionButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Drawable drawable = actionButton.getDrawable();
                Drawable drawable3 = actionButton3.getDrawable();
                ID = drawable3;
                actionButton3.setImageDrawable(drawable);
                actionButton.setImageDrawable(drawable3);

                hideMenu();
            }
        });
    }

    private void showMenu() {
        mMenuOpen = true;
        //获取按钮坐标
        int x = (int) actionButton.getX();
        int y = (int) actionButton.getY();
        //动画
        ValueAnimator v1 = ValueAnimator.ofInt(x, x - DISTANCE);
        //动画播放时间
        v1.setDuration(500);
        //动画更新
        v1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取按钮上，下，左，右的坐标
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton1.getY();
                int r = actionButton1.getWidth() + l;
                int b = actionButton1.getHeight() + t;
                //设置按钮坐标
                actionButton1.layout(l, t, r, b);
            }
        });
        ValueAnimator v2x = ValueAnimator.ofInt(x, x - DISTANCE2);
        ValueAnimator v2y = ValueAnimator.ofInt(y, y - DISTANCE2);
        v2x.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton2.getY();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        v2y.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton2.getX();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        ValueAnimator v3 = ValueAnimator.ofInt(y, y - DISTANCE);
        v3.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton3.getX();
                int r = actionButton3.getWidth() + l;
                int b = actionButton3.getHeight() + t;
                actionButton3.layout(l, t, r, b);
            }
        });
        //开始动画
        v1.start();
        v2x.start();
        v2y.start();
        v3.start();
    }

    private void hideMenu() {
        mMenuOpen = false;
        //获取按钮坐标
        int x = (int) actionButton1.getX();
        //动画
        ValueAnimator v1 = ValueAnimator.ofInt(x, (int) actionButton.getX());
        //动画播放时间
        v1.setDuration(500);
        //动画更新
        v1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取按钮上，下，左，右的坐标
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton1.getY();
                int r = actionButton1.getWidth() + l;
                int b = actionButton1.getHeight() + t;
                //设置按钮坐标
                actionButton1.layout(l, t, r, b);
            }
        });
        x = (int) actionButton2.getX();
        int y = (int) actionButton2.getY();
        ValueAnimator v2x = ValueAnimator.ofInt(x, (int) actionButton.getX());
        ValueAnimator v2y = ValueAnimator.ofInt(y, (int) actionButton.getY());
        v2x.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int l = (int) animation.getAnimatedValue();
                int t = (int) actionButton2.getY();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        v2y.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton2.getX();
                int r = actionButton2.getWidth() + l;
                int b = actionButton2.getHeight() + t;
                actionButton2.layout(l, t, r, b);
            }
        });
        y = (int) actionButton3.getY();
        ValueAnimator v3 = ValueAnimator.ofInt(y, (int) actionButton.getY());
        v3.setDuration(500).addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int t = (int) animation.getAnimatedValue();
                int l = (int) actionButton3.getX();
                int r = actionButton3.getWidth() + l;
                int b = actionButton3.getHeight() + t;
                actionButton3.layout(l, t, r, b);
            }
        });
        //开始动画
        initViewContent(ID, viewList.get(0));
        initViewContent(ID, viewList.get(1));
        initViewContent(ID, viewList.get(2));
        initViewContent(ID, viewList.get(3));
        v1.start();
        v2x.start();
        v2y.start();
        v3.start();
    }

    //菜单点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    private void initGame() {
        for (int i = 0; i < 10; i++) {
            Game apple = new Game("Apple", R.drawable.ic_dashboard_black_24dp);
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

    //判断画面
   private void initViewContent(Drawable id, View mView) {
        if (id==drawable_0&& mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id==drawable_1&& mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id==drawable_2&& mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id==drawable_3&& mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        } else if (id==drawable_0&& mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id==drawable_1&& mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id==drawable_2&& mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id==drawable_3&& mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
    }

}
