package br.com.wellingtoncosta.example.anko

import br.com.wellingtoncosta.example.anko.di.component.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * @author Wellington Costa on 24/06/18.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<out App> {
        return DaggerAppComponent.builder().create(this)
    }

}