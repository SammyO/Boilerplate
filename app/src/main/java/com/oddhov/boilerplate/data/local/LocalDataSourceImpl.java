package com.oddhov.boilerplate.data.local;

import android.content.Context;

import com.oddhov.boilerplate.data.models.realm.DummyData;

import javax.inject.Inject;

import io.realm.Realm;

/**
 * Created by sammy on 06/09/17.
 */

public class LocalDataSourceImpl implements LocalDataSource {
    //region Fields
    private Realm mRealm;
    //endregion

    @Inject
    public LocalDataSourceImpl(Realm realm) {
        this.mRealm = realm;
    }

    @Override
    public void saveData(DummyData dummyData) {

    }

    @Override
    public DummyData getData() {
        return new DummyData();
    }

}
