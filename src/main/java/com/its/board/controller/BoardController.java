package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    //    @GetMapping("/board/save") // @RequestMapping x
    @GetMapping("/save")
    public String saveForm() {
//        return "boardSave"; // => views/boardSave.jsp (x)
        return "boardPages/boardSave"; // => views/boardPages/boardSave.jsp
    }

    //    @PostMapping("/board/save") /board/board/save 주소요청에 반응
//    @PostMapping("/save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute BoardDTO boardDTO) {
        boolean result = boardService.save(boardDTO);
        if (result) {
            return "redirect:/board/";
        } else {
            return "boardPages/saveFail";
        }
    }

}
