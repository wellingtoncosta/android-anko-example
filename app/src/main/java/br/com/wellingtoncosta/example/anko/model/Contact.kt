package br.com.wellingtoncosta.example.anko.model

/**
 * @author Wellington Costa on 24/06/18.
 */
data class Contact(
        val id: String,
        val age: Int,
        val name: String,
        val gender: String,
        val company: String,
        val email: String,
        val photo: String
)