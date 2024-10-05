package com.nam077.spring_advanced.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Cursor-based pagination details")
public class CursorDto {

    @Schema(description = "Cursor pointing to the next set of data")
    private String nextCursor;

    @Schema(description = "Cursor pointing to the previous set of data")
    private String previousCursor;

    @Schema(description = "Indicates if there is a next page")
    private boolean hasNext;

    @Schema(description = "Indicates if there is a previous page")
    private boolean hasPrevious;
}
