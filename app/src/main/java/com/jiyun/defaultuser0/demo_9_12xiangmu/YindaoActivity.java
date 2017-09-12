package com.jiyun.defaultuser0.demo_9_12xiangmu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YindaoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbutton;
    private TextView textView;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yindao);
        initView();
        //启动页
        //啊实打实大苏打似的a
    }

    private void initView() {
        mbutton = (Button) findViewById(R.id.mbutton);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        mbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbutton:

                break;
        }
    }
}
