package br.com.wellingtoncosta.example.anko.presentation

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.wellingtoncosta.example.anko.data.repository.ContactRepository
import br.com.wellingtoncosta.example.anko.model.Contact
import br.com.wellingtoncosta.example.anko.model.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Wellington Costa on 24/06/18.
 */
class ListContactsViewModel @Inject constructor(
        private val repository: ContactRepository
) : ViewModel() {

    val isRefreshing: MutableLiveData<Boolean> = MutableLiveData()

    val response: MutableLiveData<Response<List<Contact>>> = MutableLiveData()

    private var disposables = CompositeDisposable()

    fun loadAll() {
        disposables.add(repository.listAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { isRefreshing.value = true }
                .doAfterTerminate { isRefreshing.value = false }
                .subscribe({
                    response.value = Response(
                            status = Response.Status.SUCCESS,
                            data = it
                    )
                }, {
                    response.value = Response(
                            status = Response.Status.ERROR,
                            error = it
                    )
                }))
    }

    override fun onCleared() {
        disposables.dispose()
    }

}