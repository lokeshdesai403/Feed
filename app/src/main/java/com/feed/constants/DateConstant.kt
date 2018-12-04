package com.feed.constants

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Lokesh.
 */
class DateConstant {

    companion object {

        const val MY_FORMAT = "dd, MMM yyyy"
        const val GLOBAL_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS"

        fun getDateFromString(date: String?, fromFormat: String): Date? {
            val formatFrom = SimpleDateFormat(fromFormat, Locale.getDefault())
            var dateMain: Date? = null
            try {
                dateMain = formatFrom.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return dateMain
        }

        fun getDateInString(date: Date, toFormat: String): String {
            val formatFrom = SimpleDateFormat(toFormat, Locale.getDefault())
            var dateMain = ""
            try {
                dateMain = formatFrom.format(date)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return dateMain
        }
    }
}