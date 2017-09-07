package com.oddhov.boilerplate.data.network;

import com.oddhov.boilerplate.data.models.realm.DummyData;

import io.reactivex.Single;

/**
 * Created by sammy on 06/09/17.
 */

public interface RemoteDataSource {
    Single<DummyData> getDataFromServer();
}
