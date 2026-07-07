package com.example.todolist.dto.request;

import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskUpdateRequest {

    @NotBlank(message = "Tiêu đề công việc không được để trống")
    @Size(max = 120, message = "Tiêu đề công việc không được vượt quá 120 ký tự")
    String title;

    @Size(max = 500, message = "Mô tả công việc không được vượt quá 500 ký tự")
    String description;

    TaskPriority priority;

    TaskStatus status;
}
