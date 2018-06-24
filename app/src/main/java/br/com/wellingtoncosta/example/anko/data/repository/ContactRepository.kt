package br.com.wellingtoncosta.example.anko.data.repository

import br.com.wellingtoncosta.example.anko.data.datasource.ContactsDatasource
import javax.inject.Inject

/**
 * @author Wellington Costa on 24/06/18.
 */
class ContactRepository @Inject constructor(
        private val remoteDataSource: ContactsDatasource.Remote
) {

    fun listAll() = remoteDataSource.listAll()

    fun listByName(name: String) = remoteDataSource.listByName(name)

    fun findById(id: String) = remoteDataSource.findById(id)

}