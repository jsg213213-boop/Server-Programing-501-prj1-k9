package com.busanit501.jsp_server_project1.springex_0213_keep.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello2")
    public void hello() {
        log.info("hello spring mvc ~~~");
    }
}
