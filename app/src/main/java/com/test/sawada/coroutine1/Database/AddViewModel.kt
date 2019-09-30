package com.test.sawada.coroutine1.Database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel : ViewModel() {

    fun getTask() : LiveData<List<Task>> {
        if (tasks.value == null) {
            loadTaskData()
        }
        return tasks
    }

    // private

    private val tasks: LiveData<List<Task>> = MutableLiveData<List<Task>>()

    private fun loadTaskData() {
        // 非同期でTaskのデータを読み込みMutableLiveDataに反映する
    }
}