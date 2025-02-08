package com.talknotes.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskPriority {
    LOW("LOW"), MEDIUM("MEDIUM"), HIGH("HIGH");

    private String priority;
}
