package ru.onanov.one.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * @author Onanov Aleksey (@onanov)
 */
@Parcelize
data class Result(
    var date: Long,
    var run: Int,
    var pushUp: Int,
    var squat: Int,
    var abs: Int
) : Parcelable {
    fun isResultActual(): Boolean {
        val today = Calendar.getInstance().apply {
            time = Date()
        }
        val lastSavedDate = Calendar.getInstance().apply {
            time = Date(date)
        }
        return today.get(Calendar.DATE) == lastSavedDate.get(Calendar.DATE)
    }
}