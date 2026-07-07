package com.example.todolist.dto.request;

import com.example.todolist.enums.TaskPriority;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCreationRequest {

    @NotBlank(message = "Tiêu đề công việc không được để trống")
    @Size(max = 120, message = "Tiêu đề công việc không được vượt quá 120 ký tự")
    String title;

    @Size(max = 500, message = "Mô tả công việc không được vượt quá 500 ký tự")
    String description;

    TaskPriority priority;

}