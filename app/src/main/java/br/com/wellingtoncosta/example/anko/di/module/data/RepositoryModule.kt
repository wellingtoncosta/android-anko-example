package br.com.wellingtoncosta.example.anko.di.module.data

import br.com.wellingtoncosta.example.anko.data.datasource.ContactsDatasource
import br.com.wellingtoncosta.example.anko.data.repository.ContactRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Wellington Costa on 24/06/18.
 */
@Module(includes = [DataSourceModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideContactRepository(
            contactRemoteDataSource: ContactsDatasource.Remote
    ) = ContactRepository(contactRemoteDataSource)

}