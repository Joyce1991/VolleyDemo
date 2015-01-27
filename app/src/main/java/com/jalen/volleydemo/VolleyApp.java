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
                "lgt86x4nela39ip0w9sual23hwubpgp1d5qhcl7k3jbkl9hv",
                "ujnmqih2olni35gb7774ocd4jdosvbd0s725gdzjhoaqpx4z");

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
