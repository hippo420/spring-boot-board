package com.example.board.service;


import com.example.board.dto.BoardDto;

import java.util.List;

public interface IBoardService {

    List<BoardDto> lstBoard() throws Exception;

    BoardDto lstDtlBoard(int board_idx) throws Exception;

    void insBoard(BoardDto boardDto) throws  Exception;

    void updBoard(BoardDto boardDto) throws Exception;

    void delBoard(int board_idx) throws Exception;

}
