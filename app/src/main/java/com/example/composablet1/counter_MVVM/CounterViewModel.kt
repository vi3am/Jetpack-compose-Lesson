package com.example.composablet1.counter_MVVM

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val repository: CounterRepository = CounterRepository()
    private val _count = mutableIntStateOf(repository.getCounter().count)
    val count : MutableState<Int> = _count

    fun increase(){
        repository.incrementCounter()
        _count.intValue = repository.getCounter().count
    }
    fun decrease(){
        repository.decrementCounter()
        _count.intValue = repository.getCounter().count
    }
}