package com.example.todolist.service;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.request.TaskUpdateRequest;
import com.example.todolist.dto.response.PageResponse;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;

public interface TaskService {

    TaskResponse createTask(TaskCreationRequest req);
    TaskResponse getById(Long id);
    TaskResponse updateTask(Long id, TaskUpdateRequest req);
    TaskResponse changeTaskStatus(Long id, TaskStatus status);
    TaskResponse deleteTask(Long id);
}
