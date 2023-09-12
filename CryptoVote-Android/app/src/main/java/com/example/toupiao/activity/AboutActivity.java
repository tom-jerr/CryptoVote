package com.example.toupiao.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.toupiao.R;
import com.example.toupiao.base.App;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.utils.AppUtils;
import com.gyf.immersionbar.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AboutActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tvVersion)
    TextView tvVersion;

    @Override
    protected int initContentView() {
        return R.layout.activity_about;
    }
    public static void forward(Context context) {
        Intent intent = new Intent(App.context, AboutActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("关于");
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {
        String versionName = AppUtils.getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            tvVersion.setText(versionName);
        }
    }

    @OnClick({R.id.ll_common_back, R.id.iv_common_back})
    public void onClick() {
        finish();
    }
}
