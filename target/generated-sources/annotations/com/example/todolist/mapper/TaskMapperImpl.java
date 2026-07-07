package com.example.todolist.mapper;

import com.example.todolist.dto.request.TaskCreationRequest;
import com.example.todolist.dto.request.TaskUpdateRequest;
import com.example.todolist.dto.response.TaskResponse;
import com.example.todolist.entity.Task;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toEntity(TaskCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        Task.TaskBuilder task = Task.builder();

        task.title( request.getTitle() );
        task.description( request.getDescription() );
        task.priority( request.getPriority() );

        return task.build();
    }

    @Override
    public TaskResponse toResponse(Task entity) {
        if ( entity == null ) {
            return null;
        }

        TaskResponse.TaskResponseBuilder taskResponse = TaskResponse.builder();

        taskResponse.id( entity.getId() );
        taskResponse.title( entity.getTitle() );
        taskResponse.description( entity.getDescription() );
        taskResponse.status( entity.getStatus() );
        taskResponse.priority( entity.getPriority() );
        taskResponse.createdAt( entity.getCreatedAt() );
        taskResponse.updatedAt( entity.getUpdatedAt() );

        return taskResponse.build();
    }

    @Override
    public void update(Task entity, TaskUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getTitle() != null ) {
            entity.setTitle( request.getTitle() );
        }
        if ( request.getDescription() != null ) {
            entity.setDescription( request.getDescription() );
        }
        if ( request.getStatus() != null ) {
            entity.setStatus( request.getStatus() );
        }
        if ( request.getPriority() != null ) {
            entity.setPriority( request.getPriority() );
        }
    }
}
