package com.example.todolist.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    // 500
    UNCATEGORIZED_EXCEPTION(
            HttpStatus.INTERNAL_SERVER_ERROR.value(), "Lỗi không xác định", HttpStatus.INTERNAL_SERVER_ERROR),
    // 404 Not Found
    TASK_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Không tìm thấy công việc này", HttpStatus.NOT_FOUND),
    // 400 Bad Request
    INVALID_KEY(HttpStatus.BAD_REQUEST.value(), "Khóa không hợp lệ", HttpStatus.BAD_REQUEST);

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
