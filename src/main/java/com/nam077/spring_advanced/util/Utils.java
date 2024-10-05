package com.nam077.spring_advanced.util;

import org.springframework.beans.BeanUtils;

public class Utils {
    public static <T, U> U convertEntityToDto(T entity, Class<U> dtoClass) {
        try {
            U dto = dtoClass.getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert entity to DTO", e);
        }
    }

}
