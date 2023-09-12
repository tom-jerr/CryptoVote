package com.example.toupiao.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.toupiao.R;
//import com.example.zhengbing.adapter.CommentListAdapter;
import com.example.toupiao.adapter.ZBInfoListAdapter;
import com.example.toupiao.adapter.ZiXunListAdapter;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.AddZiXunBean;
import com.example.toupiao.bean.RoomListBean;
import com.example.toupiao.bean.ZiXunBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.DialogNewUtils;
import com.example.toupiao.utils.MyEvent;
import com.example.toupiao.utils.PrefUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MySubmitActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ZBInfoListAdapter zbInfoListAdapter;

    @Override
    protected int initContentView() {
        return R.layout.activity_recyclerview_common;
    }

    public static void forward(Context context) {
        Intent intent = new Intent(App.context, MySubmitActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("我的创建");
        zbInfoListAdapter = new ZBInfoListAdapter(R.layout.item_zb_info_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        zbInfoListAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_layout, null));
        recyclerView.setAdapter(zbInfoListAdapter);
    }

    @Override
    protected void initListener() {


        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getInfo();
                refreshLayout.finishRefresh();
            }
        });
        zbInfoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                RoomListBean.ContentBean contentBean = (RoomListBean.ContentBean) adapter.getItem(position);
                if (contentBean != null) {
                    int zixun_id = contentBean.getRoomId();
                    RoomContentActivity.forward(MySubmitActivity.this, "1","" + zixun_id,contentBean);
                }

            }
        });
    }

    private void getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("user_id",PrefUtils.getParameter("user_id"));
        MyHttpUtils.postHttpMessage(AppUrl.selectpictureurl, map, RoomListBean.class, new RequestCallBack<RoomListBean>() {
            @Override
            public void requestSuccess(RoomListBean json) {
                if (json.getCode() == 200) {
                    zbInfoListAdapter.setNewData(json.getContent());
                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
            }
        });

    }
    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getInfo();
    }


    @OnClick(R.id.ll_common_back)
    public void onclick() {
        finish();
    }

}
