package com.example.board.service;


import com.example.board.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface IBoardService {

    List<BoardDto> lstBoard() throws Exception;

    BoardDto lstDtlBoard(int board_idx) throws Exception;

    void insBoard(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest) throws  Exception;

    void updBoard(BoardDto boardDto) throws Exception;

    void delBoard(int board_idx) throws Exception;

}
