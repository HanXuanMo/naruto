package com.naruto.android;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    //按钮距离
    private static final int DISTANCE = 300;
    private static final int DISTANCE2 = 220;

    //内容滑动id
    private RecyclerView recyclerArticleView;
    private RecyclerView recyclerGameView;
    private RecyclerView recyclerVideoView;
    private RecyclerView recyclerEvaluationView;

    //FloatingActionButton
    private FloatingActionButton actionButton;
    private FloatingActionButton actionButton1;
    private FloatingActionButton actionButton2;
    private FloatingActionButton actionButton3;
    private Drawable drawable_0;
    private Drawable drawable_1;
    private Drawable drawable_2;
    private Drawable drawable_3;
    private Drawable ID;
    private boolean mMenuOpen = false;

    //Game监听器
    private InitGameContent initGameContent = new InitGameContent();
    //Article监听器
    private InitArticleContent initArticleContent = new InitArticleContent();
    //Video监听器
    private InitVideoContent initVideoContent = new InitVideoContent();
    //Evaluation监听器
    private InitEvaluationContent initEvaluationContent = new InitEvaluationContent();

    //ViewPage
    private ViewPager mViewPager;
    View homepageContent, articleContent, gameContent, videoContent, evaluationContent;
    private List<View> viewList;//view数组

    //滑动菜单
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //悬浮按钮
        actionButton = (FloatingActionButton) findViewById(R.id.float_btn);
        actionButton1 = (FloatingActionButton) findViewById(R.id.float_btn1);
        actionButton2 = (FloatingActionButton) findViewById(R.id.float_btn2);
        actionButton3 = (FloatingActionButton) findViewById(R.id.float_btn3);
        drawable_0=actionButton.getDrawable();
        drawable_1=actionButton1.getDrawable();
        drawable_2=actionButton2.getDrawable();
        drawable_3=actionButton3.getDrawable();
        ID = drawable_0;

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

        //头像点击登录
        View headlayout = navigationView.inflateHeaderView(R.layout.nav_header);
        ImageView login = (ImageView) headlayout.findViewById(R.id.head_image);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        //ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.home_page);
        setSupportActionBar(toolbar);

        //按钮点击出现滑动菜单
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        }

        //View声明
        homepageContent = getLayoutInflater().inflate(R.layout.content_home_page, null);
        articleContent = getLayoutInflater().inflate(R.layout.content_article, null);
        gameContent = getLayoutInflater().inflate(R.layout.content_game, null);
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


        //游戏内容列表
        initGameContent.initGameps();
        recyclerGameView=(RecyclerView)gameContent.findViewById(R.id.recycler_game_ps);
        recyclerGameView.setVisibility(View.VISIBLE);
        StaggeredGridLayoutManager layoutGameManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerGameView.setLayoutManager(layoutGameManager);
        GameAdapter gameAdapter=new GameAdapter(initGameContent.getGameList());
        recyclerGameView.setAdapter(gameAdapter);

        //文章内容列表
        initArticleContent.initArticlepc();
        recyclerArticleView = (RecyclerView) articleContent.findViewById(R.id.recycler_article_ps);
        recyclerArticleView.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutArticleManager = new LinearLayoutManager(this);
        recyclerArticleView.setLayoutManager(layoutArticleManager);
        ArticleAdapter articleAdapter=new ArticleAdapter(initArticleContent.getArticleList());
        recyclerArticleView.setAdapter(articleAdapter);

        //视频内容列表
        initVideoContent.initVideopc();
        recyclerVideoView = (RecyclerView) videoContent.findViewById(R.id.recycler_video_ps);
        recyclerVideoView.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutVideoManager = new LinearLayoutManager(this);
        recyclerVideoView.setLayoutManager(layoutVideoManager);
        VideoAdapter videoAdapter=new VideoAdapter(initVideoContent.getVideoList());
        recyclerVideoView.setAdapter(videoAdapter);

        //测评内容列表
        initEvaluationContent.initEvaluationpc();
        recyclerEvaluationView = (RecyclerView) evaluationContent.findViewById(R.id.recycler_evaluation_ps);
        recyclerEvaluationView.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutEvaluationManager = new LinearLayoutManager(this);
        recyclerEvaluationView.setLayoutManager(layoutEvaluationManager);
        EvaluationAdapter evaluationAdapter=new EvaluationAdapter(initEvaluationContent.getEvaluationList());
        recyclerEvaluationView.setAdapter(evaluationAdapter);

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
                //根据图片判断滑动列表布局
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
        RecyclerViewJudge(ID);
        initViewContent(ID, viewList.get(0));
        initViewContent(ID, viewList.get(1));
        initViewContent(ID, viewList.get(2));
        initViewContent(ID, viewList.get(3));
        initViewContent(ID, viewList.get(4));
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

    //判断画面
    private void initViewContent(Drawable id, View mView) {

        if (id.equals(drawable_0) && mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id.equals(drawable_1) && mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id.equals(drawable_2) && mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id.equals(drawable_3) && mView.equals(homepageContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        } else if (id.equals(drawable_0) && mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id.equals(drawable_1) && mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id.equals(drawable_2) && mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id.equals(drawable_3) && mView.equals(articleContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }else if (id.equals(drawable_0) && mView.equals(gameContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id.equals(drawable_1) && mView.equals(gameContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id.equals(drawable_2) && mView.equals(gameContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id.equals(drawable_3) && mView.equals(gameContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }else if (id.equals(drawable_0) && mView.equals(videoContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id.equals(drawable_1) && mView.equals(videoContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id.equals(drawable_2) && mView.equals(videoContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id.equals(drawable_3) && mView.equals(videoContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }else if (id.equals(drawable_0) && mView.equals(evaluationContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorNs));
        } else if (id.equals(drawable_1) && mView.equals(evaluationContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorXbox));
        } else if (id.equals(drawable_2) && mView.equals(evaluationContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorPc));
        } else if (id.equals(drawable_3) && mView.equals(evaluationContent)) {
            mView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        }
    }

    public void RecyclerViewJudge(Drawable id1)
    {

        //隐藏现在布局
        recyclerGameView.setVisibility(View.GONE);
        recyclerArticleView.setVisibility(View.GONE);

        if(id1.equals(drawable_0))
        {
            //初始化游戏数据
            initGameContent.initGameps();
            initArticleContent.initArticleps();
            initVideoContent.initVideops();
            initEvaluationContent.initEvaluationps();

            //加载选中布局
            recyclerGameView=gameContent.findViewById(R.id.recycler_game_ps);
            recyclerGameView.setVisibility(View.VISIBLE);
            StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            recyclerGameView.setLayoutManager(layoutManager);
            GameAdapter gameAdapter=new GameAdapter(initGameContent.getGameList());
            recyclerGameView.setAdapter(gameAdapter);

            recyclerArticleView = articleContent.findViewById(R.id.recycler_article_ps);
            recyclerArticleView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutArticleManager = new LinearLayoutManager(this);
            recyclerArticleView.setLayoutManager(layoutArticleManager);
            ArticleAdapter articleAdapter=new ArticleAdapter(initArticleContent.getArticleList());
            recyclerArticleView.setAdapter(articleAdapter);

            recyclerVideoView = videoContent.findViewById(R.id.recycler_video_ps);
            recyclerVideoView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutVideoManager = new LinearLayoutManager(this);
            recyclerVideoView.setLayoutManager(layoutVideoManager);
            VideoAdapter videoAdapter=new VideoAdapter(initVideoContent.getVideoList());
            recyclerVideoView.setAdapter(videoAdapter);

            recyclerEvaluationView = evaluationContent.findViewById(R.id.recycler_evaluation_ps);
            recyclerEvaluationView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutEvaluationManager = new LinearLayoutManager(this);
            recyclerEvaluationView.setLayoutManager(layoutEvaluationManager);
            EvaluationAdapter evaluationAdapter=new EvaluationAdapter(initEvaluationContent.getEvaluationList());
            recyclerEvaluationView.setAdapter(evaluationAdapter);

        }else if (id1.equals(drawable_1))
        {
            initGameContent.initGamens();
            recyclerGameView=gameContent.findViewById(R.id.recycler_game_ns);
            recyclerGameView.setVisibility(View.VISIBLE);
            StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            recyclerGameView.setLayoutManager(layoutManager);
            GameAdapter gameAdapter=new GameAdapter(initGameContent.getGameList());
            recyclerGameView.setAdapter(gameAdapter);

            initArticleContent.initArticlens();
            recyclerArticleView = articleContent.findViewById(R.id.recycler_article_ns);
            recyclerArticleView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutArticleManager = new LinearLayoutManager(this);
            recyclerArticleView.setLayoutManager(layoutArticleManager);
            ArticleAdapter articleAdapter=new ArticleAdapter(initArticleContent.getArticleList());
            recyclerArticleView.setAdapter(articleAdapter);

            initVideoContent.initVideons();
            recyclerVideoView = videoContent.findViewById(R.id.recycler_video_ns);
            recyclerVideoView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutVideoManager = new LinearLayoutManager(this);
            recyclerVideoView.setLayoutManager(layoutVideoManager);
            VideoAdapter videoAdapter=new VideoAdapter(initVideoContent.getVideoList());
            recyclerVideoView.setAdapter(videoAdapter);

            initEvaluationContent.initEvaluationns();
            recyclerEvaluationView = evaluationContent.findViewById(R.id.recycler_evaluation_ns);
            recyclerEvaluationView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutEvaluationManager = new LinearLayoutManager(this);
            recyclerEvaluationView.setLayoutManager(layoutEvaluationManager);
            EvaluationAdapter evaluationAdapter=new EvaluationAdapter(initEvaluationContent.getEvaluationList());
            recyclerEvaluationView.setAdapter(evaluationAdapter);


        }else if (id1.equals(drawable_2))
        {
            initGameContent.initGamexbox();
            recyclerGameView=gameContent.findViewById(R.id.recycler_game_xbox);
            recyclerGameView.setVisibility(View.VISIBLE);
            StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            recyclerGameView.setLayoutManager(layoutManager);
            GameAdapter gameAdapter=new GameAdapter(initGameContent.getGameList());
            recyclerGameView.setAdapter(gameAdapter);

            initArticleContent.initArticlexbox();
            recyclerArticleView = articleContent.findViewById(R.id.recycler_article_xbox);
            recyclerArticleView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutArticleManager = new LinearLayoutManager(this);
            recyclerArticleView.setLayoutManager(layoutArticleManager);
            ArticleAdapter articleAdapter=new ArticleAdapter(initArticleContent.getArticleList());
            recyclerArticleView.setAdapter(articleAdapter);

            initVideoContent.initVideoxbox();
            recyclerVideoView = videoContent.findViewById(R.id.recycler_video_xbox);
            recyclerVideoView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutVideoManager = new LinearLayoutManager(this);
            recyclerVideoView.setLayoutManager(layoutVideoManager);
            VideoAdapter videoAdapter=new VideoAdapter(initVideoContent.getVideoList());
            recyclerVideoView.setAdapter(videoAdapter);

            initEvaluationContent.initEvaluationxbox();
            recyclerEvaluationView = evaluationContent.findViewById(R.id.recycler_evaluation_xbox);
            recyclerEvaluationView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutEvaluationManager = new LinearLayoutManager(this);
            recyclerEvaluationView.setLayoutManager(layoutEvaluationManager);
            EvaluationAdapter evaluationAdapter=new EvaluationAdapter(initEvaluationContent.getEvaluationList());
            recyclerEvaluationView.setAdapter(evaluationAdapter);


        }else if (id1.equals(drawable_3))
        {
            initGameContent.initGamepc();
            recyclerGameView=gameContent.findViewById(R.id.recycler_game_pc);
            recyclerGameView.setVisibility(View.VISIBLE);
            StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            recyclerGameView.setLayoutManager(layoutManager);
            GameAdapter gameAdapter=new GameAdapter(initGameContent.getGameList());
            recyclerGameView.setAdapter(gameAdapter);

            initArticleContent.initArticlepc();
            recyclerArticleView = articleContent.findViewById(R.id.recycler_article_pc);
            recyclerArticleView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutArticleManager = new LinearLayoutManager(this);
            recyclerArticleView.setLayoutManager(layoutArticleManager);
            ArticleAdapter articleAdapter=new ArticleAdapter(initArticleContent.getArticleList());
            recyclerArticleView.setAdapter(articleAdapter);

            initVideoContent.initVideopc();
            recyclerVideoView = videoContent.findViewById(R.id.recycler_video_pc);
            recyclerVideoView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutVideoManager = new LinearLayoutManager(this);
            recyclerVideoView.setLayoutManager(layoutVideoManager);
            VideoAdapter videoAdapter=new VideoAdapter(initVideoContent.getVideoList());
            recyclerVideoView.setAdapter(videoAdapter);

            initEvaluationContent.initEvaluationpc();
            recyclerEvaluationView = evaluationContent.findViewById(R.id.recycler_evaluation_pc);
            recyclerEvaluationView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutEvaluationManager = new LinearLayoutManager(this);
            recyclerEvaluationView.setLayoutManager(layoutEvaluationManager);
            EvaluationAdapter evaluationAdapter=new EvaluationAdapter(initEvaluationContent.getEvaluationList());
            recyclerEvaluationView.setAdapter(evaluationAdapter);

        }
    }
}
