package com.example.toupiao.activity;

import android.os.CountDownTimer;
import android.widget.RelativeLayout;

import com.example.toupiao.R;
import com.example.toupiao.base.BaseActivity;
import com.example.toupiao.utils.PrefUtils;
import com.example.toupiao.view.Couterdown;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;
    private CountDownTimer start;

    private void jump() {
        start = new Couterdown(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public String toClock(long millis) {
                return super.toClock(millis);
            }

            @Override
            public void onFinish() {

                    String isLogin = PrefUtils.getString(SplashActivity.this, "isLogin", "0");
                    if ("0".equals(isLogin)) {
                        LoginActivity.forward(SplashActivity.this);
                    } else {
                        MainActivity.forward(SplashActivity.this);
                    }


                finish();
            }

        }.start();
    }



    @Override
    protected void onDestroy() {
        if (start != null) {
            start.cancel();
        }
        super.onDestroy();
    }

    @Override
    protected int initContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
            jump();


    }
}
