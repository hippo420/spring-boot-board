package com.example.board.mapper;

import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> lstBoard() throws Exception;

    BoardDto lstDtlBoard(int board_idx) throws Exception;
    void updHitCnt(int board_idx) throws Exception;
    void insBoard(BoardDto boardDto) throws Exception;
    void updBoard(BoardDto boardDto) throws Exception;
    void delBoard(int board_idx) throws Exception;

    void insBoardFile(List<BoardFileDto> boardFileDtoList)throws Exception;

    List<BoardFileDto> lstBoardFile(int board_idx)throws Exception;
}
