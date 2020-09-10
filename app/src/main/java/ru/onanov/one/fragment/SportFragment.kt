package ru.onanov.one.fragment

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_sport.*
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.onanov.one.R
import ru.onanov.one.activity.MainActivity
import ru.onanov.one.data.Loader
import ru.onanov.one.data.model.Goal
import ru.onanov.one.data.model.Result
import ru.onanov.one.view.IncreaserView

/**
 * @author Onanov Aleksey (@onanov)
 */
class SportFragment : Fragment() {

    private lateinit var goal: Goal
    private lateinit var result: Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goal = Loader.getCurrentGoals(context as Context)
        result = Loader.getCurrentResult(context as Context)
    }

    override fun onStop() {
        super.onStop()
        Loader.setCurrentResult(context as Context, result)
    }

    override fun onStart() {
        super.onStart()
        ObjectAnimator.ofInt(runProgressBar, "progress", result.run * MULTIPLIER)
            .setDuration(300)
            .start()
        ObjectAnimator.ofInt(pushUpProgressBar, "progress", result.pushUp * MULTIPLIER)
            .setDuration(300)
            .start()
        ObjectAnimator.ofInt(squatProgressBar, "progress", result.squat * MULTIPLIER)
            .setDuration(300)
            .start()
        ObjectAnimator.ofInt(absProgressBar, "progress", result.abs * MULTIPLIER)
            .setDuration(300)
            .start()
        runResultNumber.text = result.run.toString()
        pushUpResultNumber.text = result.pushUp.toString()
        squatResultNumber.text = result.squat.toString()
        absResultNumber.text = result.abs.toString()

        (activity as MainActivity).setNavigationVisible()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar_title.text = getString(R.string.sport_title)

        runIncreaser.apply {
            colorRes = R.color.run
            title = getString(R.string.run)
            onIncreaseClickListener = {
                result.run += when (it) {
                    IncreaserView.IncreaseValue.ONE -> 1
                    IncreaserView.IncreaseValue.TWO -> 2
                    IncreaserView.IncreaseValue.FIVE -> 5
                    IncreaserView.IncreaseValue.TEN -> 10
                    IncreaserView.IncreaseValue.ALL -> goal.run - result.run
                }
                runResultNumber.text = result.run.toString()
                //runProgressBar.progress = runResult
                ObjectAnimator.ofInt(runProgressBar, "progress", result.run * MULTIPLIER)
                    .setDuration(300)
                    .start()
            }
        }
        pushUpIncreaser.apply {
            colorRes = R.color.pushUp
            title = getString(R.string.pushUp)
            onIncreaseClickListener = {
                result.pushUp += when (it) {
                    IncreaserView.IncreaseValue.ONE -> 1
                    IncreaserView.IncreaseValue.TWO -> 2
                    IncreaserView.IncreaseValue.FIVE -> 5
                    IncreaserView.IncreaseValue.TEN -> 10
                    IncreaserView.IncreaseValue.ALL -> goal.pushUp - result.pushUp
                }
                pushUpResultNumber.text = result.pushUp.toString()
                ObjectAnimator.ofInt(pushUpProgressBar, "progress", result.pushUp * MULTIPLIER)
                    .setDuration(300)
                    .start()
            }
        }
        squatIncreaser.apply {
            colorRes = R.color.squat
            title = getString(R.string.squat)
            onIncreaseClickListener = {
                result.squat += when (it) {
                    IncreaserView.IncreaseValue.ONE -> 1
                    IncreaserView.IncreaseValue.TWO -> 2
                    IncreaserView.IncreaseValue.FIVE -> 5
                    IncreaserView.IncreaseValue.TEN -> 10
                    IncreaserView.IncreaseValue.ALL -> goal.squat - result.squat
                }
                squatResultNumber.text = result.squat.toString()
                ObjectAnimator.ofInt(squatProgressBar, "progress", result.squat * MULTIPLIER)
                    .setDuration(300)
                    .start()
            }
        }
        absIncreaser.apply {
            colorRes = R.color.abs
            title = getString(R.string.abs)
            onIncreaseClickListener = {
                result.abs += when (it) {
                    IncreaserView.IncreaseValue.ONE -> 1
                    IncreaserView.IncreaseValue.TWO -> 2
                    IncreaserView.IncreaseValue.FIVE -> 5
                    IncreaserView.IncreaseValue.TEN -> 10
                    IncreaserView.IncreaseValue.ALL -> goal.abs - result.abs
                }
                absResultNumber.text = result.abs.toString()
                ObjectAnimator.ofInt(absProgressBar, "progress", result.abs * MULTIPLIER)
                    .setDuration(300)
                    .start()
            }
        }
    }

    companion object {

        private const val MULTIPLIER = 100

        @JvmStatic
        fun newInstance() = SportFragment()
    }
}