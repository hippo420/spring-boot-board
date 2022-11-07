package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.IBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private IBoardService iBoardService;

    @RequestMapping("board/list")
    public ModelAndView lstBoard() throws Exception{
        ModelAndView mv = new ModelAndView("board/boardList");

        List<BoardDto> boardList = iBoardService.lstBoard();
        mv.addObject("list",boardList);
        return mv;
    }

    @RequestMapping("board/listDetail")
    public ModelAndView lstDtlBoard(@RequestParam int board_idx) throws Exception{
        ModelAndView mv =new ModelAndView("board/boardDetail");

        BoardDto boardDto = iBoardService.lstDtlBoard(board_idx);
        mv.addObject("board",boardDto);
        return mv;
    }
    //글쓰기 창
    @RequestMapping("board/insert")
    public String insBoard() throws Exception{
        return "board/boardWrite";
    }

    //글쓰기시 입력메소드
   @RequestMapping("board/insBoard")
    public String insBoard(BoardDto boardDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        iBoardService.insBoard(boardDto, multipartHttpServletRequest);
        return "redirect:/board/list";
    }

    @RequestMapping("board/updBoard")
    public String updBoard(BoardDto boardDto) throws Exception{
        iBoardService.updBoard(boardDto);
        return "redirect:/board/list";
    }

    @RequestMapping("board/delBoard")
    public String delBoard(int board_idx) throws Exception{
        iBoardService.delBoard(board_idx);
        return "redirect:/board/list";
    }


}
