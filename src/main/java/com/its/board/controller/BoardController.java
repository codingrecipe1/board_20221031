package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.dto.CommentDTO;
import com.its.board.dto.PageDTO;
import com.its.board.service.BoardService;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;

    //    @GetMapping("/board/save") // @RequestMapping x
    @GetMapping("/save")
    public String saveForm() {
//        return "boardSave"; // => views/boardSave.jsp (x)
        return "boardPages/boardSave"; // => views/boardPages/boardSave.jsp
    }

    //    @PostMapping("/board/save") /board/board/save 주소요청에 반응
//    @PostMapping("/save")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute BoardDTO boardDTO) throws IOException {
        boardService.save(boardDTO);
        return "redirect:/board/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "boardPages/boardList";
    }

    // 페이징목록
    @GetMapping("/paging")
    public String paging(Model model,
                         @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
//        System.out.println("page = " + page);
        // 해당 페이지에서 보여줄 글 목록
        List<BoardDTO> pagingList = boardService.pagingList(page);
        // 하단 페이지 번호 표현을 위한 데이터
        PageDTO pageDTO = boardService.pagingParam(page);
        model.addAttribute("boardList", pagingList);
        model.addAttribute("paging", pageDTO);
        return "boardPages/boardPaging";
    }

    // 상세조회: /board?id=
    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        model.addAttribute("page", page);
        System.out.println("조회: boardDTO = " + boardDTO);
        List<CommentDTO> commentDTOList = commentService.findAll(id);
        model.addAttribute("commentList", commentDTOList);
        return "boardPages/boardDetail";
    }

    // 수정화면 요청
    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardUpdate";
    }

    // 수정처리
    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
        boardService.update(boardDTO);
        // 수정 처리 후 상세페이지 출력
        // redirect로 상세페이지 요청
//        return "redirect:/board?id=" + boardDTO.getId();
        // DB에서 가져와서 boardDetail 출력
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board", dto);
        return "boardPages/boardDetail";
    }

    // 삭제 화면 요청
    @GetMapping("/deleteCheck")
    public String deleteCheck(@RequestParam("id") Long id, Model model) {
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/deleteCheck";
    }

    // 삭제 처리
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        boardService.delete(id);
        return "redirect:/board/";
    }

    // 검색 처리
    @GetMapping("/search")
    public String search(@RequestParam("type") String type,
                         @RequestParam("q") String q, Model model) {
        List<BoardDTO> searchList = boardService.search(type, q);
        model.addAttribute("boardList", searchList);
        return "boardPages/boardList";
    }


}













