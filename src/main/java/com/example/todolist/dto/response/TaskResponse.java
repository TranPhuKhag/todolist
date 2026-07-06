package com.example.todolist.dto.response;

import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskResponse {

    Long id;
    String title;
    String description;
    TaskStatus status;
    TaskPriority priority;
    LocalDateTime dueDate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
