package com.example.toupiao.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.toupiao.R;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.ZhuCeBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etPsw)
    EditText etPsw;
    @BindView(R.id.etPswOnce)
    EditText etPswOnce;
    @BindView(R.id.btRegister)
    Button btRegister;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;

    @Override
    protected int initContentView() {
        return R.layout.activity_register;
    }

    public static void forward(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("注册");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.btRegister, R.id.ll_common_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
                finish();
                break;
            case R.id.btRegister:
                String phone = etPhone.getText().toString();
                String psw = etPsw.getText().toString();
                String psw_once = etPswOnce.getText().toString();
                if (TextUtils.isEmpty(phone)) {
                    ToastUtils.showToast(RegisterActivity.this, "请输入手机号！");
                    return;
                }
                if (TextUtils.isEmpty(psw)) {
                    ToastUtils.showToast(RegisterActivity.this, "请输入密码！");
                    return;
                }
                if (TextUtils.isEmpty(psw_once)) {
                    ToastUtils.showToast(RegisterActivity.this, "请再次输入密码！");
                    return;
                }
                if (!psw.equals(psw_once)) {
                    ToastUtils.showToast(RegisterActivity.this, "两次输入的密码竟然不一样呢！");
                    return;
                }
                if (phone.length() != 11) {
                    ToastUtils.showToast(RegisterActivity.this, "您输入的手机号长度不对哦！");
                    return;
                }
                showProgressDialog(false,"注册中。。。");
                Map<String,String> map = new HashMap<>();
                map.put("userphone",phone);
                map.put("password",psw);
                MyHttpUtils.postHttpMessage(AppUrl.appregdituser, map, ZhuCeBean.class, new RequestCallBack<ZhuCeBean>() {
                    @Override
                    public void requestSuccess(ZhuCeBean json) {
                        if (json.getCode()==200) {
                            ToastUtils.showToast(RegisterActivity.this, "注册成功，用该账号登录去吧！");
                            finish();
                        }
                        ToastUtils.showToast(RegisterActivity.this, ""+json.getMsg());
                        stopProgressDialog();
                    }

                    @Override
                    public void requestError(String errorMsg, int errorType) {
                        stopProgressDialog();
                    }
                });

                break;
        }

    }
}
