package com.test.sawada.coroutine1.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "taskList")
data class Task(
    @PrimaryKey
    var id: String,

    var title: String,
    var isCheck: Boolean
)