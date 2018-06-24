package br.com.wellingtoncosta.example.anko.di.component

import br.com.wellingtoncosta.example.anko.App
import br.com.wellingtoncosta.example.anko.di.module.data.RepositoryModule
import br.com.wellingtoncosta.example.anko.di.module.data.RetrofitModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author Wellington Costa on 24/06/18.
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    RetrofitModule::class,
    RepositoryModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}