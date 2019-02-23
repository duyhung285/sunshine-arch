package com.example.android.sunshine;


import android.content.Context;

import com.facebook.stetho.Stetho;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setupStetho(this);
    }

    private void setupStetho(Context context) {
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(context)
        );

        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }
}
