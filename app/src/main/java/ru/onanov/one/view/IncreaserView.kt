package ru.onanov.one.view

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.increaser_view.view.*
import ru.onanov.one.R

/**
 * @author Onanov Aleksey (@onanov)
 */
class IncreaserView : LinearLayout {

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
    var title: String = ""
        set(value) {
            field = value
            updateTitle()
        }

    var onIncreaseClickListener: ((IncreaseValue) -> Unit)? = null

    init {
        val view = inflate(context, R.layout.increaser_view, this)

        view.findViewById<FloatingActionButton>(R.id.increaseOne).setOnClickListener {
            onIncreaseClickListener?.invoke(IncreaseValue.ONE)
        }

        view.findViewById<FloatingActionButton>(R.id.increaseTwo).setOnClickListener {
            onIncreaseClickListener?.invoke(IncreaseValue.TWO)
        }

        view.findViewById<FloatingActionButton>(R.id.increaseFive).setOnClickListener {
            onIncreaseClickListener?.invoke(IncreaseValue.FIVE)
        }

        view.findViewById<FloatingActionButton>(R.id.increaseTen).setOnClickListener {
            onIncreaseClickListener?.invoke(IncreaseValue.TEN)
        }

        view.findViewById<ExtendedFloatingActionButton>(R.id.increaseAll).setOnClickListener {
            onIncreaseClickListener?.invoke(IncreaseValue.ALL)
            it.isEnabled = false
        }
    }

    private fun updateColor() {
        increaseOne.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        increaseOne.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        increaseTwo.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        increaseFive.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        increaseTen.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
        increaseAll.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))
    }

    private fun updateTitle() {
        increaseTitle.text = title
    }

    enum class IncreaseValue {
        ONE,
        TWO,
        FIVE,
        TEN,
        ALL
    }

}