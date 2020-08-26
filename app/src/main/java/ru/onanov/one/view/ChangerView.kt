package ru.onanov.one.view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.changer_view.view.*
import ru.onanov.one.R

/**
 * @author Onanov Aleksey (@onanov)
 */
class ChangerView : LinearLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    var colorRes: Int = R.color.colorAccent
        set(value) {
            field = value
            updateColor()
        }
    var value: String = ""
        set(value) {
            field = value
            updateValue()
        }

    var onIncreaseClickListener: (() -> Unit)? = null
    var onDecreaseClickListener: (() -> Unit)? = null

    init {
        val view = inflate(context, R.layout.changer_view, this)

        view.findViewById<AppCompatImageView>(R.id.changerIncrease).setOnClickListener {
            onIncreaseClickListener?.invoke()
        }

        view.findViewById<AppCompatImageView>(R.id.changerDecrease).setOnClickListener {
            onDecreaseClickListener?.invoke()
        }

    }

    private fun updateColor() {
        changerIncrease.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        changerDecrease.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
    }

    private fun updateValue() {
        changerValue.text = value
    }
}