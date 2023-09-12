package com.example.toupiao.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.bean.TokenBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.R;
import com.example.toupiao.base.App;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.PhotoUtils;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.view.CustomShapeImageView;
import com.example.toupiao.view.GlideEngine;
import com.example.toupiao.view.ImageCropEngine;
import com.example.toupiao.view.OptionsPickerView;
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


public class EditInfoActivity extends BaseActivity {


    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    private static final int STORAGE_PERMISSIONS_REQUEST_CODE = 0x04;
    @BindView(R.id.ivHead)
    CustomShapeImageView ivHead;
    @BindView(R.id.tvNickName)
    TextView tvNickName;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.tvSex)
    TextView tvSex;
    @BindView(R.id.tvJianJie)
    TextView tvJianJie;
    @BindView(R.id.tvId)
    TextView tvId;
    private File fileCropUri = new File(Environment.getExternalStorageDirectory().getPath() + "/crop_photo.jpg");
    private Uri cropImageUri;
    private Bitmap bitmap;
    private UploadManager uploadManager;

    @Override
    protected int initContentView() {
        return R.layout.activity_edit_info;
    }

    public static void forward(Context context) {
        Intent intent = new Intent(App.context, EditInfoActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        ImmersionBar.with(this).titleBar(rlTitle).statusBarDarkFont(true).init();
        tvTitle.setText("编辑资料");
        uploadManager = new UploadManager();
    }

    @Override
    protected void initListener() {
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getInfo();

    }

    private void getInfo() {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "" + PrefUtils.getParameter("user_id"));
        MyHttpUtils.postHttpMessage(AppUrl.seletcinfo, map, InfoBean.class, new RequestCallBack<InfoBean>() {
            @Override
            public void requestSuccess(InfoBean json) {
                if (json.getCode() == 200) {
                    if (!TextUtils.isEmpty(json.getContent().getHead_url())) {
                        Picasso.with(EditInfoActivity.this).load(json.getContent().getHead_url()).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(ivHead);
                    }
                    if (!TextUtils.isEmpty(json.getContent().getNickname())) {
                        tvNickName.setText("" + json.getContent().getNickname());
                    }
                    if (!TextUtils.isEmpty(json.getContent().getSex())) {
                        tvSex.setText("" + json.getContent().getSex());
                    }
                    if (!TextUtils.isEmpty(json.getContent().getAge())) {
                        tvAge.setText("" + json.getContent().getAge());
                    }
                    if (!TextUtils.isEmpty("" + json.getContent().getUser_id())) {
                        tvId.setText("" + json.getContent().getUser_id());
                    }
                    if (!TextUtils.isEmpty(json.getContent().getIntroduce())) {
                        tvJianJie.setText("" + json.getContent().getIntroduce());
                    } else {
                        tvJianJie.setText("还没有写简介呢～～～");
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

                }
                ToastUtils.showToast(EditInfoActivity.this, json.getMsg());
                stopProgressDialog();
            }

            @Override
            public void requestError(String errorMsg, int errorType) {
                stopProgressDialog();
            }
        });

    }

    private void chooseSex() {
        ArrayList<String> bookList = new ArrayList<>();
        bookList.add("女");
        bookList.add("男");
        bookList.add("待定");
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String s = bookList.get(options1);
                tvSex.setText(s);
                changeInfo("sex", s);
            }
        })
                .setTitleText("选择性别")
                .setDividerColor(getResources().getColor(R.color.gray3))
                .setCancelColor(getResources().getColor(R.color._888888))
                .setSubmitColor(getResources().getColor(R.color.red))
                .setTextColorCenter(getResources().getColor(R.color.red)) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();
        pvOptions.setPicker(bookList);
        pvOptions.setSelectOptions();
        pvOptions.show();
    }

    private void chooseAge() {
        ArrayList<String> bookList = new ArrayList<>();
        for (int i = 18; i < 40; i++) {
            bookList.add("" + i);
        }
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                String s = bookList.get(options1);
                tvAge.setText(s);
                changeInfo("age", s);
            }
        })
                .setTitleText("选择年龄")
                .setDividerColor(getResources().getColor(R.color.gray3))
                .setCancelColor(getResources().getColor(R.color._888888))
                .setSubmitColor(getResources().getColor(R.color.red))
                .setTextColorCenter(getResources().getColor(R.color.red)) //设置选中项文字颜色
                .setContentTextSize(20)
                .build();
        pvOptions.setPicker(bookList);
        pvOptions.setSelectOptions();
        pvOptions.show();
    }

    /**
     * 自动获取sdk权限
     */
    private void autoObtainStoragePermission(ImageView customShapeImageView) {
        if (ContextCompat.checkSelfPermission(EditInfoActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EditInfoActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST_CODE);
        } else {
            //添加凭证图片
            PictureSelector.create(EditInfoActivity.this)
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
                            bitmap = PhotoUtils.getBitmapFromUri(cropImageUri, EditInfoActivity.this);
                            String key_logo = "pic_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
                            if (bitmap != null) {

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
                                Picasso.with(EditInfoActivity.this).load(AppUrl.QiNiu + key).into(ivHead);
                                changeInfo("head_url", AppUrl.QiNiu + key);
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

    @OnClick({R.id.ll_common_back, R.id.ivHead, R.id.rlNickName, R.id.rlJianJie, R.id.rlChooseSex, R.id.rlChooseAge})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_common_back:
                finish();
                break;
            case R.id.ivHead:
                autoObtainStoragePermission(ivHead);
                break;
            case R.id.rlChooseSex:
                chooseSex();
                break;
            case R.id.rlChooseAge:
                chooseAge();
                break;
            case R.id.rlNickName:
                ChangeNameActivity.forward(EditInfoActivity.this, "0");
                break;
            case R.id.rlJianJie:
                ChangeNameActivity.forward(EditInfoActivity.this, "1");
                break;
        }
    }
}
