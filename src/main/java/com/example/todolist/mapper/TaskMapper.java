package com.example.todolist.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.request.TaskUpdateRequest;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.entity.Task;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {

    Task toEntity(TaskCreationRequest request);

    TaskResponse toResponse(Task entity);

    void update(@MappingTarget Task entity, TaskUpdateRequest request);
}
