package com.a520.stone.honey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.style.LineHeightSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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

    private SharePopWindow mSharePopWindow;
    private ImageView mHomeBack;
    private ImageView mHomeShare;

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏整个actionBar
        //getSupportActionBar().hide();
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        mHomeShare = (ImageView) findViewById(R.id.home_share);
        mHomeBack = (ImageView) findViewById(R.id.home_back);

        mHomeShare.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 mSharePopWindow = new SharePopWindow(MainActivity.this, itemsOnClick);
                 mSharePopWindow.showAtLocation(view, Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
             }
         });
        mHomeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

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
//        one.setIcon(R.drawable.ic_launcher);
//        two.setIcon(R.drawable.ic_launcher);
//        three.setIcon(R.drawable.ic_launcher);
//        four.setIcon(R.drawable.ic_launcher);

    }
    //为弹出窗口实现监听类
    private View.OnClickListener itemsOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mSharePopWindow.dismiss();
            mSharePopWindow.backgroundAlpha(MainActivity.this, 1f);

            switch (v.getId()){
                case R.id.weixinghaoyou:
                    Toast.makeText(MainActivity.this, "微信好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.pengyouquan:
                    Toast.makeText(MainActivity.this, "朋友圈", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.qqhaoyou:
                    Toast.makeText(MainActivity.this, "QQ好友", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.qqkongjian:
                    Toast.makeText(MainActivity.this, "QQ空间", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        }
    };




}
