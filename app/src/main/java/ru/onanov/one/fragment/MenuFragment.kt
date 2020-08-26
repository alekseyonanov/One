package ru.onanov.one.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.onanov.one.R
import ru.onanov.one.activity.ChangeActivity
import ru.onanov.one.activity.ChangeActivity.Companion.ABS_REQUEST
import ru.onanov.one.activity.ChangeActivity.Companion.PUSH_UP_REQUEST
import ru.onanov.one.activity.ChangeActivity.Companion.RUN_REQUEST
import ru.onanov.one.activity.ChangeActivity.Companion.SQUAT_REQUEST
import ru.onanov.one.activity.SettingsActivity
import ru.onanov.one.data.Loader
import ru.onanov.one.data.model.Goal
import ru.onanov.one.data.model.User

/**
 * @author Onanov Aleksey (@onanov)
 */
class MenuFragment : Fragment() {

    private lateinit var goal: Goal
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        goal = Loader.getCurrentGoals(context as Context)
        user = Loader.getUserData(context as Context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.apply {
            setNavigationIcon(R.drawable.ic_settings)
            setNavigationOnClickListener {
                startActivity(Intent(context, SettingsActivity::class.java))
            }
            inflateMenu(R.menu.menu)
            toolbar_title.text = getString(R.string.profile_title)
        }
        runGoal.apply {
            setOnFocusChangeListener { _, isFocused ->
                if (isFocused) {
                    startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                        putExtra("request", RUN_REQUEST)
                        putExtra("value", goal.run)
                    }, RUN_REQUEST)
                }
            }
            setOnClickListener {
                startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                    putExtra("request", RUN_REQUEST)
                    putExtra("value", goal.run)
                }, RUN_REQUEST)
            }
            text = SpannableStringBuilder(goal.run.toString())
        }
        pushUpGoal.apply {
            setOnFocusChangeListener { _, isFocused ->
                if (isFocused) {
                    startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                        putExtra("request", PUSH_UP_REQUEST)
                        putExtra("value", goal.pushUp)
                    }, PUSH_UP_REQUEST)
                }
            }
            setOnClickListener {
                startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                    putExtra("request", PUSH_UP_REQUEST)
                    putExtra("value", goal.pushUp)
                }, PUSH_UP_REQUEST)
            }
            text = SpannableStringBuilder(goal.pushUp.toString())
        }

        squatGoal.apply {
            setOnFocusChangeListener { _, isFocused ->
                if (isFocused) {
                    startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                        putExtra("request", SQUAT_REQUEST)
                        putExtra("value", goal.squat)
                    }, SQUAT_REQUEST)
                }
            }
            setOnClickListener {
                startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                    putExtra("request", SQUAT_REQUEST)
                    putExtra("value", goal.squat)
                }, SQUAT_REQUEST)
            }
            text = SpannableStringBuilder(goal.squat.toString())
        }

        absGoal.apply {
            setOnFocusChangeListener { _, isFocused ->
                if (isFocused) {
                    startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                        putExtra("request", ABS_REQUEST)
                        putExtra("value", goal.abs)
                    }, ABS_REQUEST)
                }
            }
            setOnClickListener {
                startActivityForResult(Intent(context, ChangeActivity::class.java).apply {
                    putExtra("request", ABS_REQUEST)
                    putExtra("value", goal.abs)
                }, ABS_REQUEST)
            }
            text = SpannableStringBuilder(goal.abs.toString())
        }
    }

    fun notifyDataSetChanged(){
        runGoal.text = SpannableStringBuilder(goal.run.toString())
        pushUpGoal.text = SpannableStringBuilder(goal.pushUp.toString())
        squatGoal.text = SpannableStringBuilder(goal.squat.toString())
        absGoal.text = SpannableStringBuilder(goal.abs.toString())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("TEST", "onActivityResult: ")
        when(requestCode){
            RUN_REQUEST -> goal.run = data?.getIntExtra("value", 100) ?: 100
            PUSH_UP_REQUEST -> goal.pushUp = data?.getIntExtra("value", 100) ?: 100
            SQUAT_REQUEST -> goal.squat = data?.getIntExtra("value", 100) ?: 100
            ABS_REQUEST -> goal.abs = data?.getIntExtra("value", 100) ?: 100
        }

        Loader.setCurrentGoal(context as Context, goal)
        notifyDataSetChanged()
    }

    companion object {

        @JvmStatic
        fun newInstance() = MenuFragment()
    }
}