package com.example.todolist.controller;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.request.TaskUpdateRequest;
import com.example.todolist.dto.response.ApiResponse;
import com.example.todolist.dto.response.PageResponse;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.service.TaskService;
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
}
