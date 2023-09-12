package com.example.toupiao.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.bean.HouXuanListBean;
import com.example.toupiao.bean.TouPiaoListBean;
import com.example.toupiao.utils.ScreenUtils;
import com.example.toupiao.view.CircleImageView;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TouPiaoListAdapter extends BaseQuickAdapter<TouPiaoListBean.ContentBean, BaseViewHolder> {
    public TouPiaoListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, TouPiaoListBean.ContentBean item) {
        CircleImageView ivHead = helper.getView(R.id.ivHead);
        helper.setText(R.id.tvName, ""+item.getNickname());
        helper.setText(R.id.tvTime, ""+item.getToupiaotime());
        if (!TextUtils.isEmpty(item.getHead_url())) {
            Picasso.with(mContext).load(item.getHead_url()).error(R.mipmap.bg_zhanweitu).placeholder(R.mipmap.bg_zhanweitu).into(ivHead);
        }
        if (!TextUtils.isEmpty(item.getNickname())) {
            helper.setText(R.id.tvName, ""+item.getNickname());
        }else {
            helper.setText(R.id.tvName, "神秘人");
        }


    }
}
