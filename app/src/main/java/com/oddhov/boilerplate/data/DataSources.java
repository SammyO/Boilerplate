package com.oddhov.boilerplate.data;

import com.oddhov.boilerplate.data.models.realm.DummyData;

import io.reactivex.Single;

/**
 * Created by sammy on 06/09/17.
 */

public interface DataSources {
    DummyData getStoredData();

    Single<DummyData> getDataFromServer();

    void storeData(DummyData dummyData);
}
