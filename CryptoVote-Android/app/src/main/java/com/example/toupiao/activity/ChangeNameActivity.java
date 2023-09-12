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


public class ChangeNameActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.tvTitle)
    TextView tvTitle1;
    @BindView(R.id.etContent)
    EditText etContent;
    private String type;

    @Override
    protected int initContentView() {
        return R.layout.activity_change_name;
    }

    public static void forward(Context context, String type) {
        Intent intent = new Intent(App.context, ChangeNameActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        type = getIntent().getStringExtra("type");
        getInfo();
        if ("0".equals(type)) {
            tvTitle.setText("修改昵称");
            tvTitle1.setText("昵称");
            etContent.setHint("请输入昵称");

        } else {
            tvTitle.setText("修改简介");
            tvTitle1.setText("简介");
            etContent.setHint("请输入简介");
        }

    }

    private void getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "" + PrefUtils.getParameter("user_id"));
        MyHttpUtils.postHttpMessage(AppUrl.seletcinfo, map, InfoBean.class, new RequestCallBack<InfoBean>() {
            @Override
            public void requestSuccess(InfoBean json) {
                if (json.getCode() == 200) {
                    if ("0".equals(type)) {
                        if (!TextUtils.isEmpty(json.getContent().getNickname())) {
                            etContent.setText("" + json.getContent().getNickname());
                        } else {
                            etContent.setText("" + json.getContent().getUserphone());
                        }
                    } else {
                        if (!TextUtils.isEmpty(json.getContent().getIntroduce())) {
                            etContent.setText("" + json.getContent().getIntroduce());
                        }
                    }
                }

            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
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
                ToastUtils.showToast(ChangeNameActivity.this, json.getMsg());
                stopProgressDialog();
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
                stopProgressDialog();
            }
        });

    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ll_common_back, R.id.btSubmit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
                finish();
                break;
            case R.id.btSubmit:
                String nickname = etContent.getText().toString();
                if ("0".equals(type)) {
                    if (TextUtils.isEmpty(nickname)) {
                        ToastUtils.showToast(ChangeNameActivity.this, "请填写昵称！");
                        return;
                    }
                    changeInfo("nickname", nickname);
                } else {
                    if (TextUtils.isEmpty(nickname)) {
                        ToastUtils.showToast(ChangeNameActivity.this, "请填写简介！");
                        return;
                    }
                    changeInfo("introduce", nickname);
                }
                break;
        }
    }
}
