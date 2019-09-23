package com.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class CommentReadDto {
    private List<Long> commentIdList;
}
