package com.android;

import android.app.Activity;
import android.com.myapplication.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BootPageActivity extends Activity {

    Animation animation;

    @BindView(R.id.imageView)
    ImageView imageView;

    private static final long DELAY = 3000;
    private TimerTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boot_page);
        ButterKnife.bind(this);
        initView();
        final Intent localIntent=new Intent(this,MainActivity.class);//你要转向的Activity
        Timer timer=new Timer();
        TimerTask tast=new TimerTask() {
            @Override
            public void run(){
                startActivity(localIntent);//执行
                finish();
            }
        };
        timer.schedule(tast,DELAY);//10秒后

    }

    private void initView(){
        animation=AnimationUtils.loadAnimation(this,R.anim.start);
        imageView.startAnimation(animation);
    }
}
