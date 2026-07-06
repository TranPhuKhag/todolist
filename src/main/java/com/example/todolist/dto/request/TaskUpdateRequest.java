package com.example.todolist.dto.request;

import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskUpdateRequest {

    String title;

    String description;

    TaskPriority priority;

    TaskStatus status;
}
