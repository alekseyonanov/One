package ru.onanov.one.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.onanov.one.R
import ru.onanov.one.fragment.MenuFragment
import ru.onanov.one.fragment.SportFragment
import ru.onanov.one.fragment.StatisticsFragment

/**
 * @author Onanov Aleksey (@onanov)
 */
class MainActivity : AppCompatActivity() {

    private lateinit var sportFragment: SportFragment
    private lateinit var statisticsFragment: StatisticsFragment
    private lateinit var menuFragment: MenuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportFragment = SportFragment.newInstance()
        statisticsFragment = StatisticsFragment.newInstance()
        menuFragment = MenuFragment.newInstance()

        navigation.setOnNavigationItemSelectedListener {
            val fragment = when (it.itemId) {
                R.id.sport -> sportFragment
                R.id.statistics -> statisticsFragment
                R.id.menu -> menuFragment
                else -> sportFragment
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout, fragment, fragment.tag)
                .commitAllowingStateLoss()
            true
        }

        supportFragmentManager
            .beginTransaction()
            .add(R.id.framelayout, sportFragment)
            .commitAllowingStateLoss()
    }
/*    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        menuFragment.onActivityResult(requestCode,resultCode,data)
    }*/
}