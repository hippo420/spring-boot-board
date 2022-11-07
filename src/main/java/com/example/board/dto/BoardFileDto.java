package com.example.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardFileDto extends CommonVo{

    private int idx;
    private int board_idx;
    private String original_file_name;
    private String stored_file_path;
    private long file_size;
}
