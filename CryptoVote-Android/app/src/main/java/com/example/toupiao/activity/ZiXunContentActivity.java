package com.example.toupiao.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.toupiao.R;
import com.example.toupiao.adapter.ImagesListAdapter;
import com.example.toupiao.adapter.ZiXunContentCommentAdapter;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.AddZiXunBean;
import com.example.toupiao.bean.RemarkListBean;
import com.example.toupiao.bean.ZiXunContentBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.utils.ScreenUtils;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.utils.ToastUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ZiXunContentActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.recyclerView_comment)
    RecyclerView recyclerView_comment;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.etPingLun)
    EditText etPingLun;
    private ImagesListAdapter imagesListAdapter;
    private ZiXunContentCommentAdapter ziXunContentCommentAdapter;

    @Override
    protected int initContentView() {
        return R.layout.activity_zixun_content;
    }

    public static void forward(Context context, String id) {
        Intent intent = new Intent(App.context, ZiXunContentActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("资讯详情");
        imagesListAdapter = new ImagesListAdapter(R.layout.item_zixun_img_layout);
        ziXunContentCommentAdapter = new ZiXunContentCommentAdapter(R.layout.item_comment_layout);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, ScreenUtils.dip2px(getApplicationContext(), 10), false));
        recyclerView_comment.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(imagesListAdapter);
        ziXunContentCommentAdapter.setEmptyView(LayoutInflater.from(ZiXunContentActivity.this).inflate(R.layout.empty_layout, null));
        recyclerView_comment.setAdapter(ziXunContentCommentAdapter);
    }

    @Override
    protected void initListener() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getRemarkInfo();
                refreshLayout.finishRefresh();
            }
        });
        ziXunContentCommentAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                RemarkListBean.ContentBean contentBean= (RemarkListBean.ContentBean) adapter.getItem(position);
                if (contentBean!=null) {
                    String dianzan = contentBean.getDianzan();
                    if ("0".equals(dianzan)) {
                        dianzan(""+contentBean.getComment_id(),"1");
                    }else {
                        dianzan(""+contentBean.getComment_id(),"0");
                    }
                }
            }
        });
    }

    @Override
    protected void initData() {
        getInfo();
        getRemarkInfo();

    }

    private void getInfo() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("zixun_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.zixun_info_map, map1, ZiXunContentBean.class, new RequestCallBack<ZiXunContentBean>() {
            @Override
            public void requestSuccess(ZiXunContentBean json) {
                if (json.getCode() == 200) {
                    tvTime.setText("发布时间：" + json.getContent().getZx_systime());
                    tvName.setText(json.getContent().getTitle());
                    tvContent.setText(json.getContent().getMark());
                    if (!TextUtils.isEmpty(json.getContent().getImg1())) {
                        List<String> result = Arrays.asList(json.getContent().getImg1().split(","));
                        if (result.size() > 0) {
                            imagesListAdapter.setNewData(result);
                        }
                    }
                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
            }
        });
    }
    private void getRemarkInfo() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("zixun_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.selectcommentinfo, map1, RemarkListBean.class, new RequestCallBack<RemarkListBean>() {
            @Override
            public void requestSuccess(RemarkListBean json) {
                if (json.getCode() == 200) {
                    List<RemarkListBean.ContentBean> content = json.getContent();
                    ziXunContentCommentAdapter.setNewData(content);

                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
            }
        });
    }

    @OnClick({R.id.ll_common_back, R.id.btPingLun})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
                finish();
                break;
            case R.id.btPingLun:
                pinglun();
                break;
        }
    }

    private void pinglun() {
        String content = etPingLun.getText().toString();
        if (TextUtils.isEmpty(content)) {
            ToastUtils.showToast(ZiXunContentActivity.this, "请输入评论内容");
            return;
        }
        Map<String, String> map = new HashMap<>();
        map.put("user_id", PrefUtils.getParameter("user_id"));
        map.put("zixun_id", getIntent().getStringExtra("id"));
        map.put("comment_info", content);
        map.put("dianzan", "0");
        MyHttpUtils.postHttpMessage(AppUrl.insertComment, map, AddZiXunBean.class, new RequestCallBack<AddZiXunBean>() {
            @Override
            public void requestSuccess(AddZiXunBean json) {
                if (json.getCode() == 200) {
                    etPingLun.setText("");
                    getRemarkInfo();

                }
                ToastUtils.showToast(ZiXunContentActivity.this, json.getMsg());
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }
    private void dianzan(String comment_id,String dianzan) {

        Map<String, String> map = new HashMap<>();
        map.put("comment_id", comment_id);
        map.put("dianzan", dianzan);
        MyHttpUtils.postHttpMessage(AppUrl.updatedianzan, map, AddZiXunBean.class, new RequestCallBack<AddZiXunBean>() {
            @Override
            public void requestSuccess(AddZiXunBean json) {
                if (json.getCode() == 200) {
                    getRemarkInfo();

                }
                ToastUtils.showToast(ZiXunContentActivity.this, json.getMsg());
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }
}
