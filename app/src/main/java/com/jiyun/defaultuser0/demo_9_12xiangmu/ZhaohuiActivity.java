package com.jiyun.defaultuser0.demo_9_12xiangmu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ZhaohuiActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar tb_bar;
    private EditText editText;
    private EditText editText2;
    private Button mbutton;
    private EditText password;
    private Button zhaohui;
    private TimeCount time;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhaohui);
        initView();

    }
    private void initView() {
        tb_bar = (Toolbar) findViewById(R.id.tb_bar);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        mbutton = (Button) findViewById(R.id.mbutton);
        password = (EditText) findViewById(R.id.password);
        zhaohui = (Button) findViewById(R.id.zhaohui);

        tb_bar.setNavigationIcon(R.drawable.u34);
        tb_bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mbutton.setOnClickListener(this);
        zhaohui.setOnClickListener(this);

        editText.addTextChangedListener(new SearchWather(editText ));
    }

    class SearchWather implements TextWatcher {


        //监听改变的文本框
        private EditText editText;

        /**
         * 构造函数
         */
        public SearchWather(EditText editText){
            this.editText = editText;
        }

        @Override
        public void onTextChanged(CharSequence ss, int start, int before, int count) {
            String editable = editText.getText().toString();
            String str = stringFilter(editable.toString());
            if(!editable.equals(str)){
                editText.setText(str);
                //设置新的光标所在位置
                editText.setSelection(str.length());
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,int after) {

        }

    }


    public static String stringFilter(String str)throws PatternSyntaxException {
        // 只允许字母和数字
        String   regEx  =  "^\\d{12}$";
        Pattern p   =   Pattern.compile(regEx);
        Matcher m   =   p.matcher(str);
        boolean matches = m.matches();
        return   m.replaceAll("").trim();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mbutton:

                i = (int) ((Math.random() * 9 + 1) * 100000);
                Toast.makeText(this, "验证码是:"+i, Toast.LENGTH_SHORT).show();
                editText2.setText(""+i);
                time = new TimeCount(60000, 1000);

                time.start();




                break;
            case R.id.zhaohui:
                submit();
                String name = editText.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences settings  = getSharedPreferences("xnh",0);
                SharedPreferences.Editor edit = settings.edit();
                edit.clear();
                edit.putString("name",name);
                edit.putString("pass",pass);
                edit.commit();
                Intent intent = new Intent(ZhaohuiActivity.this, ShouyeActivity.class);
                startActivity(intent);

                break;
        }
    }

    class TimeCount extends CountDownTimer {

        /**
         * 构造方法
         *
         * @param millisInFuture    总倒计时长 毫秒
         * @param countDownInterval 倒计时间隔
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

        @Override
        public void onTick(long millisUntilFinished) {
            mbutton.setEnabled(false);
            mbutton.setText(millisUntilFinished / 1000 + "秒");
        }

        @Override
        public void onFinish() {// 计时结束
            mbutton.setEnabled(true);
            mbutton.setText("重新获取");

        }
    }

    private void submit() {
        // validate
        String editTextString = editText.getText().toString().trim();
        if (TextUtils.isEmpty(editTextString)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }

        String editText2String = editText2.getText().toString().trim();
        if (TextUtils.isEmpty(editText2String)) {
            Toast.makeText(this, "验证码", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = password.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

}
