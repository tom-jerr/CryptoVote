package com.example.toupiao.adapter;

import android.text.TextUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.bean.HomeListBean;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.bean.RoomListBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.view.CustomShapeImageView;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZBInfoListAdapter extends BaseQuickAdapter<RoomListBean.ContentBean, BaseViewHolder> {

    public ZBInfoListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, RoomListBean.ContentBean item) {
        CustomShapeImageView ivHead = helper.getView(R.id.ivHead);
        TextView tvState = helper.getView(R.id.tvState);
        helper.setText(R.id.tvName,item.getRoomTitle());
        helper.setText(R.id.tvTime,"创建于："+item.getRoomtime());
        String close_ticket = item.getClose_ticket();
        if (!TextUtils.isEmpty(close_ticket)) {
            if ("0".equals(close_ticket)) {
                tvState.setText("进行中");
                tvState.setTextColor(mContext.getResources().getColor(R.color.red));
            }else {
                tvState.setText("已结束");
                tvState.setTextColor(mContext.getResources().getColor(R.color.gray3));
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("user_id", "" + item.getUserId());
        MyHttpUtils.postHttpMessage(AppUrl.seletcinfo, map, InfoBean.class, new RequestCallBack<InfoBean>() {
            @Override
            public void requestSuccess(InfoBean json) {
                if (json.getCode() == 200) {
                    if (!TextUtils.isEmpty(json.getContent().getNickname())) {
                        helper.setText(R.id.tvPeople,"创建者："+json.getContent().getNickname());
                    }else {
                        helper.setText(R.id.tvPeople,"创建者：神秘人");
                    }


                }

            }

            @Override
            public void requestError(String errorMsg, int errorType) {

            }
        });
            Picasso.with(mContext).load(item.getRoomUrl()).placeholder(R.mipmap.bg_zhanweitu)
                    .error(R.mipmap.bg_zhanweitu).into(ivHead);

    }
}
