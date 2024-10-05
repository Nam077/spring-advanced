package com.nam077.spring_advanced.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Pagination details")
public class PaginationDto {

    @Schema(description = "Current page number")
    private int page;

    @Schema(description = "Number of items per page")
    private int pageSize; // Đổi tên từ limit thành pageSize

    @Schema(description = "Link to the next page")
    private Integer nextPage;

    @Schema(description = "Link to the previous page")
    private Integer prevPage;

    @Schema(description = "Total number of elements in the dataset")
    private long totalElements;

    @Schema(description = "Total number of pages in the dataset")
    private int totalPages;
}