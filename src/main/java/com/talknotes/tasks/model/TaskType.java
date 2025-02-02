package com.talknotes.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskType {
    SINGLE(TypeValues.SINGLE), HABIT(TypeValues.HABIT);

    private String type;

    public static class TypeValues {
        public static final String SINGLE = "SINGLE";
        public static final String HABIT = "HABIT";
    }
}
