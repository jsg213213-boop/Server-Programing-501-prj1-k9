package com.busanit501.jsp_server_project1.springex_0213_keep.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    // 해결책1,
    // 답지를 알고서, 정확하게, 해당 담당클래스를 호출해서, 처리.
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

    // 해결책2
    // 제가 의도치 않은 상황이 발생. 그래서, 이 예외처리를 딱 지정해서 못하는 경우.
    // 범위를 넓혀서, 일반적으로 처리. Exception , 좀더 범위가 큰 클래스를 이용.
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public  String exceptCommon(Exception exception) {
        log.error("===============어떤 예외가 발생할지 모르니, 범위가 큰 예외로 처리함. 예외처리 테스트=======================");
        log.error(exception.getMessage());

        // 데이터 전달하기 : 앞에서는 문자열을 그대로 전달.
        // 이번에는 , 문자열 -> html 포맷 형태로 전달.
        // 스트링버퍼라는 문자열 클래스를 이용해서, 여기에 html 태그를 첨부해서, 전달.
        StringBuffer buffer = new StringBuffer("<ul>");
        buffer.append("<li>" + exception.getMessage() + "</li>");
        // 여기 내용으로 추가로, 트레이스, 추적, 왜 예외가 발생했는지? 어디서 부터 발생했는지의 내용? 같이 추가해보기.
        // 병렬 처리, 1) 전체 예외를 가지고 오고 2) 버퍼 문자열에 하나씩 추가하고,  3) ul 태그를 닫아서, 전달.
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>" + stackTraceElement + "</li>");
        });
        buffer.append("</ul>");
        String result = buffer.toString(); // 전체 예외의 발생한 추적 결과가 담겨져 있음.
        return result;
    }

    //해결책3, 404 not found 페이지 예외처리.
    // 주의 사항,
    // 리턴 타입 : String 문자열
    // return "custom404"; -> 해당 화면을 의미.
    // /WEB-INF/views/custom404.jsp
    // 화면을 리턴함.
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }

}
