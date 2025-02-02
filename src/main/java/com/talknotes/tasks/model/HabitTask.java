package com.talknotes.tasks.model;

import com.talknotes.tasks.model.TaskType.TypeValues;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(TypeValues.HABIT)
public class HabitTask {
    Integer streak;
}
