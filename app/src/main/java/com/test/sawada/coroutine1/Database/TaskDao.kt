package com.test.sawada.coroutine1.Database

import androidx.room.*

@Dao
interface TaskDao {

    @Query("select * from taskList")
    fun getAllTasks(): List<Task>

    @Query("select * from taskList where id = :id")
    fun getTask(id: String): Task

    @Insert
    fun insertTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)


}