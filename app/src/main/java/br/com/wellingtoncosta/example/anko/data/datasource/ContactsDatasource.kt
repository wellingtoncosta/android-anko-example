package br.com.wellingtoncosta.example.anko.data.datasource

import br.com.wellingtoncosta.example.anko.model.Contact
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @author Wellington Costa on 24/06/18.
 */
interface ContactsDatasource {

    interface Remote {

        fun listAll(): Flowable<List<Contact>>

        fun listByName(name: String): Flowable<List<Contact>>

        fun findById(id: String): Single<Contact>

    }

}