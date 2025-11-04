package com.fitness.activityservice.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


public enum ActivityType {
    RUNNING,
    WALKING,
    CYCLING,
    SWIMMING,
    WEIGHT_TRAINING,
    YOGA,
    HIIT,
    CARDIO,
    STRETCHING,
    OTHER
}
