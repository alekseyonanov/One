package ru.onanov.one.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * @author Onanov Aleksey (@onanov)
 */
class DataBase(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_RESULT ($ID INTEGER PRIMARY KEY AUTOINCREMENT ,$RESULT_DATE LONG, $RESULT_RUN INTEGER, $RESULT_PUSH_UP INTEGER, $RESULT_SQUAT INTEGER, $RESULT_ABS INTEGER);")
        db.execSQL("CREATE TABLE $TABLE_GOAL ($ID INTEGER PRIMARY KEY AUTOINCREMENT ,$GOAL_DATE LONG, $GOAL_RUN INTEGER, $GOAL_PUSH_UP INTEGER, $GOAL_SQUAT INTEGER, $GOAL_ABS INTEGER);")
        db.execSQL("CREATE TABLE $TABLE_CALORIES ($ID INTEGER PRIMARY KEY AUTOINCREMENT ,$CALORIES_DATE LONG, $CALORIES_VALUE INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE $TABLE_RESULT")
        db.execSQL("DROP TABLE $TABLE_GOAL")
        db.execSQL("DROP TABLE $TABLE_CALORIES")
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE $TABLE_RESULT")
        db.execSQL("DROP TABLE $TABLE_GOAL")
        db.execSQL("DROP TABLE $TABLE_CALORIES")
        onCreate(db)
    }

    companion object {
        private const val DB_NAME = "DATABASE"
        private const val DB_VERSION = 1

        private const val TABLE_RESULT = "RESULT"
        private const val TABLE_GOAL = "GOAL"
        private const val TABLE_CALORIES = "CALORIES"

        private const val ID = "_id"
        private const val GOAL_DATE = "DATE"
        private const val GOAL_RUN = "RUN"
        private const val GOAL_PUSH_UP = "PUSH_UP"
        private const val GOAL_SQUAT = "SQUAT"
        private const val GOAL_ABS = "ABS"

        private const val RESULT_DATE = "DATE"
        private const val RESULT_RUN = "RUN"
        private const val RESULT_PUSH_UP = "PUSH_UP"
        private const val RESULT_SQUAT = "SQUAT"
        private const val RESULT_ABS = "ABS"

        private const val CALORIES_DATE = "CALORIES"
        private const val CALORIES_VALUE = "VALUE"
    }
}