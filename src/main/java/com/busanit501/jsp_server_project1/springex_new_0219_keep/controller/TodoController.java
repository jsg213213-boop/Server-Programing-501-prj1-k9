package com.busanit501.jsp_server_project1.springex_new_0219_keep.controller;

import com.busanit501.jsp_server_project1.springex_new_0219_keep.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// http://localhost:8080/todo2/ 관련된 업무는 내가 처리할게.
@RequestMapping("/todo2")
@Log4j2
public class TodoController {

    // http://localhost:8080/todo2/list
    // 뷰 리졸버가 연결되어서,
    // todo2/list -> WEN-INF/views/todo2/list.jsp 연결 설정됨.
    @RequestMapping("/list")
    public void list() {
        log.info("todo list...");
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @GetMapping("/register")
    // 뷰 리졸버가 연결되어서,
    // todo2/list -> WEN-INF/views/todo2/register.jsp 연결 설정됨.
    public void getRegister() {
        log.info("todo register..get");
    }

    @PostMapping("/register")
    public void postRegister(TodoDTO todoDTO) {
        log.info("todo register..post");
        log.info("todoDTO : " + todoDTO);
    }
}
