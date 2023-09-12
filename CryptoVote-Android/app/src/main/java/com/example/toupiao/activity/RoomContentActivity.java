package com.example.toupiao.activity;

import java.io.*;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.adapter.ResultListAdapter;
import com.example.toupiao.adapter.TouPiaoListAdapter;
import com.example.toupiao.algorithm.JsonCompression;
import com.example.toupiao.algorithm.SerializeUtil;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.bean.AddRoomBean;
import com.example.toupiao.bean.CommonBackBean;
import com.example.toupiao.bean.HouXuanListBean;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.bean.ResultBean;
import com.example.toupiao.bean.RoomListBean;
import com.example.toupiao.bean.TokenBean;
import com.example.toupiao.bean.TouPiaoListBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.algorithm.BloomFilterXor.BloomFilterXor;
import com.example.toupiao.utils.DialogNewUtils;
import com.example.toupiao.utils.MyEvent;
import com.example.toupiao.utils.PhotoUtils;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.utils.ScreenUtils;
import com.example.toupiao.view.CircleImageView;
import com.example.toupiao.view.GlideEngine;
import com.example.toupiao.view.ImageCropEngine;
import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;
import com.luck.picture.lib.utils.ToastUtils;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RoomContentActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvCommonTitle;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvShaiXuan)
    TextView tvShaiXuan;
    @BindView(R.id.tvAdd)
    TextView tvAdd;
    @BindView(R.id.btNote)
    Button btNote;
    @BindView(R.id.yzNote)
    Button yzNote;
    @BindView(R.id.resultNote)
    Button resNote;
    @BindView(R.id.btEnd)
    Button btEnd;
    @BindView(R.id.switch_dan_duo)
    Switch switch_dan_duo;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
//    @BindView(R.id.recyclerView2)
//    RecyclerView recyclerView2;
    private static String key_logo = "";
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ciHead)
    CircleImageView ciHead;
