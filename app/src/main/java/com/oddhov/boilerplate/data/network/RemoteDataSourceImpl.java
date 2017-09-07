package com.oddhov.boilerplate.data.network;

import com.oddhov.boilerplate.data.models.realm.DummyData;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by sammy on 06/09/17.
 */

public class RemoteDataSourceImpl implements RemoteDataSource {
    //region Fields
    private ApiService mApiService;
    //endregion

    @Inject
    public RemoteDataSourceImpl(ApiService apiService) {
        this.mApiService = apiService;
    }

    @Override
    public Single<DummyData> getDataFromServer() {
        return mApiService.getData();
    }
}
