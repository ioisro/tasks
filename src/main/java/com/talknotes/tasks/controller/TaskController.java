package com.talknotes.tasks.controller;

import com.talknotes.tasks.dto.TaskDTO;
import com.talknotes.tasks.model.Task;
import com.talknotes.tasks.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        Task task = TaskDTO.toTask(taskDTO);
        Task savedTask = taskService.createTask(task);
        return ResponseEntity.ok(Task.toTaskDTO(savedTask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> editTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task task = TaskDTO.toTask(taskDTO);
        Task updatedTask = taskService.editTask(id, task);
        return ResponseEntity.ok(Task.toTaskDTO(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        return ResponseEntity.ok(Task.toTaskDTO(task));
    }

    @GetMapping
    public ResponseEntity<Slice<TaskDTO>> getAllTasks(Pageable pageable) {
        Slice<Task> tasks = taskService.getAllTasks(pageable);
        Slice<TaskDTO> taskDTOs = tasks.map(Task::toTaskDTO);
        return ResponseEntity.ok(taskDTOs);
    }
}