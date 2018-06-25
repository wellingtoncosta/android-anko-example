package br.com.wellingtoncosta.example.anko.presentation.common

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.view.ViewManager
import com.facebook.common.util.UriUtil
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import org.jetbrains.anko.custom.ankoView

/**
 * @author Wellington Costa on 25/06/18.
 */
inline fun ViewManager.simpleDraweeView(theme: Int = 0): SimpleDraweeView = simpleDraweeView(theme) {}
inline fun ViewManager.simpleDraweeView(theme: Int = 0, init: SimpleDraweeView.() -> Unit)
        = ankoView(::SimpleDraweeView, theme) { init() }

inline fun Context.simpleDraweeView(theme: Int = 0): SimpleDraweeView = simpleDraweeView(theme) {}
inline fun Context.simpleDraweeView(theme: Int = 0, init: SimpleDraweeView.() -> Unit)
        = ankoView(::SimpleDraweeView, theme) { init() }

inline fun Activity.simpleDraweeView(theme: Int = 0): SimpleDraweeView = simpleDraweeView(theme) {}
inline fun Activity.simpleDraweeView(theme: Int = 0, init: SimpleDraweeView.() -> Unit)
        = ankoView(::SimpleDraweeView, theme) { init() }

var SimpleDraweeView.imageRes get() = 1
    set(value) {
        val controller = Fresco.newDraweeControllerBuilder()
                .setUri(UriUtil.getUriForResourceId(value))
                .setAutoPlayAnimations(true)
                .setOldController(controller)
                .build()
        setController(controller)
    }

var SimpleDraweeView.imageUrl get() = ""
    set(value) {
        val controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(value))
                .setAutoPlayAnimations(true)
                .setOldController(controller)
                .build()
        setController(controller)
    }