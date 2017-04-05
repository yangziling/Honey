package com.a520.stone.honey.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.a520.stone.honey.fragment.FragmentHotdock;
import com.a520.stone.honey.fragment.FragmentPicture;
import com.a520.stone.honey.fragment.FragmentRecommanned;
import com.a520.stone.honey.fragment.FragmentVideo;

/**
 * <b>Create Date:</b> 2017/4/1<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"热点", "视频", "图片","推荐"};

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1){
            return new FragmentVideo();
        }else if (position == 2){
            return new FragmentPicture();
        }else if (position == 3){
            return new FragmentRecommanned();
        }
        return new FragmentHotdock();
    }

    @Override
    public int getCount() {

        return mTitles.length;
    }

    //viewPager与TabLayout绑定后，这里获取到PageTitle 就是 tab 的text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
