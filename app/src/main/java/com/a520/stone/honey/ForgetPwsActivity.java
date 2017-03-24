package com.a520.stone.honey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * <b>Create Date:</b> 2017/3/23<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class ForgetPwsActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private TextView mRegister;

    public static void start(Context context) {
        Intent starter = new Intent(context, ForgetPwsActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpsw);
        mRegister = (TextView) findViewById(R.id.text_forget);
        mRegister.setText("忘记密码");


    }

    //back返回
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_arrow:
                ForgetPwsActivity.this.finish();
                break;
        }
    }


}
