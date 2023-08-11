package com.example.test.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.ActivityMainBinding
import com.example.test.viewmodel.HolidayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HolidayViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var holidayAdapter: HolidayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(HolidayViewModel::class.java)

        setupRecyclerView()
        observeData()
        fetchDataHolidays()
    }

    private fun observeData() {
        viewModel.holidays.observe(this, Observer { holidays ->
            holidayAdapter.submitList(holidays)
        })
    }

    private fun fetchDataHolidays() {
        viewModel.fetchHolidays(2020, "US")
    }

    private fun setupRecyclerView() {
        holidayAdapter = HolidayAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = holidayAdapter
        }
    }
}
