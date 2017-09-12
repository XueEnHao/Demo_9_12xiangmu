package com.jiyun.defaultuser0.demo_9_12xiangmu.Wxapi;

import android.content.Intent;

import com.umeng.socialize.UMShareAPI;
import com.umeng.weixin.callback.WXCallbackActivity;

/**
 * Created by Administrator on 2017/9/12.
 */

public class WXEntryActivity extends WXCallbackActivity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
