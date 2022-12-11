package com.mvvm.mvvmlearnkotlin.utils

/**
 * Generic class for holding success response, error response and loading status
 */
data class NetResult<out T>(val status: Status, val data: T?, val error: Error?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): NetResult<T> {
            return NetResult(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: Error?): NetResult<T> {
            return NetResult(Status.ERROR, null, error, message)
        }

        fun <T> loading(data: T? = null): NetResult<T> {
            return NetResult(Status.LOADING, data, null, null)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}