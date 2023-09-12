package com.example.toupiao.adapter;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.bean.ResultBean;
import com.example.toupiao.bean.TouPiaoListBean;
import com.example.toupiao.view.CircleImageView;
import com.squareup.picasso.Picasso;

public class ResultListAdapter extends BaseQuickAdapter<ResultBean.ContentBean, BaseViewHolder>
{

    public ResultListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ResultBean.ContentBean item) {
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

    }

}