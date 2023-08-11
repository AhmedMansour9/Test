package com.example.test.ui

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.test.R
import java.text.SimpleDateFormat
import java.util.*

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("formattedDate")
    fun setFormattedDate(textView: TextView, dateStr: String?) {
        if (dateStr != null) {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val outputFormat = SimpleDateFormat("dd MM yyyy", Locale.ENGLISH)
            val date: Date = inputFormat.parse(dateStr) ?: Date()
            val formattedDate: String = outputFormat.format(date)
            textView.text = formattedDate
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["modelType"], requireAll = true)
    fun setBackgroundColorBasedOnType(view: View, type: String) {
        val context = view.context
        val colorResId = when (type) {
            "Public" -> R.color.white
            "Optional" -> R.color.teal_200
            // Add more cases as needed
            else -> R.color.white
        }
        val backgroundColor = ContextCompat.getColor(context, colorResId)
        view.setBackgroundColor(backgroundColor)
    }
}