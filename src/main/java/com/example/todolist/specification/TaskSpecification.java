package com.example.todolist.specification;

import com.example.todolist.dto.request.TaskFilterRequest;
import com.example.todolist.entity.Task;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TaskSpecification {
    public static Specification<Task> byFilter(TaskFilterRequest filter) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.isFalse(root.get("deleted")));

            if (filter != null) {
                if (filter.getTitle() != null && !filter.getTitle().trim().isEmpty()) {
                    predicates.add(cb.like(cb.lower(root.get("title")), "%" + filter.getTitle().toLowerCase() + "%"));
                }
                if (filter.getStatus() != null) {
                    predicates.add(cb.equal(root.get("status"), filter.getStatus()));
                }
                if (filter.getPriority() != null) {
                    predicates.add(cb.equal(root.get("priority"), filter.getPriority()));
                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}