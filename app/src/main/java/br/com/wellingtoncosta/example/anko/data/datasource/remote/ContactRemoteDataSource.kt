package br.com.wellingtoncosta.example.anko.data.datasource.remote

import br.com.wellingtoncosta.example.anko.data.datasource.ContactsDatasource
import br.com.wellingtoncosta.example.anko.data.datasource.remote.api.ContactApi
import javax.inject.Inject

/**
 * @author Wellington Costa on 24/06/18.
 */
class ContactRemoteDataSource @Inject constructor(
        private val api: ContactApi
) : ContactsDatasource.Remote {

    override fun listAll() = api.listAll()

    override fun listByName(name: String) = api.listByName(name)

    override fun findById(id: String) = api.fingById(id)

}