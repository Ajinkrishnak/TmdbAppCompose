package com.example.tmdbapp.utils

object Constants {
    const val LANG = "en-US/"

    const val CONNECT_TIMEOUT = 20L
    const val READ_TIMEOUT = 60L
    const val WRITE_TIMEOUT = 120L

    const val NETWORK_PAGE_SIZE =10
    const val STARTING_PAGE_INDEX = 1

    const val STS_401 = "Unauthorized!"
    const val STS_403 = "Forbidden!"
    const val STS_404 = "Not Found"
    const val STS_408 = "Request Timed Out"
    const val STS_500 = "Internal Server Error"
    const val STS_502 = "Bad Gateway!"
    const val STS_503 = "Service Unavailable!"
    const val STS_504 = "Gateway Timeout"

    const val STS_DEFAULT = "Something went wrong, Please try again!"
    const val NETWORK_FAILURE = "You are not connected to the internet. Make sure your network connection and try again."
    const val CONVERSION_FAILURE = "Conversion Error"
}