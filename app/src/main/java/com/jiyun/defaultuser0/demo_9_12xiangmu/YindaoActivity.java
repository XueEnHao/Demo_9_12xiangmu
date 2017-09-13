package com.jiyun.defaultuser0.demo_9_12xiangmu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.jiyun.defaultuser0.demo_9_12xiangmu.MyAdepter.MyPagerAdepter;

import java.util.ArrayList;

public class YindaoActivity extends AppCompatActivity{


    private ViewPager vp;
    private SharedPreferences.Editor edit;
    private SharedPreferences one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yindao);
        initView();
        one = getSharedPreferences("tow", YindaoActivity.MODE_PRIVATE);

        boolean name = one.getBoolean("name", true);
        if (name){
            View vp_item_one = LayoutInflater.from(YindaoActivity.this).inflate(R.layout.vp_item_one, null);
            View vp_item_tow = LayoutInflater.from(YindaoActivity.this).inflate(R.layout.vp_item_tow, null);
            View vp_item_three = LayoutInflater.from(YindaoActivity.this).inflate(R.layout.vp_item_three, null);
            View but_yindao = vp_item_three.findViewById(R.id.but_yindao);
            but_yindao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    edit = one.edit();
                    edit.putBoolean("name",false);
                    edit.commit();
                    Intent intent = new Intent(YindaoActivity.this, ShouyeActivity.class);
                    startActivity(intent);
                }
            });
            ArrayList<View> viewlist = new ArrayList<>();
            viewlist.add(vp_item_one);
            viewlist.add(vp_item_tow);
            viewlist.add(vp_item_three);

            MyPagerAdepter pagerAdepter = new MyPagerAdepter(YindaoActivity.this, viewlist);
            vp.setAdapter(pagerAdepter);
        }else{

            Intent intent = new Intent(YindaoActivity.this, ShouyeActivity.class);
            startActivity(intent);
        }



    }


    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
