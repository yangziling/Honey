package com.a520.stone.honey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TableLayout;

import com.a520.stone.honey.adapter.MyFragmentAdapter;

/**
 * <b>Create Date:</b> 2017/3/20<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MyFragmentAdapter myFragmentAdapter;
    private TabLayout mTabLayout;

    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;
    private TabLayout.Tab four;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏整个actionBar
//        getSupportActionBar().hide();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //初始化视图
        initViews();
    }

    //初始化视图
    private void initViews() {
        //使viewPager 与Fragment绑定在一起
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentAdapter);

        //将TabLayout 与 Viewpager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);

        //指定tab 的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        four = mTabLayout.getTabAt(3);

        //设置各个tab 的图标
        one.setIcon(R.drawable.ic_launcher);
        two.setIcon(R.drawable.ic_launcher);
        three.setIcon(R.drawable.ic_launcher);
        four.setIcon(R.drawable.ic_launcher);

    }


}
