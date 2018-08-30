package com.naruto.android;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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


}
