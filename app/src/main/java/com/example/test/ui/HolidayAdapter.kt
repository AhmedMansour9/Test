package com.example.test.ui



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test.databinding.ListItemHolidayBinding
import com.example.test.model.Holiday

class HolidayAdapter : ListAdapter<Holiday, HolidayAdapter.ViewHolder>(HolidayDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemHolidayBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val holiday = getItem(position)
        holder.bind(holiday)
    }

    class ViewHolder(private val binding: ListItemHolidayBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(holiday: Holiday) {
            binding.holiday = holiday
            binding.executePendingBindings()
        }
    }

    private class HolidayDiffCallback : DiffUtil.ItemCallback<Holiday>() {
        override fun areItemsTheSame(oldItem: Holiday, newItem: Holiday): Boolean {
            return oldItem.date == newItem.date
        }

        override fun areContentsTheSame(oldItem: Holiday, newItem: Holiday): Boolean {
            return oldItem == newItem
        }
    }
}
