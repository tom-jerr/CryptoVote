package com.example.toupiao.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.toupiao.R;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.ZhuCeBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.AppUtils;
import com.example.toupiao.utils.PrefUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etPsw)
    EditText etPsw;
    private long exitTime;
    @Override
    protected int initContentView() {
        return R.layout.activity_login;
    }

    public static void forward(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    //监听手机的物理按键
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(this, "再点击一次退出APP", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {

            AppUtils.AppExit(LoginActivity.this);
        }
    }

    @OnClick({R.id.btLogin, R.id.tvRegister})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:
                login();
//                MainActivity.forward(LoginActivity.this);
                break;
            case R.id.tvRegister:
                RegisterActivity.forward(LoginActivity.this);
                break;
        }
    }

    private void login() {
        String phone = etPhone.getText().toString();
        String psw = etPsw.getText().toString();



        System.out.println("已点击");



    if (TextUtils.isEmpty(phone)) {
            ToastUtils.showToast(LoginActivity.this, "请输入手机号！");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            ToastUtils.showToast(LoginActivity.this, "请输入密码！");
            return;
        }
        if (phone.length() != 11) {
            ToastUtils.showToast(LoginActivity.this, "您输入的手机号长度不对哦！");
            return;
        }
        showProgressDialog(false);
        Map<String,String> map = new HashMap<>();
        map.put("userphone",""+phone);
        map.put("password",""+psw);
        MyHttpUtils.postHttpMessage(AppUrl.loginapp, map, ZhuCeBean.class, new RequestCallBack<ZhuCeBean>() {



            @Override
            public void requestSuccess(ZhuCeBean json) {
                if (json.getCode()==200) {
                    PrefUtils.putParameter("user_id", "" + json.getContent().getUser_id());
                    PrefUtils.putString(LoginActivity.this, "isLogin", "1");
                    MainActivity.forward(LoginActivity.this);
                    finish();
                }
                ToastUtils.showToast(LoginActivity.this, json.getMsg());
                stopProgressDialog();
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
                stopProgressDialog();
            }
        });
    }
}
