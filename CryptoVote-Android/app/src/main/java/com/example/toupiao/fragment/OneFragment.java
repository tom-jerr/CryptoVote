package com.example.toupiao.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.toupiao.R;
import com.example.toupiao.activity.RoomContentActivity;
import com.example.toupiao.adapter.ZBInfoListAdapter;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseFragment;
import com.example.toupiao.bean.AddRoomBean;
import com.example.toupiao.bean.CommonBackBean;
import com.example.toupiao.bean.RoomListBean;
import com.example.toupiao.bean.TokenBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.MyEvent;
import com.example.toupiao.utils.PhotoUtils;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.view.CustomShapeImageView;
import com.example.toupiao.view.GlideEngine;
import com.example.toupiao.view.ImageCropEngine;
import com.gyf.immersionbar.ImmersionBar;
import com.luck.picture.lib.basic.PictureSelector;
import com.luck.picture.lib.config.SelectMimeType;
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
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OneFragment extends BaseFragment {
    @BindView(R.id.iv_common_back)
    ImageView ivCommonBack;
    @BindView(R.id.ll_common_back)
    LinearLayout llCommonBack;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView_TuiJian;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_send)
    ImageView iv_send;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ZBInfoListAdapter zbInfoListAdapter;
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri cropImageUri;
    private Bitmap bitmap;
    private UploadManager uploadManager;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private String key_logo = "";

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View setInitView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one, null);
        ButterKnife.bind(OneFragment.this, view);
        initView();
        getInfo();
        initLitener();

        return view;
    }

    public void showSave() {
        View view = LayoutInflater.from(App.context).inflate(R.layout.layout_add_toupiao, null);
        CustomShapeImageView ivHead = view.findViewById(R.id.ivHead);
        EditText etName = view.findViewById(R.id.etName);
        EditText etPsw = view.findViewById(R.id.etPsw);
        Button btAdd = view.findViewById(R.id.btAdd);
        final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity(), R.style.Dialog).setView(view);
        final AlertDialog dialog01 = builder.show();
        //设置弹窗的宽度，高度
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
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
                String psw = etPsw.getText().toString().trim();
                if (TextUtils.isEmpty(name)) {
                    showToastShort("请输入房间标题");
                    return;
                }
                if (TextUtils.isEmpty(psw)) {
                    showToastShort("请输入房间密码");
                    return;
                }
                /*if (TextUtils.isEmpty(key_logo)) {
                    showToastShort("请选择房间封面");
                    return;
                }*/
                Map<String, String> map = new HashMap<>();
                map.put("userId", PrefUtils.getParameter("user_id"));
                map.put("roomPass", psw);
                map.put("roomTitle", name);
                map.put("roomUrl", AppUrl.QiNiu + key_logo);
                MyHttpUtils.postHttpMessage(AppUrl.addroom, map, CommonBackBean.class, new RequestCallBack<CommonBackBean>() {
                    @Override
                    public void requestSuccess(CommonBackBean json) {
                        if (200 == json.getCode()) {
                            key_logo = "";
                            getInfo();
                            dialog01.dismiss();
                        }
                        ToastUtils.showToast(getActivity(), json.getMsg());
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

    public void joinSave(RoomListBean.ContentBean contentBean) {
        View view = LayoutInflater.from(App.context).inflate(R.layout.layout_join_toupiao, null);
        EditText etPsw = view.findViewById(R.id.etPsw);
        Button btAdd = view.findViewById(R.id.btAdd);
        final androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity(), R.style.Dialog).setView(view);
        final AlertDialog dialog01 = builder.show();
        //设置弹窗的宽度，高度
        DisplayMetrics dm = new DisplayMetrics();
        //获取屏幕信息
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeigh = dm.heightPixels;
        WindowManager.LayoutParams params =
                dialog01.getWindow().getAttributes();//获取dialog信息
        params.width = screenWidth - 200;
        params.height = screenHeigh / 2;
        dialog01.getWindow().setAttributes(params);//设置大小

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String psw = etPsw.getText().toString().trim();
                if (TextUtils.isEmpty(psw)) {
                    showToastShort("请输入房间密码");
                    return;
                }
                Map<String,String>map = new HashMap<>();
                map.put("roomId",""+contentBean.getRoomId());
                map.put("roomPass",""+psw);
                map.put("userId",""+contentBean.getUserId());
                MyHttpUtils.postHttpMessage(AppUrl.addinroom, map, AddRoomBean.class, new RequestCallBack<AddRoomBean>() {
                    @Override
                    public void requestSuccess(AddRoomBean json) {
                        if (200==json.getCode()) {
                            RoomContentActivity.forward(getActivity(), "2", ""+contentBean.getRoomId(),contentBean);
                            dialog01.dismiss();
                            ToastUtils.showToast(getActivity(),json.getMsg());
                        }else {
                            ToastUtils.showToast(getActivity(),"密码错误");
                        }

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

    private void initLitener() {
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
                    joinSave(contentBean);

                }

            }
        });
        iv_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
showSave();
//                RoomContentActivity.forward(getActivity(), "1", "");
            }
        });
    }

    private void initView() {
        ivCommonBack.setVisibility(View.GONE);
        uploadManager = new UploadManager();
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        zbInfoListAdapter = new ZBInfoListAdapter(R.layout.item_zb_info_layout);
        recyclerView_TuiJian.setLayoutManager(new LinearLayoutManager(getActivity()));
        zbInfoListAdapter.setEmptyView(LayoutInflater.from(getActivity()).inflate(R.layout.empty_layout, null));
        recyclerView_TuiJian.setAdapter(zbInfoListAdapter);
        tvTitle.setText("投票大厅");
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public void onEventMainThread(MyEvent event) {
        String msg = event.getMsg();
        if (TextUtils.equals("刷新投票列表", msg)) {
            getInfo();
        }


    }


    private void getInfo() {
        Map<String, String> map = new HashMap<>();
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

    /**
     * 自动获取sdk权限
     */
    private void autoObtainStoragePermission(CustomShapeImageView customShapeImageView) {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            //添加凭证图片
            PictureSelector.create(getActivity())
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
                            bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, getActivity());
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
                                                        Picasso.with(getActivity()).load(AppUrl.QiNiu + key).into(customShapeImageView);

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
}
