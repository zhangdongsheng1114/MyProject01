package com.teducn.cn.myproject01.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.teducn.cn.myproject01.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountLoginActivity extends Activity {

    @BindView(R.id.remember_pass)
    CheckBox checkBox_remeber;
    @BindView(R.id.imageButton_Back)
    ImageButton imageButtonBack;
    @BindView(R.id.editText_account)
    EditText editTextAccount;
    @BindView(R.id.editText_password)
    EditText editTextPassword;
    @BindView(R.id.forgot_password)
    Button forgotPassword;
    @BindView(R.id.button_logon)
    Button buttonLogon;
    @BindView(R.id.btn_phone)
    Button btnPhone;
    @BindView(R.id.imageButton)
    ImageButton imageButton;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_login);
        ButterKnife.bind(this);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        checkBox_remeber = (CheckBox) findViewById(R.id.remember_pass);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            // 将账号和密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            editTextAccount.setText(account);
            editTextPassword.setText(password);
            checkBox_remeber.setChecked(true);
        }
    }

    @OnClick({R.id.imageButton_Back, R.id.forgot_password, R.id.button_logon, R.id.btn_phone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imageButton_Back:
                finish();
                break;
            case R.id.forgot_password:
                break;
            case R.id.button_logon:
                String account = editTextAccount.getText().toString();
                String password = editTextPassword.getText().toString();
                if ("admin".equals(account) && "111111".equals(password)) {
                    editor = pref.edit();
                    if (checkBox_remeber.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_phone:
                break;
        }
    }
}
