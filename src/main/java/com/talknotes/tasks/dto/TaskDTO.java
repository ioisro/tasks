package com.talknotes.tasks.dto;

import java.util.List;
import java.util.Set;

import com.talknotes.tasks.model.HabitTask;
import com.talknotes.tasks.model.SingleTask;
import com.talknotes.tasks.model.Task;
import com.talknotes.tasks.model.TaskPriority;
import com.talknotes.tasks.model.TaskType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
    private String title;
    private String description;
    private TaskType type;
    private TaskPriority taskPriority;
    private Set<String> tags;
    private Set<Integer> recurrenceDays;
    private Set<Integer> recurrenceDates;
    private List<TaskSnapshotDTO> snapshots;

    public static Task toTask(TaskDTO taskDTO) {
        Task task;
        if (taskDTO.getType() == TaskType.HABIT) {
            task = new HabitTask();
        } else {
            task = new SingleTask();
        }

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setPriority(taskDTO.getTaskPriority());
        task.setTags(taskDTO.getTags());
        task.setRecurrenceDays(taskDTO.getRecurrenceDays());
        task.setRecurrenceDates(taskDTO.getRecurrenceDates());
        return task;
    }
}
