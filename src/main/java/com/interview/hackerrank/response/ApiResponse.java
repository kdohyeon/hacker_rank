package com.interview.hackerrank.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: kdohyeon
 * @date: 2019-12-27
 **/
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T> {

    private List<ApiError> errors;

    private T data;

    public Boolean isOk() {
        return errors == null || errors.isEmpty();
    }

    public ApiResponse<T> addError(ApiError error) {
        if (error != null) {
            this.getErrors().add(error);
        }
        return this;
    }

    public List<ApiError> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        return this.errors;
    }

    public static <T> ApiResponse<T> success(T data) {
        return create(data);
    }

    public static <T> ApiResponse<T> fail(String code) {
        return create(code, "", null);
    }

    public static <T> ApiResponse<T> fail(String code, String message) {
        return create(code, message, null);
    }

    public static <T> ApiResponse<T> fail(String code, String message, T data) {
        return create(code, message, data);
    }

    private static <T> ApiResponse<T> create(T data) {
        return new ApiResponse<>(null, data);
    }

    private static <T> ApiResponse<T> create(String code, String message, T data) {
        return create(data).addError(new ApiError(code, message));
    }
}
