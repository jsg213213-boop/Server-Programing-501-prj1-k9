package com.busanit501.jsp_server_project1.springex_0213_keep.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// http://localhost:8080/todo/ 관련된 업무는 내가 처리할게.
@RequestMapping("/todo2")
@Log4j2
public class TodoController {

    // http://localhost:8080/todo/list
    // 뷰 리졸버가 연결되어서,
    // todo/list -> WEN-INF/views/todo/list.jsp 연결 설정됨.
    @RequestMapping("/list")
    public void list() {
        log.info("todo list...");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void register() {
        log.info("todo register..get");
    }
}
