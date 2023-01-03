package com.example.tmdbapp.utils


import retrofit2.HttpException
import java.io.IOException

interface SafeApiCall {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): NetworkResult<T> {
        return try {
            NetworkResult.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    NetworkResult.Failure(
                        false,
                        throwable.code(),
                        throwable.response()?.errorBody(),
                        throwable.response()
                            ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                }
                is IOException->{
                    NetworkResult.Failure(true, null, null, Constants.NETWORK_FAILURE)
                }
                else -> {
                    NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                }
            }
        }
    }


}