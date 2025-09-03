package com.example.ui.time_formating

import android.content.Context
import com.example.ui.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone

fun formatFromFormatToLocalDate(
    date: String,
    context: Context,
    oldFormat: SimpleDateFormat
): String {
    val oldDateTime = oldFormat.parse(date)
    val newFormat = SimpleDateFormat("dd")
    newFormat.timeZone = TimeZone.getDefault()

    val calendar = Calendar.getInstance()
    calendar.time = oldDateTime!!
    val month = calendar[Calendar.MONTH]

    return "${newFormat.format(oldDateTime)} ${context.resources.getStringArray(R.array.of_months)[month]}"
}

fun formatUtcToLocalDate(date: String, context: Context): String {
    val oldFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    oldFormat.timeZone = TimeZone.getTimeZone("UTC")
    return formatFromFormatToLocalDate(date = date, context = context, oldFormat = oldFormat)
}

fun formatFromDatabaseToLocalDate(date: String, context: Context): String {
    val oldFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return formatFromFormatToLocalDate(date = date, context = context, oldFormat = oldFormat)
}