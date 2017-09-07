package com.oddhov.boilerplate.di.module;

import com.oddhov.boilerplate.data.network.ApiService;
import com.oddhov.boilerplate.data.network.NetworkDataSource;
import com.oddhov.boilerplate.data.network.NetworkDataSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sammy on 07/09/17.
 */

@Module
public class NetworkDataSourceModule {

    @Singleton
    @Provides
    NetworkDataSource provideNetworkDataSource(ApiService apiService) {
        return new NetworkDataSourceImpl(apiService);
    }

}
