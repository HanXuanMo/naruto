package com.naruto.android;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//游戏内容
public class Game_item_content extends AppCompatActivity {

    //游戏姓名，主题图，游戏简介，图片简介
    private String Name;
    private ImageView imageView;
    private TextView nameView;
    private TextView strategyView;

    private boolean flag;

    //游戏图片
    private ImageView picture1;
    private ImageView picture2;
    private ImageView picture3;
    private ImageView picture4;


    private List<Intro>mIntrolist=new ArrayList<>();
    private List<StrategyContent>strategyContentList=new ArrayList<>();

    private RecyclerView recyclerView;

    //ViewPage
    private ViewPager mViewPager;
    View StrategyContent,IntroContent;
    private List<View> viewList;//view数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item_content);

        //初始化攻略内容
        InitIntroContent initIntroContent=new InitIntroContent();
        initIntroContent.init();
        mIntrolist=initIntroContent.getIntroList();

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

        nameView=(TextView)StrategyContent.findViewById(R.id.game_item_name);
        nameView.setText(Name);
        //简介收缩
        strategyView=(TextView)StrategyContent.findViewById(R.id.game_item_strategy);
        strategyView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.game_item_strategy:
                        if (!flag) {
                            flag = true;
                            strategyView.setEllipsize(null);  //展开
                            strategyView.setSingleLine(false);
                        } else {
                            flag = false;
                            strategyView.setEllipsize(TextUtils.TruncateAt.END);  //收缩
                            strategyView.setLines(2);
                        }
                        break;

                    default:
                        break;

                }
            }
        });
        picture1=(ImageView)StrategyContent.findViewById(R.id.picture1);
        picture2=(ImageView)StrategyContent.findViewById(R.id.picture2);
        picture3=(ImageView)StrategyContent.findViewById(R.id.picture3);
        picture4=(ImageView)StrategyContent.findViewById(R.id.picture4);
        imageView=(ImageView)StrategyContent.findViewById(R.id.game_item_image);
        InitStrategyContent init=new InitStrategyContent();
        init.init();
        strategyContentList=init.getStrategyContentList();
        Judge_Gamecontent(Name);


        recyclerView=(RecyclerView)IntroContent.findViewById(R.id.recycler_intro);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        IntroAdapter adapter=new IntroAdapter(mIntrolist);
        recyclerView.setAdapter(adapter);
        //添加下划线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

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

    //活动数据传递
    public static void actionStart(Context context, String data1)
    {
        Intent intent=new Intent(context,Game_item_content.class);
        intent.putExtra("name",data1);
        context.startActivity(intent);
    }


    //判断游戏并设置图片和简介
    public void Judge_Gamecontent(String name) {

        int imageID=R.drawable.cyberpunk2077_game;
        String strategyID="内动为空";

        for(int i=0;i<strategyContentList.size();i++)
        {
            if(strategyContentList.get(i).getName().equals(name))
            {
                imageID=strategyContentList.get(i).getImageView();
                strategyID=strategyContentList.get(i).getStrategyView();
                pictureSet(name);
                break;
            }
        }
        imageView.setImageResource(imageID);
        strategyView.setText(strategyID);
    }

    //游戏图片动态加载
    public void pictureSet(String name)
    {
        switch (name)
        {
            case "cyberpunk2077":
                picture1.setImageResource(R.drawable.cyberpunk2077_picture1);
                picture2.setImageResource(R.drawable.cyberpunk2077_picture2);
                picture3.setImageResource(R.drawable.cyberpunk2077_picture3);
                picture4.setImageResource(R.drawable.cyberpunk2077_picture4);
                break;
            case "blood_source":
                picture1.setImageResource(R.drawable.blood_source_picture1);
                picture2.setImageResource(R.drawable.blood_source_picture2);
                picture3.setImageResource(R.drawable.blood_source_picture3);
                picture4.setImageResource(R.drawable.blood_source_picture4);
                break;
            case "detroit":
                picture1.setImageResource(R.drawable.detroit_picture1);
                picture2.setImageResource(R.drawable.detroit_picture2);
                picture3.setImageResource(R.drawable.detroit_picture3);
                picture4.setImageResource(R.drawable.detroit_picture4);
                break;
            case "god_of_war4":
                picture1.setImageResource(R.drawable.god_of_war4_picture1);
                picture2.setImageResource(R.drawable.god_of_war4_picture2);
                picture3.setImageResource(R.drawable.god_of_war4_picture3);
                picture4.setImageResource(R.drawable.god_of_war4_picture4);
                break;
            case "persona5":
                picture1.setImageResource(R.drawable.persona5_picture1);
                picture2.setImageResource(R.drawable.persona5_picture2);
                picture3.setImageResource(R.drawable.persona5_picture3);
                picture4.setImageResource(R.drawable.persona5_picture4);
                break;
            case "wizard_3":
                picture1.setImageResource(R.drawable.wizard_3_picture1);
                picture2.setImageResource(R.drawable.wizard_3_picture2);
                picture3.setImageResource(R.drawable.wizard_3_picture3);
                picture4.setImageResource(R.drawable.wizard_3_picture4);
                break;
        }
    }
}
