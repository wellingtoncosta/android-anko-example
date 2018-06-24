package br.com.wellingtoncosta.example.anko.di.module.data

import br.com.wellingtoncosta.example.anko.data.datasource.ContactsDatasource
import br.com.wellingtoncosta.example.anko.data.datasource.remote.ContactRemoteDataSource
import dagger.Binds
import dagger.Module

/**
 * @author Wellington Costa on 24/06/18.
 */
@Module
interface DataSourceModule {

    @Binds
    fun bindContactRemoteDataSource(imp: ContactRemoteDataSource): ContactsDatasource.Remote

}