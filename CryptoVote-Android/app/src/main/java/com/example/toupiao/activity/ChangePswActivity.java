package com.example.toupiao.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.toupiao.R;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.PrefUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChangePswActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.etOldPsw)
    EditText etOldPsw;
    @BindView(R.id.etPsw)
    EditText etPsw;
    @BindView(R.id.etPswOnce)
    EditText etPswOnce;


    @Override
    protected int initContentView() {
        return R.layout.activity_change_psw;
    }

    public static void forward(Context context) {
        Intent intent = new Intent(App.context, ChangePswActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("修改密码");
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ll_common_back, R.id.btChange})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
                finish();
                break;
            case R.id.btChange:
                change();
                break;
        }
    }

    private void change() {
        String oldPsw = etOldPsw.getText().toString();
        String psw = etPsw.getText().toString();
        String psw_once = etPswOnce.getText().toString();
        if (TextUtils.isEmpty(oldPsw)) {
            ToastUtils.showToast(ChangePswActivity.this, "请输入f旧密码！");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            ToastUtils.showToast(ChangePswActivity.this, "请输入新密码！");
            return;
        }
        if (TextUtils.isEmpty(psw_once)) {
            ToastUtils.showToast(ChangePswActivity.this, "请再次输入新密码！");
            return;
        }
        if (!psw.equals(psw_once)) {
            ToastUtils.showToast(ChangePswActivity.this, "两次输入的新密码竟然不一样呢！");
            return;
        }
        if (oldPsw.equals(psw)) {
            ToastUtils.showToast(ChangePswActivity.this, "您也没改密码呀！");
            return;
        }
//        //TODO 此处替换为你的旧密码和新密码
        changeInfo("password", psw);

    }

    private void changeInfo(String key, String value) {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "" + PrefUtils.getParameter("user_id"));
        map.put(key, value);
        showProgressDialog(false);
        MyHttpUtils.postHttpMessage(AppUrl.updateappuser, map, InfoBean.class, new RequestCallBack<InfoBean>() {
            @Override
            public void requestSuccess(InfoBean json) {
                if (json.getCode() == 200) {
                    finish();
                }
                ToastUtils.showToast(ChangePswActivity.this, json.getMsg());
                stopProgressDialog();
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
                stopProgressDialog();
            }
        });

    }
}
