package com.a520.stone.honey.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.a520.stone.honey.R;

/**
 * <b>Create Date:</b> 2017/4/21<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class ButtonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, container, false);
        Button btn_button = (Button) view.findViewById(R.id.btn_button);
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"底部Fragment",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
