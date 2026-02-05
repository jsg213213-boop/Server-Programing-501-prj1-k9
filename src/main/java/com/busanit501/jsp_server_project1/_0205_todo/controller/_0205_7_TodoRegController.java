package com.busanit501.jsp_server_project1._0205_todo.controller;

import com.busanit501.jsp_server_project1._0205_todo.dto._0205_2_TodoDTO;
import com.busanit501.jsp_server_project1._0205_todo.service._0205_1_TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name="_0205_7_TodoRegController", urlPatterns = "/todo/register_0205")
public class _0205_7_TodoRegController extends HttpServlet {
    // 2가지 기능을 제공
    // 1) 화면 제공, 2) 글쓰기 작업 수행.

    // 컨트롤러에서,  글쓰기하는 서비스 기능이 없음,
    // 1) 여기서 또 새로 만들거나 , 2) 이미 만들어진 기능을 가져와서 재사용.
    // 정답 : 2) 이용.

    // 서비스의 기능을 가지고 있는 클래스 이용 : _0204_4_TodoService
    private _0205_1_TodoService todoService = _0205_1_TodoService.INSTANCE;
    // 시간의 포맷 형태를 변경하는 기능을 추가. HH : 24시간제 표기 , a(오전/오후) hh : 1 ~12시 나타냄.
//    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    // 글쓰기 화면 제공
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("/todo/register, 글작성 폼 임시화면 get으로 요청 처리함. ");
        req.getRequestDispatcher("/WEB-INF/_0205_todo/todoReg.jsp").forward(req,resp);

    }

    //순서4, 글쓰기 로직 처리.
    // post 처리 담당.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // 받을 때 한글 설정,
        req.setCharacterEncoding("UTF-8");

        log.info("todo/register 글쓰기 로직 처리하는 곳입니다.");
        log.info("PRG 패턴으로 글쓰기 post 작업 후, 리다이렉트 목록 화면으로 이동하기.");

        // 화면으로부터 전달받은 데이터를, -> DTO 객체 담아서, -> 서비스에 전달.
        _0205_2_TodoDTO todoDTO = _0205_2_TodoDTO.builder()
                .title(req.getParameter("title"))
//                .dueDate(req.getParameter("dueDate"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFORMATTER))
                .build();
        //서비스에 전달.
        try {
            // 보낼 때 한글 설정,
            // 나중에, 서버에 한번만 설정해서, 따로 설정 없이, 이용만 하면됨.
            resp.setContentType("text/html;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/todo/list_0205");

    }

}
