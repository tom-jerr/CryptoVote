package com.example.toupiao.adapter;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.toupiao.R;
import com.squareup.picasso.Picasso;

public class ImagesListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ImagesListAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        ImageView imageView = helper.getView(R.id.ivHead);
        Picasso.with(mContext).load(item).placeholder(R.mipmap.bg_zhanweitu)
                .error(R.mipmap.bg_zhanweitu).into(imageView);
    }
}
