package com.jalen.volleydemo;

import android.app.Application;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

/**
 * Created by Jojo on 2015/1/27.
 */
public class VolleyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化leanCloud
        AVOSCloud.initialize(
                this,
                "9k1odzvo487o1o8w15llqix9i2jbg14kvmrn6wa9d9kxdbkd",
                "fyi4230hg33idm1gp5qw7wspmk5re7rox6m7b7f61e289zyq");

        // 测试leanCloud导入是否成功
        AVObject testObject = new AVObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();

        AVObject gameScore = new AVObject("GameScore");
        gameScore.put("score", 1200);
        gameScore.put("playerName", "steve");
        gameScore.put("level", 10);
        try {
            gameScore.save();
        } catch (AVException e) {
            // e.getMessage() 捕获的异常信息
            e.printStackTrace();
        }


    }
}
