package com.example.todolist.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    // 500
    UNCATEGORIZED_EXCEPTION(
            HttpStatus.INTERNAL_SERVER_ERROR.value(), "Lỗi không xác định", HttpStatus.INTERNAL_SERVER_ERROR),
    TASK_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Không tìm thấy công việc này", HttpStatus.NOT_FOUND);
    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
