package com.a520.stone.honey;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * <b>Create Date:</b> 2017/3/23<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class RegisterActivity extends ActionBarActivity {

    private Toolbar mToolbar;

    public static void start(Context context) {
        Intent starter = new Intent(context, RegisterActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                                 WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        setContentView(R.layout.activity_register);

        //注册账户
        mToolbar = (Toolbar) findViewById(R.id.register_toolbar);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);


    }
}
