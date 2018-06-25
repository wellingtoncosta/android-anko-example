package br.com.wellingtoncosta.example.anko.di.module.presentation

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.wellingtoncosta.example.anko.di.key.ViewModelKey
import br.com.wellingtoncosta.example.anko.presentation.ListContactsViewModel
import br.com.wellingtoncosta.example.anko.presentation.common.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Wellington Costa on 24/06/18.
 */
@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ListContactsViewModel::class)
    fun bindListUsersViewModel(listContactsViewModel: ListContactsViewModel) : ViewModel

}