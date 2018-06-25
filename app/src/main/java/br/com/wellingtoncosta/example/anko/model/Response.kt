package br.com.wellingtoncosta.example.anko.model

/**
 * @author Wellington Costa on 24/06/18.
 */
data class Response<out T> (
        val status: Int,
        val data: T? = null,
        val error: Throwable? = null
) {
    object Status {
        const val ERROR: Int = 0
        const val SUCCESS: Int = 1
    }
}