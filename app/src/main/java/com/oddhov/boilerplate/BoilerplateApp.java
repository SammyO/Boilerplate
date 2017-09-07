package com.oddhov.boilerplate;

import android.app.Application;

import com.oddhov.boilerplate.di.component.ApplicationComponent;
import com.oddhov.boilerplate.di.component.DaggerApplicationComponent;
import com.oddhov.boilerplate.di.module.ApplicationModule;
import com.oddhov.boilerplate.di.module.DataSourcesModule;
import com.oddhov.boilerplate.di.module.LocalDataSourceModule;
import com.oddhov.boilerplate.di.module.NetworkDataSourceModule;

import io.realm.Realm;

/**
 * Created by sammy on 07/09/17.
 */

public class BoilerplateApp extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        initializeDependencies();
    }

    private void initializeDependencies() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataSourcesModule(new DataSourcesModule())
                .networkDataSourceModule(new NetworkDataSourceModule())
                .localDataSourceModule(new LocalDataSourceModule())
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }

}
