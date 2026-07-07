package com.example.todolist.dto.request;

import com.example.todolist.enums.TaskStatus;
import com.example.todolist.enums.TaskPriority;
import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskFilterRequest {
    @Size(max = 100, message = "Từ khóa tìm kiếm không được vượt quá 100 ký tự")
    String title;
    TaskStatus status;
    TaskPriority priority;
}