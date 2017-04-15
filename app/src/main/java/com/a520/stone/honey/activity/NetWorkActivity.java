package com.a520.stone.honey.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

import com.a520.stone.honey.R;

/**
 * <b>Create Date:</b> 2017/4/6<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class NetWorkActivity extends AppCompatActivity {

    private static final String TAG = "NetWorkActivity";
    private TextView mNetWork;
    private TelephonyManager mTelephonyManager;
    private PhoneStateListener mPhoneStateListener;
    private NetWorkBroadCastReciver mNetWorkBroadCastReciver;
    private int mGsmSignalStrength;

    public static void start(Context context) {
        Intent starter = new Intent(context, NetWorkActivity.class);
        context.startActivity(starter);
    }

    /**
     * 网络信号强度检测
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        mNetWork = (TextView) findViewById(R.id.network_text);

        //获取telephonyManager
        mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //监听信号
        mPhoneStateListener = new PhoneStateListener();

        //通过广播来监听网络信号
        mNetWorkBroadCastReciver = new NetWorkBroadCastReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION);
        //注册广播
        registerReceiver(mNetWorkBroadCastReciver,intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //回到此页面 重新获取监听
        mTelephonyManager.listen(mPhoneStateListener,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //离开此页面 停止监听
        mTelephonyManager.listen(mPhoneStateListener, PhoneStatListener.LISTEN_NONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetWorkBroadCastReciver);
    }

    //获取信号强度
    private class PhoneStatListener extends PhoneStateListener{

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            //获取0-4的5种信号级别 越大信号越好
            mGsmSignalStrength = signalStrength.getGsmSignalStrength();
            Log.e(TAG,":::::"+mGsmSignalStrength);
            //网络信号改变时，获取网络信息
            getNetWorkInfo();

        }

    }

    //获取网络信息
    private void getNetWorkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()){
            switch (info.getType()){
                case ConnectivityManager.TYPE_WIFI:
                    WifiManager manager = (WifiManager) getSystemService(getApplicationContext().WIFI_SERVICE);
                    WifiInfo connectionInfo = manager.getConnectionInfo();
                    int rssi = connectionInfo.getRssi();
                    mNetWork.setText("当前为wifi网络，信号强度=" + rssi);
                    break;
                case ConnectivityManager.TYPE_MOBILE:
                    //移动网络,可以通过TelephonyManager来获取具体细化的网络类型
                    String netWorkStatus = isFastMobileNetwork() ? "4G网络" : "2G网络";
                    mNetWork.setText("当前为" +netWorkStatus + "，信号强度=" + mGsmSignalStrength+"\n"+mTelephonyManager.getNetworkType());
                    break;
            }
        }else{
            mNetWork.setText("没有可用网络");
        }


    }
    /**
     * 判断网络速度
     */
    private boolean isFastMobileNetwork() {
        if (mTelephonyManager.getNetworkType() == TelephonyManager.NETWORK_TYPE_LTE) {
            //这里只简单区分两种类型网络，认为4G网络为快速，但最终还需要参考信号值
            Log.i("NetWorkActivity",mTelephonyManager.getNetworkType()+"");
            return true;
        }
        return false;
    }
    //创建内部广播
    class NetWorkBroadCastReciver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            getNetWorkInfo();
        }
    }

}
