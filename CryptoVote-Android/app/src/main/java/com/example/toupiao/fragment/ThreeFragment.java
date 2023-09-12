package com.example.toupiao.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.toupiao.R;
import com.example.toupiao.activity.AboutActivity;
import com.example.toupiao.activity.ChangeBackImgActivity;
import com.example.toupiao.activity.EditInfoActivity;
import com.example.toupiao.activity.FeedBackActivity;
import com.example.toupiao.activity.MySubmitActivity;
import com.example.toupiao.activity.SettingActivity;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.base.BaseFragment;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.DialogNewUtils;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.utils.ShareActionUtils;
import com.example.toupiao.view.CustomShapeImageView;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThreeFragment extends BaseFragment {
    @BindView(R.id.ciBeiJng)
    CustomShapeImageView ciBeiJng;
    @BindView(R.id.ivHead)
    CustomShapeImageView ivHead;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvJianJie)
    TextView tvJianJie;

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected View setInitView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_three, null);
        ButterKnife.bind(ThreeFragment.this, view);
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getInfo();
    }

    private void initData() {

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
                        Picasso.with(getActivity()).load(json.getContent().getHead_url()).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(ivHead);
                    }
                    if (!TextUtils.isEmpty(json.getContent().getBack_url())) {
                        Picasso.with(getActivity()).load(json.getContent().getBack_url()).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(ciBeiJng);
                    }
                    if (!TextUtils.isEmpty(json.getContent().getNickname())) {
                        tvName.setText(""+json.getContent().getNickname());
                    }else {
                        tvName.setText(""+json.getContent().getUserphone());
                    }
                    if (!TextUtils.isEmpty(json.getContent().getIntroduce())) {
                        tvJianJie.setText(""+json.getContent().getIntroduce());
                    }else {
                        tvJianJie.setText("还没有写简介呢～～～");
                    }


                }

            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
    }

    @OnClick({R.id.ciBeiJng, R.id.ivHead, R.id.rlFaBu, R.id.rlYiJian, R.id.rlSetting, R.id.rlCall, R.id.rlShare, R.id.rlAbout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ciBeiJng:
                ChangeBackImgActivity.forward(getActivity());
                break;
            case R.id.ivHead:
                EditInfoActivity.forward(getActivity());
                break;
            case R.id.rlFaBu:
                MySubmitActivity.forward(getActivity());
                break;
            case R.id.rlYiJian:
                FeedBackActivity.forward(getActivity());
                break;
            case R.id.rlSetting:
                SettingActivity.forward(getActivity());
                break;
            case R.id.rlCall:
                new DialogNewUtils.Builder(getActivity(), false, false, "是否拨打客服电话？",
                        "拨打", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri telUri = Uri.parse("tel:" + "1234567890");
                        Intent intent = new Intent(Intent.ACTION_DIAL, telUri);
                        startActivity(intent);
                        dialogInterface.dismiss();
                    }
                }, "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create(0).show();
                break;
            case R.id.rlShare:
                //分享
                ShareActionUtils.show(getActivity(), getActivity());
                break;
            case R.id.rlAbout:
                AboutActivity.forward(getActivity());
                break;
        }
    }


}
