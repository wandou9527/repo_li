package com.wandou.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liming
 * @date 2020-05-02
 * @description
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageDTO<T> {
    private Long total;
    private List<T> list;
}