//    @BindView(R.id.ivHead)
//    CircleImageView ivHead;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri cropImageUri;
    private Bitmap bitmap;
    private UploadManager uploadManager;
    private TouPiaoListAdapter touPiaoListAdapter;
    private ResultListAdapter resultListAdapter;
    private HouXuanDuoListAdapter houXuanDuoListAdapter;
    private String dan_id = "";
    private List<String> duo_id;
    private List<HouXuanListBean.ContentBean> duo_id_list;
    private String type = "0";
    private String roomId;
    private String close_ticket;
    // 是否已经结束投票
    private boolean Flag = false;

    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;

    @Override
    protected int initContentView() {
        return R.layout.activity_room_content;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        uploadManager = new UploadManager();
        tvCommonTitle.setText("房间详情");
        String type = getIntent().getStringExtra("type");
        //1是创建者自己进入
        RoomListBean.ContentBean contentBean = (RoomListBean.ContentBean) getIntent().getSerializableExtra("content");
        roomId = getIntent().getStringExtra("id");
        close_ticket = contentBean.getClose_ticket();
        if ("1".equals(close_ticket)) {
            btNote.setVisibility(View.GONE);
            yzNote.setVisibility(View.VISIBLE);
            resNote.setVisibility(View.VISIBLE);
        }else {
            btNote.setVisibility(View.VISIBLE);
            yzNote.setVisibility(View.GONE);
            resNote.setVisibility(View.GONE);
        }
        if ("1".equals(type)) {
            tvShaiXuan.setText("删除");
            tvAdd.setVisibility(View.VISIBLE);
            switch_dan_duo.setVisibility(View.VISIBLE);
            btEnd.setVisibility(View.VISIBLE);
        } else {
            tvAdd.setVisibility(View.GONE);
            switch_dan_duo.setVisibility(View.GONE);
            btEnd.setVisibility(View.GONE);
            tvShaiXuan.setText("");
        }
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
//        touPiaoListAdapter = new TouPiaoListAdapter(R.layout.item_toupiaozhe_layout);
//        touPiaoListAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_layout, null));
//        recyclerView2.setAdapter(touPiaoListAdapter);
        // 结果显示
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
//        resultListAdapter = new ResultListAdapter(R.layout.item_toupiaozhe_layout);
//        resultListAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_layout, null));
//        recyclerView2.setAdapter(resultListAdapter);

        // 候选者显示
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, ScreenUtils.dip2px(this, 10), false));
        houXuanDuoListAdapter = new HouXuanDuoListAdapter(R.layout.item_houxuanzhe_layout);
        houXuanDuoListAdapter.setEmptyView(LayoutInflater.from(this).inflate(R.layout.empty_layout, null));
        recyclerView.setAdapter(houXuanDuoListAdapter);

    }

    public static void forward(Context context, String type, String id, RoomListBean.ContentBean contentBean) {
        Intent intent = new Intent(App.context, RoomContentActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("id", id);
        intent.putExtra("content", contentBean);
        context.startActivity(intent);
    }


    @Override
    protected void initListener() {
        duo_id = new ArrayList<>();
        getHouXuanZhe();
        RoomListBean.ContentBean contentBean = (RoomListBean.ContentBean) getIntent().getSerializableExtra("content");
        if (contentBean != null) {
            Map<String, String> map = new HashMap<>();
            map.put("user_id", "" + contentBean.getUserId());
            MyHttpUtils.postHttpMessage(AppUrl.seletcinfo, map, InfoBean.class, new RequestCallBack<InfoBean>() {
                @Override
                public void requestSuccess(InfoBean json) {
                    if (json.getCode() == 200) {
                        if (!TextUtils.isEmpty(json.getContent().getNickname())) {
                            tvName.setText("创建者：" + json.getContent().getNickname());
                        } else {
                            tvName.setText("创建者：神秘人");
                        }
                    }
                }

                @Override
                public void requestError(String errorMsg, int errorType) {

                }
            });
            Picasso.with(RoomContentActivity.this).load(contentBean.getRoomUrl()).placeholder(R.mipmap.bg_zhanweitu)
                    .error(R.mipmap.bg_zhanweitu).into(ciHead);
            String one_all = contentBean.getOne_all();
            if (!TextUtils.isEmpty(one_all)) {
                if ("1".equals(one_all)) {
                    dan_id = "";
                    type = "0";
                    houXuanDuoListAdapter.clear();
                    switch_dan_duo.setChecked(false);
                } else if ("2".equals(one_all)) {

                    houXuanDuoListAdapter.clear();
                    type = "1";
                    switch_dan_duo.setChecked(true);
                } else {
                    dan_id = "";
                    type = "0";
                    houXuanDuoListAdapter.clear();
                    switch_dan_duo.setChecked(false);
                }
            }
        }
        switch_dan_duo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    duo_id = new ArrayList<>();
                    houXuanDuoListAdapter.clear();
                    type = "1";
                    dan_duo("2");
                    ToastUtils.showToast(RoomContentActivity.this, "多选");
                } else {
                    dan_id = "";
                    type = "0";
                    dan_duo("1");
                    houXuanDuoListAdapter.clear();
                    ToastUtils.showToast(RoomContentActivity.this, "单选");
                }
            }
        });
        houXuanDuoListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HouXuanListBean.ContentBean item = (HouXuanListBean.ContentBean) adapter.getItem(position);
                if ("0".equals(type)) {
                    houXuanDuoListAdapter.singleChoice(position, item);
                } else {
                    houXuanDuoListAdapter.multipleChoice(position, item);
                }


            }
        });
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getHouXuanZhe();
                refreshLayout.finishRefresh();
            }
        });
    }

    // 获取候选人结果
    private void getResult() {
        Map<String, String> map = new HashMap<>();
        map.put("room_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.resultlist, map, ResultBean.class, new RequestCallBack<ResultBean>() {
            @Override
            public void requestSuccess(ResultBean json) {
                if (200 == json.getCode()) {
                    resultListAdapter.setNewData(json.getContent());
                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }
    // 获取投票人
    private void getTouPiaoZhe() {
        //获取投票者列表
        Map<String, String> map = new HashMap<>();
        map.put("room_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.showtpulist, map, TouPiaoListBean.class, new RequestCallBack<TouPiaoListBean>() {
            @Override
            public void requestSuccess(TouPiaoListBean json) {
                if (200 == json.getCode()) {
                    touPiaoListAdapter.setNewData(json.getContent());
                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });

    }

    // 单选或是多选候选人
    private void dan_duo(String type) {
        Map<String, String> map = new HashMap<>();
        map.put("roomId", getIntent().getStringExtra("id"));
        map.put("one_all", type);
        MyHttpUtils.postHttpMessage(AppUrl.updateroom, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
            @Override
            public void requestSuccess(CommonBackBean json) {
                if (200 == json.getCode()) {
                }
                ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }

    @Override
    protected void initData() {
        if(Flag) {
//            getResult();
            btEnd.setVisibility(View.GONE);

        }
    }

    private void getHouXuanZhe() {
        Map<String, String> map = new HashMap<>();
        map.put("room_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.hxpeoplelist, map, HouXuanListBean.class, new RequestCallBack<HouXuanListBean>() {
            @Override
            public void requestSuccess(HouXuanListBean json) {
                if (200 == json.getCode()) {
                    duo_id_list = json.getContent();
                    houXuanDuoListAdapter.setNewData(duo_id_list);
                }
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }

    @OnClick({R.id.ll_common_back, R.id.iv_common_back,R.id.introNote, R.id.tvAdd, R.id.btNote, R.id.yzNote, R.id.resultNote, R.id.tvShaiXuan, R.id.btEnd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
            case R.id.iv_common_back:
                finish();
                break;
            case R.id.tvAdd:
                showSave();
                break;
            case R.id.btNote:
                // 确认弹窗
                new DialogNewUtils.Builder(RoomContentActivity.this, false, false, "是否确认投票？",
                        "确认提交", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        note();
                        try {
                            BloomFilterCollect();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 提示投票成功弹窗
                        new DialogNewUtils.Builder(RoomContentActivity.this,  "投票成功",
                                "知道了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create(0).show();
                        btNote.setVisibility(View.GONE);
                        dialogInterface.dismiss();
                    }
                }, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create(0).show();
                break;

            // 简介
            case R.id.introNote:
                IntroActivity.forward(RoomContentActivity.this, roomId);
                break;
            // 验证弹窗
            case R.id.yzNote:
                if(close_ticket.equals("1")) {
                    yznote();
                } else  {
                    new DialogNewUtils.Builder(RoomContentActivity.this, "投票未结束，不能验证",
                            "知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create(0).show();
                }
                break;
            // 显示结果
            case R.id.resultNote:
                if(close_ticket.equals("1")) {
                    ResultActivity.forward(RoomContentActivity.this, roomId);
                } else {
                    new DialogNewUtils.Builder(RoomContentActivity.this, "投票未结束，不能显示结果",
                            "知道了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create(0).show();
                }
                break;
            case R.id.btEnd:
                end();
//                getResult();
//                showResult();
                break;
            case R.id.tvShaiXuan:
                delete();
                break;
        }
    }

    //  验证投票
    private void yznote() {
        new DialogNewUtils.Builder(RoomContentActivity.this, false, false, "是否确定验证？",
                "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 显示结果
                ResultActivity.forward(RoomContentActivity.this, roomId);
                dialogInterface.dismiss();
            }
        }, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create(0).show();
    }

    // 结束
    private void end() {
        Map<String, String> map = new HashMap<>();
        map.put("roomId", getIntent().getStringExtra("id"));
        map.put("close_ticket", "1");
        MyHttpUtils.postHttpMessage(AppUrl.updateroom, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
            @Override
            public void requestSuccess(CommonBackBean json) {
                if (200 == json.getCode()) {
                    finish();
                    EventBus.getDefault().post(new MyEvent("刷新投票列表"));
                }
                ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }

    // TODO:混淆布隆过滤器进行传输
    private void BloomFilterCollect() throws Exception {
        int size = 100;
        int k = 3;
        BloomFilterXor filter = new BloomFilterXor(size, k);

        filter.addElement("1", "Tom");

        filter.fillInAll();


        String objString = new Gson().toJson(filter);
        String str = JsonCompression.compress(objString);
        Map<String, String> map = new HashMap<>();
        map.put("stream", str);
        map.put("room_id", getIntent().getStringExtra("id"));
        MyHttpUtils.postHttpMessage(AppUrl.gbf, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
            @Override
            public void requestError(String errorMsg, int errorType) {

            }

            @Override
            public void requestSuccess(CommonBackBean json) {
                ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
            }
        });

    }
    private void note() {
        if ("0".equals(type)) {
            if (TextUtils.isEmpty(dan_id)) {
                ToastUtils.showToast(RoomContentActivity.this, "请选择候选者");
                return;
            }
            Log.e("toupiaoshuju", dan_id);
            Map<String, String> map = new HashMap<>();
            map.put("tp_user_id", PrefUtils.getParameter("user_id"));
            map.put("hx_people_id", dan_id);
            map.put("room_id", getIntent().getStringExtra("id"));
            MyHttpUtils.postHttpMessage(AppUrl.addtoupiao, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
                @Override
                public void requestSuccess(CommonBackBean json) {
                    if (200 == json.getCode()) {
                        EventBus.getDefault().post(new MyEvent("刷新投票列表"));
//                        getTouPiaoZhe();
                        if(close_ticket.equals("1")) {
//                            getResult();
//                            showResult();
                            btEnd.setVisibility(View.GONE);
                        }
                        getHouXuanZhe();
                    }
                    ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
                }

                @Override
                public void requestError(String errorMsg, int errorType) {

                }
            });
        } else {
            if (duo_id.size()==0) {
                ToastUtils.showToast(RoomContentActivity.this, "请选择候选者");
                return;
            }
            Map<Integer, String> pictureMap = new HashMap<>();  //图片上传的顺序
            Gson gson = new Gson();
            String s = gson.toJson(duo_id);
            for (int i = 0; i < duo_id.size(); i++) {
                pictureMap.put(i, ""+duo_id.get(i));
            }
            Log.e("toupiaoshuju", s);
            Iterator<Integer> iterator = pictureMap.keySet().iterator();
            String multi_graph = "";
            while (iterator.hasNext()) {
                multi_graph += pictureMap.get(iterator.next()) + ",";
            }
            String substring = multi_graph.substring(0, multi_graph.length() - 1);
            Map<String, String> map = new HashMap<>();
            map.put("tp_user_id", PrefUtils.getParameter("user_id"));
            map.put("hx_people_id", substring);
            map.put("room_id", getIntent().getStringExtra("id"));
            MyHttpUtils.postHttpMessage(AppUrl.addtoupiao, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
                @Override
                public void requestSuccess(CommonBackBean json) {
                    if (200 == json.getCode()) {
                        EventBus.getDefault().post(new MyEvent("刷新投票列表"));
//                        getTouPiaoZhe();
                        if(close_ticket.equals("1")) {
//                            getResult();
//                            showResult();
                            btEnd.setVisibility(View.GONE);
                        }
                        getHouXuanZhe();
                    }
                    ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
                }

                @Override
                public void requestError(String errorMsg, int errorType) {

                }
            });

        }
    }

    private void delete() {
        new DialogNewUtils.Builder(RoomContentActivity.this, false, false, "是否删除该房间？",
                "删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Map<String, String> map = new HashMap<>();
                map.put("roomId", getIntent().getStringExtra("id"));
                map.put("is_del", "1");
                MyHttpUtils.postHttpMessage(AppUrl.updateroom, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
                    @Override
                    public void requestSuccess(CommonBackBean json) {
                        if (200 == json.getCode()) {
                            EventBus.getDefault().post(new MyEvent("刷新投票列表"));
                            dialogInterface.dismiss();
                            finish();

                        }
                        ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
                    }

                    @Override
                    public void requestError(String errorMsg, int errorType) {

                    }
                });

            }
        }, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create(0).show();
    }

    // 弹窗显示结果
    public void showResult() {
        new DialogNewUtils.Builder(RoomContentActivity.this, "显示结果如下",
                "确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getResult();
                dialogInterface.dismiss();
            }
        }).create(0).show();
    }


    public void showSave() {
        View view = LayoutInflater.from(App.context).inflate(R.layout.layout_add_houxuanren, null);
        CircleImageView ivHead = view.findViewById(R.id.ivHead);
        EditText etName = view.findViewById(R.id.etName);
        EditText introName = view.findViewById(R.id.introName);
        Button btAdd = view.findViewById(R.id.btAdd);
        final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(RoomContentActivity.this, R.style.Dialog).setView(view);
        final AlertDialog dialog01 = builder.show();
        //设置弹窗的宽度，高度
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeigh = dm.heightPixels;
        WindowManager.LayoutParams params =
                dialog01.getWindow().getAttributes();//获取dialog信息
        params.width = screenWidth - 200;
        params.height = screenHeigh / 2;
        dialog01.getWindow().setAttributes(params);//设置大小
        ivHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoObtainStoragePermission(ivHead);
            }
        });
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String intro = introName.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    showToastShort("请输入候选人姓名");
                    return;
                }
                if (TextUtils.isEmpty(intro)) {
                    showToastShort("注意：简介为空");
                }
                if (TextUtils.isEmpty(key_logo)) {
                    showToastShort("请选择候选人头像");
//                    return;
                }
                Map<String, String> map = new HashMap<>();
                map.put("hx_url", AppUrl.QiNiu + key_logo);
                map.put("hx_name", name);
                map.put("hx_intro", intro);
                map.put("room_id", getIntent().getStringExtra("id"));
//                map.put("roomUrl", AppUrl.QiNiu + key_logo);
                MyHttpUtils.postHttpMessage(AppUrl.addhxpeople, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
                    @Override
                    public void requestSuccess(CommonBackBean json) {
                        if (200 == json.getCode()) {
                            key_logo = "";
                            getHouXuanZhe();
                            dialog01.dismiss();
                        }
                        ToastUtils.showToast(RoomContentActivity.this, json.getMsg());
                    }

                    @Override
                    public void requestError(String errorMsg, int errorType) {

                    }
                });
            }
        });
        //点击空白处弹框不消失
        dialog01.setCancelable(true);
        dialog01.show();
    }


    /**
     * 自动获取sdk权限
     */
    private void autoObtainStoragePermission(CircleImageView customShapeImageView) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            //添加凭证图片
            PictureSelector.create(this)
                    .openGallery(SelectMimeType.ofImage())
                    .setMaxSelectNum(1)// 最大图片选择数量 int
                    .setImageEngine(GlideEngine.createGlideEngine())
                    .setMinSelectNum(1)
                    .isDisplayCamera(true)// 是否裁剪 true or false
                    .setCropEngine(new ImageCropEngine()) // 是否裁剪 true or false
                    .forResult(new OnResultCallbackListener<LocalMedia>() {
                        @Override
                        public void onResult(ArrayList<LocalMedia> result) {
                            fileCropUri = new File(result.get(0).getCutPath());
                            cropImageUri = Uri.fromFile(fileCropUri);
                            bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, RoomContentActivity.this);
                            key_logo = "pic_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
                            if (bitmap != null) {
                                Map<String, String> map = new HashMap<>();
                                map.put("key", key_logo);
                                MyHttpUtils.postHttpMessage(AppUrl.TOUXIANG, map, TokenBean.class, new RequestCallBack<TokenBean>() {
                                    @Override
                                    public void requestSuccess(TokenBean json) {
                                        if (200 == json.getCode()) {
                                            uploadManager.put(fileCropUri, key_logo, "" + json.getContent().getToken(), new UpCompletionHandler() {
                                                @Override
                                                public void complete(String key, ResponseInfo info, JSONObject response) {
                                                    if (info.isOK()) {
                                                        Picasso.with(RoomContentActivity.this).load(AppUrl.QiNiu + key).into(customShapeImageView);

                                                    }
                                                }

                                            }, null);
                                        }
                                    }

                                    @Override
                                    public void requestError(String errorMsg, int errorType) {
                                    }
                                });

                            }
                        }

                        @Override
                        public void onCancel() {

                        }
                    });
        }

    }

    public class HouXuanDuoListAdapter extends BaseQuickAdapter<HouXuanListBean.ContentBean, BaseViewHolder> {

        private HashMap<Integer, HouXuanListBean.ContentBean> hashMap = new HashMap<>();//单选、多选数据保存

        public HouXuanDuoListAdapter(int layoutResId) {
            super(layoutResId);
        }

        public HashMap<Integer, HouXuanListBean.ContentBean> getHashMap() {
            return hashMap;
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, HouXuanListBean.ContentBean item) {
            CircleImageView ivHead = helper.getView(R.id.ivHead);
            CheckBox checkBox = helper.getView(R.id.checkBox);
            helper.setText(R.id.tvName, item.getHx_name());
//            helper.setText(R.id.tvNum, item.getHx_num_piao());
            if (!TextUtils.isEmpty(item.getHx_url())) {
                Picasso.with(mContext).load(item.getHx_url()).error(R.mipmap.bg_zhanweitu).placeholder(R.mipmap.bg_zhanweitu).into(ivHead);
            } else {

            }
            HouXuanListBean.ContentBean houXuanListBean = hashMap.get(helper.getLayoutPosition());
            if (houXuanListBean != null) {
                checkBox.setChecked(true);
            } else {
                checkBox.setChecked(false);
            }

        }

        //多选、复选删除、再次选择
        public void multipleChoice(int position, HouXuanListBean.ContentBean bean) {
            HouXuanListBean.ContentBean goodsBean = hashMap.get(position);
            if (null != goodsBean) {
                hashMap.remove(position);
                duo_id.remove("" + goodsBean.getId());
            } else {
                hashMap.put(position, bean);
                duo_id.add("" + bean.getId());
            }
            notifyDataSetChanged();
        }

        //单选 复选删除 再次选择
        public void singleChoice(int position, HouXuanListBean.ContentBean goodsBean) {
            hashMap.clear();
            hashMap.put(position, goodsBean);
            dan_id = "" + goodsBean.getId();
            notifyDataSetChanged();
        }

        public void clear() {
            hashMap.clear();
            notifyDataSetChanged();
        }
    }
}
