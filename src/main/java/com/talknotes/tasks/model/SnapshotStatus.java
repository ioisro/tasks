package com.talknotes.tasks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SnapshotStatus {
    PENDING("PENDING"),
    COMPLETED("COMPLETED"),
    SKIPPED("SKIPPED"),
    UNKNOWN("UNKNOWN"),
    FAILED("FAILED");

    private String status;
}
