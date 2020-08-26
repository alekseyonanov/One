package ru.onanov.one.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @author Onanov Aleksey (@onanov)
 */
@Parcelize
data class Goal(
    var run: Int,
    var pushUp: Int,
    var squat: Int,
    var abs: Int
) : Parcelable