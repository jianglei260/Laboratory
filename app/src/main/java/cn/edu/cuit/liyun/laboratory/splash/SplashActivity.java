package cn.edu.cuit.liyun.laboratory.splash;

import android.Manifest;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cn.edu.cuit.liyun.laboratory.R;
import cn.edu.cuit.liyun.laboratory.data.entity.User;
import cn.edu.cuit.liyun.laboratory.data.repository.UserRepository;
import cn.edu.cuit.liyun.laboratory.login.UserLoginActivity;
import cn.edu.cuit.liyun.laboratory.main.MainActivity;

public class SplashActivity extends AppCompatActivity {
    public static final int DELAY_TIME = 1000;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView = (TextView) findViewById(R.id.text);
        ObjectAnimator up = ObjectAnimator.ofFloat(textView, "translationY", 360, 0).setDuration(DELAY_TIME);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", 0, 1).setDuration(DELAY_TIME);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(alpha).with(up);
        animatorSet.start();
        checkPermission();
    }

    public void start() {
        realStart();
    }

    public void realStart() {
        Handler handler = new Handler();
        final User user = UserRepository.getInstance().getCurrentUser();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (user == null) {
                    Intent intent = new Intent(SplashActivity.this, UserLoginActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, DELAY_TIME + 500);
    }

    public void checkPermission() {
        int storagePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (storagePermission == PackageManager.PERMISSION_GRANTED) {
            start();
        } else {
            if (storagePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                return;
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        checkPermission();
    }
}
