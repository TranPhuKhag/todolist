package com.example.todolist.service.impl;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.entity.Task;
import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;
import com.example.todolist.exception.AppException;
import com.example.todolist.exception.ErrorCode;
import com.example.todolist.mapper.TaskMapper;
import com.example.todolist.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Dùng MockitoExtension chuẩn như sma-backend
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskMapper taskMapper;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task mockTask;
    private TaskResponse mockTaskResponse;
    private TaskCreationRequest mockCreationRequest;

    @BeforeEach
    void setUp() {
        mockTask = Task.builder()
                .id(1L)
                .title("Làm bài test")
                .status(TaskStatus.PENDING)
                .priority(TaskPriority.HIGH)
                .deleted(0)
                .build();

        mockTaskResponse = TaskResponse.builder()
                .id(1L)
                .title("Làm bài test")
                .status(TaskStatus.PENDING)
                .priority(TaskPriority.HIGH)
                .build();

        mockCreationRequest = TaskCreationRequest.builder()
                .title("Làm bài test")
                .priority(TaskPriority.HIGH)
                .build();
    }
    
    @Test
    void getById_ValidId_ReturnsTaskResponse() {
        // Given (Chuẩn bị kịch bản)
        when(taskRepository.findById(1L)).thenReturn(Optional.of(mockTask));
        when(taskMapper.toResponse(mockTask)).thenReturn(mockTaskResponse);

        // When (Thực thi)
        TaskResponse response = taskService.getById(1L);

        // Then 
        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals("Làm bài test", response.getTitle());

        verify(taskRepository, times(1)).findById(1L);
    }
    
    @Test
    void getById_TaskNotFound_ThrowsAppException() {
        // Given
        Long wrongId = 99L;
        when(taskRepository.findById(wrongId)).thenReturn(Optional.empty());

        // When & Then
        AppException exception = assertThrows(AppException.class, () -> taskService.getById(wrongId));

        assertEquals(ErrorCode.TASK_NOT_FOUND, exception.getErrorCode());
        verify(taskRepository, times(1)).findById(wrongId);
        verify(taskMapper, never()).toResponse(any()); 
    }

    @Test
    void createTask_ValidRequest_ReturnsCreatedTask() {
        // Given
        Task taskBeforeSave = Task.builder().title("Làm bài test").build();

        when(taskMapper.toEntity(mockCreationRequest)).thenReturn(taskBeforeSave);
        when(taskRepository.save(taskBeforeSave)).thenReturn(mockTask);
        when(taskMapper.toResponse(mockTask)).thenReturn(mockTaskResponse);

        // When
        TaskResponse response = taskService.createTask(mockCreationRequest);

        // Then
        assertNotNull(response);
        assertEquals(TaskStatus.PENDING, response.getStatus());
        verify(taskRepository, times(1)).save(taskBeforeSave);
    }
    
    @Test
    void deleteTask_ValidId_DeletesTaskSuccessfully() {
        // Given
        when(taskRepository.findById(1L)).thenReturn(Optional.of(mockTask));
        when(taskMapper.toResponse(mockTask)).thenReturn(mockTaskResponse);

        // When
        taskService.deleteTask(1L);

        // Then
        verify(taskRepository, times(1)).delete(mockTask);
    }
}