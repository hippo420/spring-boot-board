package com.example.board.dto;

import lombok.Data;

import java.util.List;


@Data
public class BoardDto extends CommonVo{

    private List<BoardFileDto> boardFileDtoList;
    private int board_idx;
    private String title;
    private String contents;
    private int hit_cnt;

}
