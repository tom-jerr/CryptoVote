package com.example.toupiao.adapter;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.bean.ZiXunBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.ScreenUtils;
import com.example.toupiao.view.CircleImageView;
import com.luck.picture.lib.decoration.GridSpacingItemDecoration;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZiXunListAdapter extends BaseQuickAdapter<ZiXunBean.ContentBean, BaseViewHolder> {
    public ZiXunListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ZiXunBean.ContentBean item) {
        CircleImageView ivHead = helper.getView(R.id.ivHead);
        ImagesListAdapter imagesListAdapter = new ImagesListAdapter(R.layout.item_zixun_img_layout);
        RecyclerView recyclerview = helper.getView(R.id.recyclerView);
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerview.addItemDecoration(new GridSpacingItemDecoration(3, ScreenUtils.dip2px(mContext, 10), false));
        recyclerview.setAdapter(imagesListAdapter);
        if (!TextUtils.isEmpty(item.getImg1())) {
            List<String> result = Arrays.asList(item.getImg1().split(","));
            if (result.size() > 0) {
                imagesListAdapter.setNewData(result);
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "" + item.getUser_id());
        MyHttpUtils.postHttpMessage(AppUrl.seletcinfo, map, InfoBean.class, new RequestCallBack<InfoBean>() {
            @Override
            public void requestSuccess(InfoBean json) {
                if (json.getCode() == 200) {
                    if (!TextUtils.isEmpty(json.getContent().getHead_url())) {
                        Picasso.with(mContext).load(json.getContent().getHead_url()).placeholder(R.mipmap.logo).error(R.mipmap.logo).into(ivHead);
                    }
                    helper.setText(R.id.tvName, TextUtils.isEmpty(json.getContent().getNickname()) ? json.getContent().getUserphone() : json.getContent().getNickname());
                }

            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
        helper.setText(R.id.tvTitle,item.getTitle());
        helper.setText(R.id.tvTime,""+item.getZx_systime()+"发布");

    }
}
