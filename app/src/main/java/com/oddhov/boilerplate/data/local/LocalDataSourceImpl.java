package com.oddhov.boilerplate.data.local;

import android.content.Context;

import com.oddhov.boilerplate.data.models.realm.DummyData;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by sammy on 06/09/17.
 */

public class LocalDataSourceImpl implements LocalDataSource {
    //region Fields
    private static final int DATABASE_VERSION = 1;
    private Context mContext;
    private Realm mRealm;
    //endregion

    @Inject
    public LocalDataSourceImpl(Context context) {
        this.mContext = context;
        setupRealm();
    }

    @Override
    public void saveData(DummyData dummyData) {

    }

    @Override
    public DummyData getData() {
        return new DummyData();
    }


    //region Helper Methods
    private void setupRealm() {
        Realm.init(mContext);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(DATABASE_VERSION)
                .migration(new BoilerplateRealmMigration())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        mRealm =  Realm.getDefaultInstance();
    }
    //endregion
}
