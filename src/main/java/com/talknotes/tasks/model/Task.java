package com.talknotes.tasks.model;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.talknotes.tasks.dto.TaskDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    @ElementCollection
    private Set<String> tags;
    @ElementCollection
    private Set<Integer> recurrenceDays;
    @ElementCollection
    private Set<Integer> recurrenceDates;
    
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<TaskSnapshot> snapshots;

    public static TaskDTO toTaskDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        if (task instanceof HabitTask) {
            taskDTO.setType(TaskType.HABIT);
        } else {
            taskDTO.setType(TaskType.SINGLE);
        }
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setTaskPriority(task.getPriority());
        taskDTO.setTags(task.getTags());
        taskDTO.setRecurrenceDays(task.getRecurrenceDays());
        taskDTO.setRecurrenceDates(task.getRecurrenceDates());
        taskDTO.setSnapshots(Optional.ofNullable(task.getSnapshots()).map(snapshots -> snapshots.stream().map(TaskSnapshot::toTaskSnapshotDTO).toList()).orElse(null));
        return taskDTO;
    }
}