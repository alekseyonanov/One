package ru.onanov.one.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.onanov.one.R

/**
 * @author Onanov Aleksey (@onanov)
 */
class StatisticsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statisticsRecyclerView.apply {
            adapter = StatisticsAdapter()
        }
        toolbar_title.text = getString(R.string.statistics_title)
    }

    companion object {

        @JvmStatic
        fun newInstance() = StatisticsFragment()

    }
}