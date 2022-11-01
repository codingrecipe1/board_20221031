package com.its.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
//    @GetMapping("/board/save") // @RequestMapping x
    @GetMapping("/save")
    public String saveForm() {
//        return "boardSave"; // => views/boardSave.jsp (x)
        return "boardPages/boardSave"; // => views/boardPages/boardSave.jsp
    }

//    @PostMapping("/board/save") /board/board/save 주소요청에 반응
//    @PostMapping("/save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save() {
        return null;
    }

}
