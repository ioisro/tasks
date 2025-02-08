package com.talknotes.tasks.model;

import com.talknotes.tasks.model.TaskType.TypeValues;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(TypeValues.HABIT)
public class HabitTask extends Task {
    Integer streak;
}
