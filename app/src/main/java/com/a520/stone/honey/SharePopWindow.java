package com.a520.stone.honey;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * <b>Create Date:</b> 2017/4/5<br>
 * <b>Author:</b> Stone <br>
 * <b>Description:</b> <br>
 */
public class SharePopWindow extends PopupWindow {

    private View mView;

    public SharePopWindow(Activity context, View.OnClickListener itemsOnClick) {
        super(context);
        initView(context, itemsOnClick);
    }

    //初始化布局
    private void initView(final Activity context, View.OnClickListener itemsOnClick) {

        LayoutInflater mInflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mView = mInflater.inflate(R.layout.popwindow_shared, null);

        LinearLayout weiXFriend = (LinearLayout) mView.findViewById(R.id.weixinghaoyou);
        LinearLayout friendster = (LinearLayout) mView.findViewById(R.id.pengyouquan);
        LinearLayout QQFriend = (LinearLayout) mView.findViewById(R.id.qqhaoyou);
        LinearLayout QQZone = (LinearLayout) mView.findViewById(R.id.qqkongjian);
        TextView canaleTv = (TextView) mView.findViewById(R.id.share_cancle);

        canaleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //销毁弹出框
                dismiss();
                backgroundAlpha(context, 1f);
            }
        });

        //按钮设置监听
        weiXFriend.setOnClickListener(itemsOnClick);
        friendster.setOnClickListener(itemsOnClick);
        QQFriend.setOnClickListener(itemsOnClick);
        QQZone.setOnClickListener(itemsOnClick);

        //设置SelectPicPopupWindow的View
        this.setContentView(mView);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.FILL_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow可触摸
        this.setTouchable(true);

        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha(context, 0.5f);
        //设置
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(context, 1f);
            }
        });

    }

    /**
     * 设置添加屏幕的透明度
     *
     * @param context
     * @param bgAlpha
     */
    public void backgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.DIM_AMOUNT_CHANGED);
        context.getWindow().setAttributes(lp);
    }


}
