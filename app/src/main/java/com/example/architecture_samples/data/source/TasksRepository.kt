package com.example.architecture_samples.data.source

import androidx.lifecycle.LiveData
import com.example.architecture_samples.data.Task

/**
 * Interface to the data layer.
 */
interface TasksRepository {

    fun observeTasks(): LiveData<Result<List<Task>>>

    suspend fun getTasks(forceUpdate: Boolean = false): Result<List<Task>>

    suspend fun refreshTasks()

    fun observeTask()
}