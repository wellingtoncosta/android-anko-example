package br.com.wellingtoncosta.example.anko.di.module.presentation

import br.com.wellingtoncosta.example.anko.presentation.ListContactsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Wellington Costa on 24/06/18.
 */
@Module(includes = [(ViewModelModule::class)])
interface ActivityModule {

    @ContributesAndroidInjector
    fun contributeListUsersActivity(): ListContactsActivity

}