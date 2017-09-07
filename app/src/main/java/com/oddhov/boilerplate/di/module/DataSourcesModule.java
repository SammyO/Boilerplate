package com.oddhov.boilerplate.di.module;

import com.oddhov.boilerplate.data.DataSources;
import com.oddhov.boilerplate.data.DataSourcesImpl;
import com.oddhov.boilerplate.data.local.LocalDataSource;
import com.oddhov.boilerplate.data.network.NetworkDataSource;
import com.oddhov.boilerplate.di.annotation.LocalScope;
import com.oddhov.boilerplate.di.annotation.NetworkScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sammy on 07/09/17.
 */

@Module(includes = {NetworkDataSourceModule.class, LocalDataSourceModule.class})
public class DataSourcesModule {
    @Singleton
    @Provides
    DataSources provideDataSource(@LocalScope LocalDataSource localDataSource,
                                  @NetworkScope NetworkDataSource networkDataSource) {
        return new DataSourcesImpl(localDataSource, networkDataSource);
    }
}
