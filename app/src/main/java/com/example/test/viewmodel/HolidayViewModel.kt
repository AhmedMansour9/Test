package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.Holiday
import com.example.test.repository.HolidayRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HolidayViewModel @Inject constructor(private val repository: HolidayRepository) : ViewModel() {

    private val _holidays = MutableLiveData<List<Holiday>>()
    val holidays: LiveData<List<Holiday>> get() = _holidays

    fun fetchHolidays(year: Int, countryCode: String) {
        viewModelScope.launch {
            val data = repository.getHolidays(year, countryCode)
            _holidays.postValue(data)
        }
    }
}