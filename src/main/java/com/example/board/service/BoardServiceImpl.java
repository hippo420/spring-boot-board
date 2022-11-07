package com.example.board.service;

import com.example.board.Utils.FIleUtils;
import com.example.board.dto.BoardDto;
import com.example.board.dto.BoardFileDto;
import com.example.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private FIleUtils fIleUtils;

    @Override
    public List<BoardDto> lstBoard() throws Exception{


        return boardMapper.lstBoard();
    }

    @Override
    public BoardDto lstDtlBoard(int board_idx) throws Exception{
        boardMapper.updHitCnt(board_idx);
        BoardDto boardDto= boardMapper.lstDtlBoard(board_idx);
        List<BoardFileDto> boardFileDtoList = boardMapper.lstBoardFile(board_idx);
        boardDto.setBoardFileDtoList(boardFileDtoList);
        return boardDto;
    }

    @Override
    public void insBoard(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        boardMapper.insBoard(boardDto);
        List<BoardFileDto> boardFileDtoList = fIleUtils.parseIntFileInfo(boardDto.getBoard_idx(),multipartHttpServletRequest);
        if(CollectionUtils.isEmpty(boardFileDtoList)==false)
            boardMapper.insBoardFile(boardFileDtoList);
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
