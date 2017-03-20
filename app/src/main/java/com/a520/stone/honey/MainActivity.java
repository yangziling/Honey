package com.a520.stone.honey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
                                                               View.OnLongClickListener {

    private EditText et_name, et_pass;
    private Button bt_pwd_clear;
    private Button bt_username_clear;
    private Button bt_pwd_eye;

    private int SERVER_FLAG=0;
    private Boolean isReLogin = false;

    private TextWatcher username_watcher;
    private TextWatcher password_watcher;

    private Button mLoginButton, mLoginError, mRegister, ONLYTEST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.username);
        et_pass = (EditText) findViewById(R.id.password);

        bt_username_clear = (Button) findViewById(R.id.bt_username_clear);
        bt_pwd_clear = (Button) findViewById(R.id.bt_pwd_clear);
        bt_pwd_eye = (Button) findViewById(R.id.bt_pwd_eye);

        bt_username_clear.setOnClickListener(this);
        bt_pwd_clear.setOnClickListener(this);
        bt_pwd_eye.setOnClickListener(this);
        initWatcher();

        et_name.addTextChangedListener(username_watcher);
        et_pass.addTextChangedListener(password_watcher);

        mLoginButton = (Button) findViewById(R.id.login);
        mLoginError = (Button) findViewById(R.id.login_error);
        mRegister = (Button) findViewById(R.id.register);
        ONLYTEST = (Button) findViewById(R.id.registfer);
        ONLYTEST.setOnClickListener(this);
        ONLYTEST.setOnLongClickListener(this);

        mLoginButton.setOnClickListener(this);
        mLoginError.setOnClickListener(this);
        mRegister.setOnClickListener(this);


    }

    private void initWatcher() {
        username_watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                et_pass.setText("");
                if (s.toString().length() > 0) {
                    bt_username_clear.setVisibility(View.VISIBLE);
                } else {
                    bt_username_clear.setVisibility(View.VISIBLE);
                }
            }
        };

        password_watcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() > 0) {
                    bt_pwd_clear.setVisibility(View.VISIBLE);
                } else {
                    bt_pwd_clear.setVisibility(View.VISIBLE);
                }
            }
        };
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login://登录

//                login();
                HomeActivity.start(MainActivity.this);
                break;
            case R.id.login_error://无法登陆（忘记密码）

                // TODO: 2017/3/20  
                break;
            case R.id.register://注册新的用户

                // TODO: 2017/3/20 跳转到注册页面
                break;
            case R.id.registfer:
                if (SERVER_FLAG>10){
                    Toast.makeText(this,"内部测试：",Toast.LENGTH_LONG).show();
                }
                SERVER_FLAG++;
                break;
            case R.id.bt_username_clear:
                et_name.setText("");
                et_pass.setText("");
                break;
            case R.id.bt_pwd_clear:
                et_pass.setText("");
                break;
            case R.id.bt_pwd_eye:
                if (et_pass.getInputType() == (InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD)){
                    bt_pwd_eye.setBackgroundResource(R.drawable.button_eye_n);
                    et_pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_NORMAL);
                }else {
                    bt_pwd_eye.setBackgroundResource(R.drawable.button_eye_n);
                    et_pass.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                et_pass.setSelection(et_pass.getText().toString().length());
                break;
        }
    }

    /**
     * 登录
     */
    private void login(){
        /**
         * 判断业务逻辑
         * 匹配相应的字段，进行比较
         */

    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.registfer:
                if (SERVER_FLAG>9){

                }
                break;
        }
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (isReLogin){
                Intent mHomeIntent = new Intent(Intent.ACTION_MAIN);
                mHomeIntent.addCategory(Intent.CATEGORY_HOME);
                mHomeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                MainActivity.this.startActivity(mHomeIntent);
            }else {
                MainActivity.this.finish();
            }
            return false;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
