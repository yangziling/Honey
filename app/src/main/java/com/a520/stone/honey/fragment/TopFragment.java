package com.a520.stone.honey.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a520.stone.honey.R;

/**
 * <b>Create Date:</b> 2017/4/20<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class TopFragment extends Fragment{
    //重写Fragment中的oncreateView 方法初始化布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        //初始化Fragment界面
        View view = inflater.inflate(R.layout.fragment_top,container,false);
        return view;
    }
}
