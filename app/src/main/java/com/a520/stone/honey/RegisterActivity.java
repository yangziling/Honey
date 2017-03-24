package com.a520.stone.honey;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * <b>Create Date:</b> 2017/3/23<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private ImageView mArrowBack;
    private TextView mRegister;

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

        mRegister = (TextView) findViewById(R.id.text_register);
        mRegister.setText("注册账户");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_arrow://back返回
                RegisterActivity.this.finish();
                break;
        }
    }

    //添加 右上角的 功能栏。
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
    //点击功能栏上的按钮，之后操作的执行的操作。
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.toolbar_action1:
                Toast.makeText(this,"你点击了，排序菜单！",Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this,"你点击了，整理菜单！",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);
        }

    }
}
