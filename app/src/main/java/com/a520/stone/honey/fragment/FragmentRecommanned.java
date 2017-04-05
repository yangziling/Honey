package com.a520.stone.honey.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a520.stone.honey.R;

/**
 * <b>Create Date:</b> 2017/4/1<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class FragmentRecommanned extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend,container,false);
    }
}
