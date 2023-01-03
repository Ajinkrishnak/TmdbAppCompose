package com.example.tmdbapp.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun formattedYear(releaseDate: String?): String? {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale("en"))
    val outputFormat = SimpleDateFormat("yyyy", Locale("en"))
    val formattedDate = releaseDate?.let {
        try {
            val date = inputFormat.parse(it)
            val formattedDate = date?.let { it1 -> outputFormat.format(it1) }
            formattedDate
        } catch (e: ParseException) {
            e.printStackTrace()
            ""
        }
    }
    return formattedDate
}

fun minuteToTime(min: Int): String {
    var minute = min
    var hour = minute / 60
    minute %= 60
    hour %= 12
    return (if (hour < 10) "$hour" else hour).toString() + "h " + (if (minute < 10) "0$minute" else minute) + "m"
}