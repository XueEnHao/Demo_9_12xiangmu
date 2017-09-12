package com.jiyun.defaultuser0.demo_9_12xiangmu;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.Log;

import java.util.Map;

public class ShouyeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Ed_name;
    private EditText Ed_pass;
    private Button btn_submit;
    private ImageView im_qq;
    private ImageView im_weibo;
    private TextView tv_zhao;
    private TextView tv_zhu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);

        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                         String permissions[], int[] grantResults) {


    }

    private void initView() {
        Ed_name = (EditText) findViewById(R.id.Ed_name);
        Ed_pass = (EditText) findViewById(R.id.Ed_pass);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        im_qq = (ImageView) findViewById(R.id.im_qq);
        //第三方登陆qq
        im_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UMShareAPI umShareAPI = UMShareAPI.get(ShouyeActivity.this);
                umShareAPI.getPlatformInfo(ShouyeActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        String iconurl = map.get("iconurl");
                        Log.e("TAG",iconurl);
//                        Intent intent = new Intent(Two_Activity.this, Three_Activity.class);
//                        intent.putExtra("iconurl", iconurl);
//                        startActivity(intent);

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Log.e("TAG",throwable.toString());
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
            }
        });

        im_weibo = (ImageView) findViewById(R.id.im_weibo);
        tv_zhao = (TextView) findViewById(R.id.tv_zhao);
        tv_zhu = (TextView) findViewById(R.id.tv_zhu);

        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:

                break;


            case R.id.tv_zhao:
                Intent intent=new Intent(ShouyeActivity.this,ZhaohuiActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_zhu:
                Intent intent1=new Intent(ShouyeActivity.this,Zhuce1Activity.class);
                startActivity(intent1);
                break;
        }
    }

    private void submit() {
        // validate
        String name = Ed_name.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "请输入手机号或邮箱", Toast.LENGTH_SHORT).show();
            return;
        }

        String pass = Ed_pass.getText().toString().trim();
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
