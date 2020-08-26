package ru.onanov.one.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Onanov Aleksey (@onanov)
 */
@Parcelize
data class User(
    var gender: Int,
    var birthDate: Long,
    var weight: Int,
    var height: Int
) : Parcelable {

    companion object {
        const val MALE = 0
        const val FEMALE = 0
        const val UNIDENTIFIED = 0
    }
}