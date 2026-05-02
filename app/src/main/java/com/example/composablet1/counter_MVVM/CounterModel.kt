package com.example.composablet1.counter_MVVM

data class CounterModel(
    var count: Int
)

class CounterRepository{
    private var _counter = CounterModel(0)

    fun getCounter() = _counter
    fun incrementCounter() {
        if (_counter.count == 10) _counter.count = 0
        else _counter.count++
    }
    fun decrementCounter() {
        if (_counter.count > 0)
         _counter.count--
    }
}