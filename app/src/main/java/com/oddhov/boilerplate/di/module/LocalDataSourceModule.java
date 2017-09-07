package com.oddhov.boilerplate.di.module;

import android.content.Context;

import com.oddhov.boilerplate.data.local.BoilerplateRealmMigration;
import com.oddhov.boilerplate.data.local.LocalDataSource;
import com.oddhov.boilerplate.data.local.LocalDataSourceImpl;
import com.oddhov.boilerplate.di.annotation.LocalScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sammy on 07/09/17.
 */

@Module
public class LocalDataSourceModule {

    @Provides
    @Singleton
    LocalDataSource provideLocalDataSource(Realm realm) {
        return new LocalDataSourceImpl(realm);
    }

    @Provides
    @Singleton
    Realm provideRealm(RealmConfiguration config) {
        Realm.setDefaultConfiguration(config);
        return Realm.getDefaultInstance();
    }

    @Provides
    @Singleton
    RealmConfiguration provideRealmConfig(Context applicationContext) {
        Realm.init(applicationContext);

        return new RealmConfiguration.Builder()
                .schemaVersion(BoilerplateRealmMigration.DATABASE_VERSION)
                .migration(new BoilerplateRealmMigration())
                .build();
    }
}
