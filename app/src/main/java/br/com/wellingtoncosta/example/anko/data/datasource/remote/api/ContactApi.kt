package br.com.wellingtoncosta.example.anko.data.datasource.remote.api

import br.com.wellingtoncosta.example.anko.model.Contact
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Wellington Costa on 24/06/18.
 */
interface ContactApi {

    @GET("contacts")
    fun listAll(): Flowable<List<Contact>>

    @GET("contacts")
    fun listByName(@Query("name_like") name: String): Flowable<List<Contact>>

    @GET("contacts/{id}")
    fun fingById(@Path("id") id: String): Single<Contact>

}