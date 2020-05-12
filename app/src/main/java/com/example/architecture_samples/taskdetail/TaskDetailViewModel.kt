package com.example.architecture_samples.taskdetail

import androidx.lifecycle.*
import com.example.architecture_samples.data.Task
import com.example.architecture_samples.data.source.TasksRepository
import com.google.android.play.core.tasks.Tasks

class TaskDetailViewModel(
    private val tasksRepository: TasksRepository
) : ViewModel() {

    private val _taskId = MutableLiveData<String>()

    private val _task = _taskId.switchMap { taskId ->
        tasksRepository.observeTask(taskId).map { computeResult(it) }
    }
    val task: LiveData<Task?> = _task

    val isDataAvailable: LiveData<Boolean> = _task.map { it != null }

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean> = _dataLoading

    

}