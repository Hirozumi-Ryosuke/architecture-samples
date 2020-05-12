package com.example.architecture_samples

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.architecture_samples.addedittask.AddEditTaskViewModel
import com.example.architecture_samples.data.source.TasksRepository
import com.example.architecture_samples.statistics.StatisticsViewModel
import com.example.architecture_samples.taskdetail.TaskDetailViewModel
import com.example.architecture_samples.tasks.TasksViewModel
import java.lang.IllegalArgumentException

/**
 * Factory for all ViewModels.
 */
class ViewModelFactory constructor(
    private val tasksRepository: TasksRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(StatisticsViewModel::class::class.java) ->
                    StatisticsViewModel(tasksRepository)
                isAssignableFrom(TaskDetailViewModel::class.java) ->
                    TaskDetailViewModel(tasksRepository)
                isAssignableFrom(AddEditTaskViewModel::class.java) ->
                    AddEditTaskViewModel(tasksRepository)
                isAssignableFrom(TasksViewModel::class.java) ->
                    TasksViewModel(tasksRepository)
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        }
}