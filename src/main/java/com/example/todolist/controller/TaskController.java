package com.example.todolist.controller;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.request.TaskFilterRequest;
import com.example.todolist.dto.request.TaskUpdateRequest;
import com.example.todolist.dto.response.ApiResponse;
import com.example.todolist.dto.response.PageResponse;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.enums.TaskStatus;
import com.example.todolist.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TaskController {

    TaskService taskService;
    @PostMapping
    public ApiResponse<TaskResponse> createTask(@RequestBody @Valid TaskCreationRequest req) {
        return ApiResponse.<TaskResponse>builder()
                .code(HttpStatus.CREATED.value())
                .message("Tạo công việc thành công")
                .result(taskService.createTask(req))
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> getById(@PathVariable Long id) {
        return ApiResponse.<TaskResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Lấy thông tin công việc thành công")
                .result(taskService.getById(id))
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> updateTask(
            @PathVariable Long id,
            @RequestBody @Valid TaskUpdateRequest req) {
        return ApiResponse.<TaskResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Cập nhật công việc thành công")
                .result(taskService.updateTask(id, req))
                .build();
    }

    @PatchMapping("/{id}/status")
    public ApiResponse<TaskResponse> changeTaskStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {
        return ApiResponse.<TaskResponse>builder()
                .code(HttpStatus.OK.value())
                .message("Cập nhật trạng thái công việc thành công")
                .result(taskService.changeTaskStatus(id, status))
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<TaskResponse> deleteTask(@PathVariable Long id) {
        return ApiResponse.<TaskResponse>builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Xoá công việc thành công")
                .result(taskService.deleteTask(id))
                .build();
    }

    @GetMapping
    public ApiResponse<PageResponse<TaskResponse>> getAllTasks(
            @ModelAttribute TaskFilterRequest filter,
            @RequestParam(defaultValue = "1")
            @Min(value = 1, message = "Page phải lớn hơn hoặc bằng 1")
            int page,
            @RequestParam(defaultValue = "10")
            @Min(value = 1, message = "Size phải lớn hơn hoặc bằng 1")
            @Max(value = 10, message = "Size không được vượt quá 10")
            int size,
            @RequestParam(defaultValue = "createdAt") String sort) {

        return ApiResponse.<PageResponse<TaskResponse>>builder()
                .code(HttpStatus.OK.value())
                .message("Lấy danh sách công việc thành công")
                .result(taskService.getAllTasks(filter, page, size, sort))
                .build();
    }
}
