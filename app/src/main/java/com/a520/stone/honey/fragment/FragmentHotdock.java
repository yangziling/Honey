package com.a520.stone.honey.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.a520.stone.honey.R;
import com.a520.stone.honey.activity.NetWorkActivity;

/**
 * <b>Create Date:</b> 2017/4/1<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class FragmentHotdock extends Fragment{

    private TextView mHotText;
    private Button mHotButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotdock,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //解析xml布局 拿到view
        mHotText = (TextView) getActivity().findViewById(R.id.hotdock_text);
        mHotButton = (Button) getActivity().findViewById(R.id.hotdock_button);
        mHotText.setText("欢迎来到热点fragment");
        mHotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetWorkActivity.start(getContext());
//                Toast.makeText(getActivity().getApplication(), "点我干嘛",Toast.LENGTH_LONG).show();
            }
        });
    }
}
