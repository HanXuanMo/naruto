package com.naruto.android;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //滑动菜单点击事件
        mTextView = (TextView) findViewById(R.id.text_show);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(R.id.home_page);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_page:
                        mTextView.setText("首页");
                        break;
                    case R.id.navigation_game:
                        mTextView.setText("游戏");
                        break;
                    case R.id.navigation_circle:
                        mTextView.setText("圈子");
                        break;
                    case R.id.navigation_me:
                        mTextView.setText("我的");
                        break;
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

        //TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        //tab可滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab居中显示
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        //tab的字体选择器,默认黑色,选择时红色
        tabLayout.setTabTextColors(Color.BLACK, Color.RED);
        //tab的下划线颜色,默认是粉红色
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);

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

    //设置tabLayout的点击监听器
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";


        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_main, container, false);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 11;
        }
    }

}