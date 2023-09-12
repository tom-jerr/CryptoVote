package com.example.toupiao.adapter;

import android.text.TextUtils;
import android.widget.CheckBox;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.example.toupiao.base.AppUrl;
import com.example.toupiao.bean.InfoBean;
import com.example.toupiao.bean.RemarkListBean;
import com.example.toupiao.myhttp.MyHttpUtils;
import com.example.toupiao.myhttp.RequestCallBack;
import com.example.toupiao.view.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class ZiXunContentCommentAdapter extends BaseQuickAdapter<RemarkListBean.ContentBean, BaseViewHolder> {
    public ZiXunContentCommentAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, RemarkListBean.ContentBean item) {
        CircleImageView ivHead = helper.getView(R.id.ivHead);
        CheckBox cbLike = helper.getView(R.id.cbLike);
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
        if (item.getDianzan().equals("0")) {
            cbLike.setChecked(false);
        }else {
            cbLike.setChecked(true);
        }
        helper.setText(R.id.tvContent,item.getComment_info());
        helper.setText(R.id.tvTime,item.getCom_systime());
        helper.addOnClickListener(R.id.cbLike);

    }
}
