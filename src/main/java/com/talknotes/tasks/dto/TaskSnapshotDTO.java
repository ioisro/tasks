package com.talknotes.tasks.dto;

import java.time.OffsetDateTime;

import com.talknotes.tasks.model.SnapshotStatus;
import com.talknotes.tasks.model.TaskSnapshot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskSnapshotDTO {
    private OffsetDateTime dueDate;
    private OffsetDateTime completionDate;
    private SnapshotStatus status;

    public static TaskSnapshot toTaskSnapshot(TaskSnapshotDTO taskSnapshotDTO) {
        TaskSnapshot taskSnapshot = new TaskSnapshot();
        taskSnapshot.setDueDate(taskSnapshotDTO.getDueDate());
        taskSnapshot.setCompletionDate(taskSnapshotDTO.getCompletionDate());
        taskSnapshot.setStatus(taskSnapshotDTO.getStatus());
        return taskSnapshot;
    }
}
