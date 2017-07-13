package com.teducn.cn.myproject01.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.teducn.cn.myproject01.R;

/**
 * Created by tarena on 2017/5/25.
 */

public class WelcomeActivity extends AppCompatActivity {
    ImageView imageView_Welcome;
    Animation animation_Splash;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //初始化控件
        imageView_Welcome = (ImageView) findViewById(R.id.imageView_Welcome);
        //加载动画
        animation_Splash = AnimationUtils.loadAnimation(this, R.anim.splash);
        //把动画设置到控件上
        imageView_Welcome.setAnimation(animation_Splash);
        animation_Splash.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
