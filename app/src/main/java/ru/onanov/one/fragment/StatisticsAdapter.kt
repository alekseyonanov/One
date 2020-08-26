package ru.onanov.one.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.onanov.one.R

/**
 * @author Onanov Aleksey (@onanov)
 */
class StatisticsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StatisticsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_statistics, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount() = 10

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class StatisticsViewHolder(view: View) : RecyclerView.ViewHolder(view)

}