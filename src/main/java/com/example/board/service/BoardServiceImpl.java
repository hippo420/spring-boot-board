package com.example.board.service;

import com.example.board.dto.BoardDto;
import com.example.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> lstBoard() throws Exception{


        return boardMapper.lstBoard();
    }

    @Override
    public BoardDto lstDtlBoard(int board_idx) throws Exception{
        boardMapper.updHitCnt(board_idx);
        BoardDto boardDto= boardMapper.lstDtlBoard(board_idx);
        return boardDto;
    }

    @Override
    public void insBoard(BoardDto boardDto) throws Exception{
        boardMapper.insBoard(boardDto);
    }

    @Override
    public void updBoard(BoardDto boardDto) throws Exception{
        boardMapper.updBoard(boardDto);
    }

    @Override
    public void delBoard(int board_idx) throws Exception{
        boardMapper.delBoard(board_idx);
    }

}
