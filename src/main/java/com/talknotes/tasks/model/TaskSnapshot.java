package com.talknotes.tasks.model;

import java.time.OffsetDateTime;

import com.talknotes.tasks.dto.TaskSnapshotDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "task_snapshots")
public class TaskSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
    private OffsetDateTime dueDate;
    private OffsetDateTime completionDate;
    @Enumerated(EnumType.STRING)
    private SnapshotStatus status;

    public static TaskSnapshotDTO toTaskSnapshotDTO(TaskSnapshot snapshot) {
        TaskSnapshotDTO snapshotDTO = new TaskSnapshotDTO();
        snapshotDTO.setDueDate(snapshot.getDueDate());
        snapshotDTO.setCompletionDate(snapshot.getCompletionDate());
        snapshotDTO.setStatus(snapshot.getStatus());
        return snapshotDTO;
    }
}
