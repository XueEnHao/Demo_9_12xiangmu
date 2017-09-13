package com.jiyun.defaultuser0.demo_9_12xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Zhuce1Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_fan;
    private EditText et_yan;
    private Button btn_yan;
    private Button btn_ti;
    private Handler handler = new Handler();
    private int i = 60;
    private String yan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce1);
        initView();
    }

    private void initView() {
        iv_fan = (ImageView) findViewById(R.id.iv_fan);
        et_yan = (EditText) findViewById(R.id.et_yan);
        btn_yan = (Button) findViewById(R.id.btn_yan);
        btn_ti = (Button) findViewById(R.id.btn_ti);

        btn_yan.setOnClickListener(this);
        btn_ti.setOnClickListener(this);
        iv_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yan:
                dao();
                int x;//定义两变量
                Random ne=new Random();//实例化一个random的对象ne
                x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999
                yan = x+"";//输出
                Toast.makeText(this, yan, Toast.LENGTH_SHORT).show();
                et_yan.setText(yan);
                break;
            case R.id.btn_ti:
                startActivity(new Intent(Zhuce1Activity.this,ShouyeActivity.class));
                break;
        }
    }
    private void dao() {
        if (i != 0) {
            btn_yan.setText(""+i--);
            btn_yan.setClickable(false);
            btn_yan.setBackgroundResource(R.drawable.shapeint2);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dao();
                }
            },1000);
        }else {
            btn_yan.setClickable(true);
            btn_yan.setBackgroundResource(R.drawable.shapeint);
            btn_yan.setText("获取验证码");
            i = 60;
        }
    }
    private void submit() {
        // validate
        String yan = et_yan.getText().toString().trim();
        if (TextUtils.isEmpty(yan)) {
            Toast.makeText(this, "验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
