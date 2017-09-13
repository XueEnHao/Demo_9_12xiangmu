package com.jiyun.defaultuser0.demo_9_12xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ZhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_fan;
    private EditText et_shou;
    private EditText et_mi;
    private Button btn_zhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouye);
        initView();
    }

    private void initView() {
        iv_fan = (ImageView) findViewById(R.id.iv_fan);
        et_shou = (EditText) findViewById(R.id.et_shou);
        et_mi = (EditText) findViewById(R.id.et_mi);
        btn_zhu = (Button) findViewById(R.id.btn_zhu);

        btn_zhu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_zhu:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String shou = et_shou.getText().toString().trim();
        if (TextUtils.isEmpty(shou)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String mi = et_mi.getText().toString().trim();
        if (TextUtils.isEmpty(mi)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
        startActivity(new Intent(ZhuceActivity.this,Zhuce1Activity.class));

    }
}
