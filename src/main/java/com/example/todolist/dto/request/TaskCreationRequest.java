package com.example.todolist.dto.request;

import com.example.todolist.enums.TaskPriority;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCreationRequest {

    String title;

    String description;

    TaskPriority priority;

    LocalDateTime dueDate;
}