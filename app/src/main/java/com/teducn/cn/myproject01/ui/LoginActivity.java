package com.teducn.cn.myproject01.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;

import com.teducn.cn.myproject01.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tarena on 2017/6/8.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_account_password)
    Button button_account_password;
    @BindView(R.id.imageButton_Back)
    ImageButton imageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imageButton_Back)
    public void onViewClicked() {
        finish();
    }

    @OnClick(R.id.btn_account_password)
    public void onClicked() {
        Intent intent = new Intent(this, AccountLoginActivity.class);
        startActivity(intent);
    }
}
