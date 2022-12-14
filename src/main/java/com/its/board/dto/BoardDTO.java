package com.its.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class BoardDTO {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private Timestamp boardCreatedDate;
    private int boardHits;
    // 파일을 담기위한 필드
    private MultipartFile boardFile;
    // 원본파일 이름용 필드
    private String originalFileName;
    // 서버관리 이름용 필드
    private String storedFileName;
    // 파일첨부 여부
    private int fileAttached;
}
