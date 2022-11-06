package com.example.board.dto;

import lombok.Data;


@Data
public class BoardDto {

    private int board_idx;
    private String title;
    private String contents;
    private int hit_cnt;
    private String creator_id;
    private String created_ymd;
    private String updater_id;
    private String updated_ymd;
}
