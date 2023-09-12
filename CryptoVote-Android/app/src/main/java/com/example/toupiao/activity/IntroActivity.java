package com.example.toupiao.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toupiao.R;
import com.example.toupiao.adapter.IntroListAdapter;
import com.example.toupiao.adapter.ResultListAdapter;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.IntroBean;
import com.example.toupiao.bean.ResultBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.AppUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntroActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.introView)
    RecyclerView introView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private IntroListAdapter introListAdapter;

    @Override
    protected int initContentView() {
        return R.layout.activity_intro;
    }
    public static void forward(Context context, String id) {
        Intent intent = new Intent(App.context, IntroActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("候选人简介");

        introView.setLayoutManager(new LinearLayoutManager(this));
        introListAdapter = new IntroListAdapter(R.layout.item_hxpeople_intro);
        introListAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_layout, null));
        introView.setAdapter(introListAdapter);
    }

    @Override
    protected void initListener() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getResult();
                refreshLayout.finishRefresh();
            }
        });
    }

    @Override
    protected void initData() {
        getResult();
    }
    // 获取候选人结果
    private void getResult() {
        Map<String, String> map = new HashMap<>();
        map.put("room_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.introlist, map, IntroBean.class, new RequestCallBack<IntroBean>() {
            @Override
            public void requestSuccess(IntroBean json) {
                if (200 == json.getCode()) {
                    introListAdapter.setNewData(json.getContent());
                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }
    @OnClick({R.id.ll_common_back, R.id.iv_common_back})
    public void onClick() {
        finish();
    }
}
