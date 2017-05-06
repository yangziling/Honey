package com.a520.stone.honey.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.a520.stone.honey.R;

/**
 * <b>Create Date:</b> 2017/5/5<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class FlashLightActivity extends AppCompatActivity {

    private Button mTorchOnOffButton;
    private Boolean isTorchOn;
    private CameraManager mCameraManager;
    private String mCameraId;

    //自启动
    public static void start(Context context) {
        Intent starter = new Intent(context, NetWorkActivity.class);
        context.startActivity(starter);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FlashLightActivity", "onCreate()");
        setContentView(R.layout.activity_flash_light_activity);

        mTorchOnOffButton = (Button) findViewById(R.id.button_on_off);
        isTorchOn =false;

        //判断使用的设备是否支持 手电筒
        boolean isFlashAvailable =
                getApplicationContext().getPackageManager()
                                       .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        if (!isFlashAvailable){
            AlertDialog alert = new AlertDialog.Builder(FlashLightActivity.this).create();

            alert.setTitle("Error !!");
            alert.setMessage("此设备不止此 手电筒功能");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // closing the applicationfinish();
                    System.exit(0);
                }
            });
            alert.show();
            return;
        }

        //获取CameraManager对象
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try{
            mCameraId = mCameraManager.getCameraIdList()[0];
        }catch (CameraAccessException e){
            e.printStackTrace();
        }
        //点击开关按钮
        mTorchOnOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (isTorchOn){
                        turnOffFlashLight();
                        isTorchOn = false;
                    }else{
                        turnOnFlashLight();
                        isTorchOn =true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
    //打开闪光灯
    private void turnOnFlashLight() {
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                mCameraManager.setTorchMode(mCameraId,true);
                        //playOnOffSound();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //关闭闪光灯
    private void turnOffFlashLight() {
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                mCameraManager.setTorchMode(mCameraId,false);
                        //playOnOffSound();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isTorchOn){
            turnOffFlashLight();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isTorchOn){
            turnOffFlashLight();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isTorchOn){
            turnOnFlashLight();
        }
    }
}
