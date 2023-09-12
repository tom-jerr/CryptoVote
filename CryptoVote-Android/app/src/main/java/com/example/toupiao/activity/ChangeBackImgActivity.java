package com.example.toupiao.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.toupiao.R;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.bean.TokenBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.view.GlideEngine;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.utils.PhotoUtils;
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
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ChangeBackImgActivity extends BaseActivity {

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static int REQUEST_PERMISSION_CODE = 1;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_change_beijing);
//
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
//            }
//        }
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            for (int i = 0; i < permissions.length; i++) {
                Log.i("MainActivity", "申请的权限为：" + permissions[i] + ",申请结果：" + grantResults[i]);
            }
        }
    }

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    @BindView(R.id.ivBeiJing)
    ImageView ivBeiJing;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri cropImageUri;
    private Bitmap bitmap;
    private UploadManager uploadManager;

    @Override
    protected int initContentView() {
        return R.layout.activity_change_beijing;
    }

    public static void forward(Context context) {
        Intent intent = new Intent(App.context, ChangeBackImgActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("背景图");
        uploadManager = new UploadManager();
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {
        getInfo();
    }

    private void getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "" + PrefUtils.getParameter("user_id"));
        showProgressDialog(false);
        MyHttpUtils.postHttpMessage(AppUrl.seletcinfo, map, InfoBean.class, new RequestCallBack<InfoBean>() {
            @Override
            public void requestSuccess(InfoBean json) {
                if (json.getCode() == 200) {
                    if (!TextUtils.isEmpty(json.getContent().getBack_url())) {
                        Picasso.with(ChangeBackImgActivity.this).load(json.getContent().getBack_url()).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(ivBeiJing);
                    }
                }
                stopProgressDialog();
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
                stopProgressDialog();
            }
        });
    }

    @OnClick({R.id.ll_common_back, R.id.btChange})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
                finish();
                break;
            case R.id.btChange:
                autoObtainStoragePermission(ivBeiJing);
                break;
        }
    }

    /**
     * 自动获取sdk权限
     */
    private void autoObtainStoragePermission(ImageView customShapeImageView) {
        if (ContextCompat.checkSelfPermission(ChangeBackImgActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("FFFF");
            ActivityCompat.requestPermissions(ChangeBackImgActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            //添加凭证图片
            System.out.println("SSSS");
            PictureSelector.create(ChangeBackImgActivity.this)
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
                            bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, ChangeBackImgActivity.this);
                            String key_logo = "pic_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
                            if (bitmap != null) {
                                customShapeImageView.setImageBitmap(bitmap);
                                getTokenFromService(key_logo);

                            }
                        }

                        @Override
                        public void onCancel() {

                        }
                    });
        }

    }

    private void getTokenFromService(final String key) {
        Map<String, String> map = new HashMap<>();
        map.put("key", key);
        MyHttpUtils.postHttpMessage(AppUrl.TOUXIANG, map, TokenBean.class, new RequestCallBack<TokenBean>() {
            @Override
            public void requestSuccess(TokenBean json) {
                if (200 == json.getCode()) {
                    uploadManager.put(fileCropUri, key, "" + json.getContent().getToken(), new UpCompletionHandler() {
                        @Override
                        public void complete(String key, ResponseInfo info, JSONObject response) {
                            if (info.isOK()) {
                                Map<String, String> map = new HashMap<>();
                                map.put("user_id", "" + PrefUtils.getParameter("user_id"));
                                map.put("back_url", AppUrl.QiNiu+key);
                                showProgressDialog(false);
                                MyHttpUtils.postHttpMessage(AppUrl.updateappuser, map, InfoBean.class, new RequestCallBack<InfoBean>() {
                                    @Override
                                    public void requestSuccess(InfoBean json) {
                                        if (json.getCode() == 200) {
                                            finish();
                                        }
                                        ToastUtils.showToast(ChangeBackImgActivity.this, json.getMsg());
                                        stopProgressDialog();
                                    }

                                    @Override
                                    public void requestError(String errorMsg, int errorType) {
                                        stopProgressDialog();
                                    }
                                });

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
