package com.codepath.parstagram;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Sv0SffqKNe8eUiB5VipKMbEeyAgOlhzkrRthmdMS")
                .clientKey("KuHwcs56mEGHECKtxH4j0cuDsr19AVV39JEG6P6N")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
