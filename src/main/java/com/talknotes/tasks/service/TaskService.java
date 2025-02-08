package com.talknotes.tasks.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.talknotes.tasks.model.Task;

public interface TaskService {
    Task createTask(Task task);
    Task editTask(Long id, Task task);
    void deleteTask(Long id);
    Task getTaskById(Long id);
    Slice<Task> getAllTasks(Pageable pageable);
}
