package com.example.todolist.entity;

import com.example.todolist.enums.TaskPriority;
import com.example.todolist.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@SQLDelete(sql = "UPDATE task SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = 0")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    String description;

    @Enumerated(EnumType.STRING)
    TaskStatus status;

    @Enumerated(EnumType.STRING)
    TaskPriority priority;

    LocalDateTime dueDate;

    @CreationTimestamp
    @Column(updatable = false)
    LocalDateTime createdAt;

    @UpdateTimestamp
    LocalDateTime updatedAt;
}
