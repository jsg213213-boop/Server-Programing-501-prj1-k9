package com.busanit501.jsp_server_project1.springex_0213_keep.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    // 응답을 할 때, 서버가 데이터를 전송할 때 쓰는 약속,
    // 현재는 문자열 데이터로 그대로 전송 하지만,
    // 나중에, JSON 중간 데이터 타입 형태로 전달 할 예정입니다.
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptBNumber(NumberFormatException numberFormatException) {
        log.error("================숫자 및 문자열 타입 불일치 예외처리 테스트=======================");
        log.error(numberFormatException.getMessage());
        return "Number Format Exception Test!!";
    }
}
