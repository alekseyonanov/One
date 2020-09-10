package ru.onanov.one.data

import android.content.Context
import ru.onanov.one.data.model.Goal
import ru.onanov.one.data.model.Result
import ru.onanov.one.data.model.User
import ru.onanov.one.data.model.User.Companion.UNIDENTIFIED

/**
 * @author Onanov Aleksey (@onanov)
 */
object Loader {

    /*
    * Категории данных
    */
    private const val APP = "ru.onanov.one.app"
    private const val SPORT = "ru.onanov.one.sport"
    private const val USER = "ru.onanov.one.user"
    private const val SETTINGS = "ru.onanov.one.settings"

    /*
    * Наименование полей
    */
    private const val FIRST_START = "first_start"

    private const val GOAL_RUN = "current_goal_run"
    private const val GOAL_PUSH_UP = "current_goal_push_up"
    private const val GOAL_SQUAT = "current_goal_squat"
    private const val GOAL_ABS = "current_goal_abs"

    private const val CURRENT_RESULT_DATE = "current_result_date"
    private const val CURRENT_RESULT_RUN = "current_result_run"
    private const val CURRENT_RESULT_PUSH_UP = "current_result_push_up"
    private const val CURRENT_RESULT_SQUAT = "current_result_squat"
    private const val CURRENT_RESULT_ABS = "current_result_abs"

    private const val USER_DATA_GENDER = "user_data_gender"
    private const val USER_DATA_BIRTH_DATE = "user_data_birth_date"
    private const val USER_DATA_WEIGHT = "user_data_weight"
    private const val USER_DATA_HEIGHT = "user_data_height"

    private const val DEFAULT_RESULT = 0

    fun getCurrentGoals(context: Context): Goal {
        val preferences = context.getSharedPreferences(SPORT, Context.MODE_PRIVATE)
        return Goal(
            run = preferences.getInt(GOAL_RUN, DEFAULT_RESULT),
            pushUp = preferences.getInt(GOAL_PUSH_UP, DEFAULT_RESULT),
            squat = preferences.getInt(GOAL_SQUAT, DEFAULT_RESULT),
            abs = preferences.getInt(GOAL_ABS, DEFAULT_RESULT)
        )
    }

    fun setCurrentGoal(context: Context, goal: Goal) {
        context.getSharedPreferences(SPORT, Context.MODE_PRIVATE).edit()
            .putInt(GOAL_RUN, goal.run)
            .putInt(GOAL_PUSH_UP, goal.pushUp)
            .putInt(GOAL_SQUAT, goal.squat)
            .putInt(GOAL_ABS, goal.abs)
            .apply()
    }

    fun getCurrentResult(context: Context): Result {
        val preferences = context.getSharedPreferences(SPORT, Context.MODE_PRIVATE)
        return Result(
            date = preferences.getLong(CURRENT_RESULT_DATE, DEFAULT_RESULT.toLong()),
            run = preferences.getInt(CURRENT_RESULT_RUN, DEFAULT_RESULT),
            pushUp = preferences.getInt(CURRENT_RESULT_PUSH_UP, DEFAULT_RESULT),
            squat = preferences.getInt(CURRENT_RESULT_SQUAT, DEFAULT_RESULT),
            abs = preferences.getInt(CURRENT_RESULT_ABS, DEFAULT_RESULT)
        )
    }

    fun setCurrentResult(context: Context, result: Result) {
        context.getSharedPreferences(SPORT, Context.MODE_PRIVATE).edit()
            .putLong(CURRENT_RESULT_DATE, result.date)
            .putInt(CURRENT_RESULT_RUN, result.run)
            .putInt(CURRENT_RESULT_PUSH_UP, result.pushUp)
            .putInt(CURRENT_RESULT_SQUAT, result.squat)
            .putInt(CURRENT_RESULT_ABS, result.abs)
            .apply()
    }

    fun getUserData(context: Context): User {
        val preferences = context.getSharedPreferences(USER, Context.MODE_PRIVATE)
        return User(
            gender = preferences.getInt(USER_DATA_GENDER, UNIDENTIFIED),
            birthDate = preferences.getLong(USER_DATA_BIRTH_DATE, DEFAULT_RESULT.toLong()),
            weight = preferences.getInt(USER_DATA_WEIGHT, DEFAULT_RESULT),
            height = preferences.getInt(USER_DATA_HEIGHT, DEFAULT_RESULT)
        )
    }

    fun setUserData(context: Context, user: User) {
        context.getSharedPreferences(USER, Context.MODE_PRIVATE).edit()
            .putInt(USER_DATA_GENDER, user.gender)
            .putLong(USER_DATA_BIRTH_DATE, user.birthDate)
            .putInt(USER_DATA_WEIGHT, user.weight)
            .putInt(USER_DATA_HEIGHT, user.height)
            .apply()
    }

    fun isFirstStart(context: Context) =
        context.getSharedPreferences(APP, Context.MODE_PRIVATE).getBoolean(FIRST_START, true)

    fun setFirstStart(context: Context, result: Boolean) {
        context.getSharedPreferences(APP, Context.MODE_PRIVATE).edit()
            .putBoolean(FIRST_START, result).apply()
    }
}