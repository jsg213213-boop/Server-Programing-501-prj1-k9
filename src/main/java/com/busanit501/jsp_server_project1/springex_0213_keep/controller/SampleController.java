package com.busanit501.jsp_server_project1.springex_0213_keep.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    //어떻게 화면 연결이 없는데, 화면으로 이동하나요?
    // 스프링 내부구조에 담당자 이름 : 뷰 리졸버 .
    //http://localhost:8080/hello2
    // 서버에서, /WEB-INF/views/hello2.jsp
    // hello2
    @GetMapping("/hello2")
    public void hello() {
        log.info("hello spring mvc ~~~");
    }

    // 화면에서 get 데이터를 서버에게 전달하는 방법,
    // 쿼리 스트링 이용하기.
    // http://localhost:8080/ex1?name=이상용&age=20
    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1 ~~~");
        log.info("데이터 수집 : name : " + name);
        log.info("데이터 수집 : age : " + age);
    }

    // http://localhost:8080/ex2?name=이상용&age=20
    // http://localhost:8080/ex2
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "이름을 입력해주세요") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex2 ~~~");
        log.info("데이터 수집 : name : " + name);
        log.info("데이터 수집 : age : " + age);
    }

    // http://localhost:8080/ex3?dueDate=2026-02-19
    // 화면에서, dueDate=2026-02-13 : 문자열 타입.
    // 서버에서, 받는 타입을 : LocalDate
    // 도대체 누가 중간에서, 변환을 했지? 빈이름(객체이름) : conversionService, 변환해줌.

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3 ~~~");
        log.info("데이터 수집 : dueDate : " + dueDate);
    }

    // http://localhost:8080/ex4
    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("ex4 ~~~");
        log.info("데이터 받아서 화면에 전달하자 ");
        //화면에 데이터 전달하기. model 를 이용해서,
        model.addAttribute("msg", "hello~~");
    }

    // http://localhost:8080/ex5
    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        log.info("ex5 ~~~");
        log.info("데이터 받아서 화면에 전달하자 1) 쿼리스트링으로 전달. 2) 1회용으로도  ");
        redirectAttributes.addAttribute("name","TEST EX5");
        //  2) 1회용
        redirectAttributes.addFlashAttribute("result","success");
        // 리다이렉트
        return "redirect:/ex6";
        //화면에 데이터 전달하기. model 를 이용해서,
    }
    @GetMapping("/ex6")
    public void ex6() {

    }

    @GetMapping("/ex7")
    // 예외 포인트는 화면에서 전달하는 값은 기본 무조건 문자열임.
    // 그런데, 받을 때, 임의로 숫자 타입으로 받고 있음.
    // 예외가 발생되는 부분.
    public void ex7(String p1, int p2) {
        log.info("p1 : " + p1);
        log.info("p2 : " + p2);
    }


}
