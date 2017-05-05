package com.a520.stone.honey.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.a520.stone.honey.R;

/**
 * <b>Create Date:</b> 2017/4/20<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class TestFragmentActivity extends AppCompatActivity {

    //静态方法 自身对象启动自己
    public static void start(Context context) {
        Intent starter = new Intent(context, TestFragmentActivity.class);
        starter.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_activity);

    }
}
