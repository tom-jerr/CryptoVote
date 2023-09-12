package com.example.toupiao.adapter;

import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.bean.IntroBean;
import com.example.toupiao.bean.ResultBean;
import com.example.toupiao.view.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IntroListAdapter extends BaseQuickAdapter<IntroBean.ContentBean, BaseViewHolder> {

    public IntroListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, IntroBean.ContentBean item) {
        CircleImageView ivHead = helper.getView(R.id.ivHead);
        helper.setText(R.id.tvName, ""+item.getHx_name());
        if (!TextUtils.isEmpty(item.getHx_url())) {
            Picasso.with(mContext).load(item.getHx_url()).error(R.mipmap.bg_zhanweitu).placeholder(R.mipmap.bg_zhanweitu).into(ivHead);
        }
        if (!TextUtils.isEmpty(item.getHx_name())) {
            helper.setText(R.id.tvName, ""+item.getHx_name());
        }else {
            helper.setText(R.id.tvName, "未命名");
        }
//        TextView introName = helper.getView(R.id.introName);
        helper.setText(R.id.introName, ""+item.getHx_intro());
    }
}
