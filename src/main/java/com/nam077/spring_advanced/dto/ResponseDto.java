package com.nam077.spring_advanced.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Generic Response DTO for all types of responses")
public class ResponseDto<T> {

    @Schema(description = "Single data object in response")
    private T data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "List of items in response")
    private List<T> items;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Pagination details if applicable")
    private PaginationDto pagination;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Cursor-based pagination details if applicable")
    private CursorDto cursor;

    @Schema(description = "Response message for client")
    private String message;

    @Schema(description = "Indicates if the operation was successful")
    private boolean success;

    @Schema(description = "HTTP status code for the response")
    private HttpStatus status;

    // Constructor for single response
    public ResponseDto(T data, String message, boolean success, HttpStatus status) {
        this.data = data;
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Constructor for multi response
    public ResponseDto(List<T> items, String message, boolean success, HttpStatus status) {
        this.items = items;
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Constructor for pagination response
    public ResponseDto(List<T> items, PaginationDto pagination, String message, boolean success, HttpStatus status) {
        this.items = items;
        this.pagination = pagination;
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Constructor for cursor-based pagination response
    public ResponseDto(List<T> items, CursorDto cursor, String message, boolean success, HttpStatus status) {
        this.items = items;
        this.cursor = cursor;
        this.message = message;
        this.success = success;
        this.status = status;
    }
}
