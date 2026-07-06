package com.example.todolist.service.impl;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.request.TaskUpdateRequest;
import com.example.todolist.dto.response.PageResponse;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.entity.Task;
import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;
import com.example.todolist.exception.AppException;
import com.example.todolist.exception.ErrorCode;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.repository.TaskRepository;
import com.example.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;

    @Override
    public TaskResponse createTask(TaskCreationRequest request) {
        Task task = taskMapper.toEntity(request);
        task.setStatus(TaskStatus.PENDING);
        task = taskRepository.save(task);
        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse getById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.TASK_NOT_FOUND));
        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse updateTask(Long id, TaskUpdateRequest request) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.TASK_NOT_FOUND));

        taskMapper.update(task, request);
        task = taskRepository.save(task);

        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse changeTaskStatus(Long id, TaskStatus status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.TASK_NOT_FOUND));

        task.setStatus(status);
        task = taskRepository.save(task);

        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponse deleteTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.TASK_NOT_FOUND));
        taskRepository.delete(task);
        return taskMapper.toResponse(task);
    }

}
