package com.naruto.android;

import android.content.Context;
import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//游戏内容
public class Game_item_content extends AppCompatActivity {

    //游戏名字
    private String Name;


    private ImageView imageView;
    private TextView textView;
    private TextView strategyVIew;

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

        Intent intent=getIntent();
        Name=intent.getStringExtra("name");


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

        textView=(TextView)StrategyContent.findViewById(R.id.game_item_name);
        textView.setText(Name);
        imageView=(ImageView)StrategyContent.findViewById(R.id.game_item_image);
        strategyVIew=(TextView)StrategyContent.findViewById(R.id.game_item_strategy);
        Judge_Gamecontent(Name);


        recyclerView=(RecyclerView)IntroContent.findViewById(R.id.recycler_intro);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        IntroAdapter adapter=new IntroAdapter(mIntrolist);
        recyclerView.setAdapter(adapter);

    }


    //Toolbar上显示按键
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.back:
                Intent intent=new Intent(Game_item_content.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;
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

    //活动数据传递
    public static void actionStart(Context context, String data1)
    {
        Intent intent=new Intent(context,Game_item_content.class);
        intent.putExtra("name",data1);
        context.startActivity(intent);
    }

    public void Judge_Gamecontent(String name) {
        if (name.equals("cyberpunk2077")) {
            imageView.setImageResource(R.drawable.cyberpunk2077_game);
            strategyVIew.setText("《赛博朋克2077》是知名《巫师》系列开发商CD Projekt RED公布的一款角色扮演游戏，故事设定在黑暗的、科技极度发达的腐败未来世界中，并且兼有沙盒元素与RPG机制。\n" + "游戏的世界架构灵感来自著名科幻作家麦克·戈尔登史密斯的同名小说。制作人表示这款游戏会像《巫师》系列一样细节饱满丰富，将为玩家带来非线性复杂刺激剧情游戏体验。玩家在游戏中将拥有自己独特的游戏体验，可以从不同的职业中选择自定义自己的角色，无论是嗜杀成性的雇佣兵还是诡计多端的黑客，这些角色都可以装备不同种类的自动化的装置和致命的武器。\n" + "类似《巫师》系列，本作中玩家将迎来道德层面的抉择，这些抉择也最终影响玩家的命运和外围游戏世界");
        } else if (name.equals("wizard_3")) {
            imageView.setImageResource(R.drawable.wizard_3_game);
            strategyVIew.setText("《巫师3：狂猎》将是三部曲系列的最后一作，故事将有宏大的最后结局，但并非《巫师》系列的最终作。本作采用最新的REDengine3引擎制作，玩家可以在无缝的世界里任意探索，采用非线性剧情的设定，整体规模是前作的30倍。再加上真实的角色设定，迷人的故事以及一个无需载入过程的玩家可以自由自在畅游的开放环境，我们将会把游戏体验带到一个新的高度，给玩家更加真实的体验与完完全全的代入感。\n" + "《巫师3》的游戏结局大致上可划分成三条主线，玩家在游戏关键节点的选择将会把这三条主线划分成了36种不同的结局。不过，别以为这样就完了。Michal Platkow-Gilewski表示，事实上《巫师3》拥有变幻莫测的游戏过程，玩家在游戏中的一举一动都会对游戏的走向产生细小的影响，而所有这些影响最终都会通过不同的游戏结局体现出来。");
        } else if (name.equals("blood_source")) {
            imageView.setImageResource(R.drawable.blood_source_game);
            strategyVIew.setText("《血源》是一款由索尼和From Software联合打造的动作角色扮演游戏。该作被誉为《恶魔之魂》与《黑暗之魂》系列的精神续作，游戏场面保持了这两款系列游戏的恐怖黑色风格。游戏的关键要素是血源以及野兽，而且游戏的地图设定保持为无缝连接，战斗不仅仅注重动作要素同时重视策略要素，可以说每一场战斗被设计的如同最终决战。另外，游戏包含线上要素，允许玩家共同探险。\n" + "另外，《血源》的繁体中文版将在2015年3月24日发售。");
        } else if (name.equals("detroit")) {
            imageView.setImageResource(R.drawable.detroit_game);
            strategyVIew.setText("《底特律：变人》是由Quantic Dream制作的一款科幻题材互动电影。游戏的背景设定在未来的底特律，玩家将扮演三位主角卡拉、康纳和马库斯，在一个个的选择中决定他们三个会成为怎样的人，并见证当机器人拥有了情感后，世界会变成将会如何。");
        } else if (name.equals("god_of_war4")) {
            imageView.setImageResource(R.drawable.god_of_war4_game);
            strategyVIew.setText("《战神4》是一款由索尼制作并发行的动作冒险游戏，是《战神3》的正统续作。本作的正式名称为“God of War”，并没有数字序号，也代表了该系列的重启，但本作是系列的第四部正统作品，国内玩家更习惯使用“战神4”这个方便的叫法。对主角奎托斯来讲，这也是一个史诗级新篇章的开始。他将摆脱神的影子，作为普通人隐居北欧神话的新大陆，为了他的儿子以及新目标，奎托斯必须为生存而战斗，对抗威胁他全新人生的强大力量。");
        } else if (name.equals("persona5")) {
            imageView.setImageResource(R.drawable.persona5_game);
            strategyVIew.setText("《女神异闻录5》是Atlus旗下人气游戏RPG游戏，本作继续由桥野桂担任游戏导演，目黑将司为游戏作曲，副岛成记担当角色设计。游戏将以现代日本为舞台，描写年轻的“怪盗们”暗中活跃的故事，本作以RPG中少有的犯罪方为焦点讲述故事，本作的基调十分新潮，配乐、人设、配色游戏UI无一不给给玩家带来十分刺激的感官体验。");
        }
    }
}
