package ru.onanov.one.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_change.*
import ru.onanov.one.R

class ChangeActivity : AppCompatActivity() {

    private var currentValue = 100
    private var requestCode = RUN_REQUEST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        toolbar.setNavigationOnClickListener {
            finish()
        }

        toolbar.setOnMenuItemClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("value", currentValue)
            setResult(RESULT_OK, resultIntent)
            finish()
            true
        }

        requestCode = intent.getIntExtra("request", RUN_REQUEST)
        currentValue = intent.getIntExtra("value", 100)

        changer.apply {
            onIncreaseClickListener = {
                currentValue += 10
                value = currentValue.toString()
            }
            onDecreaseClickListener = {
                currentValue -= 10
                value = currentValue.toString()
            }

            colorRes = when (requestCode) {
                RUN_REQUEST -> R.color.run
                PUSH_UP_REQUEST -> R.color.pushUp
                SQUAT_REQUEST -> R.color.squat
                ABS_REQUEST -> R.color.abs
                else -> R.color.run
            }
            value = currentValue.toString()
        }

    }

    companion object {
        const val RUN_REQUEST = 0
        const val PUSH_UP_REQUEST = 1
        const val SQUAT_REQUEST = 2
        const val ABS_REQUEST = 3
    }
}