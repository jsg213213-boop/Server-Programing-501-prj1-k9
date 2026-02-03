package com.busanit501.jsp_server_project1._0203_todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//순서2, 서블릿 라우팅 경로 및 이름 설정, 고정, 이름과 경로는 동적(변경이됨)
@WebServlet(name="_2_todoRegController", urlPatterns = "/todo/register")
//순서1 , 클래스 생성 후, 상속 받기, 고정.
public class _2_TodoRegController extends HttpServlet {
    //    화면제공 목적
    // 순서3, 화면 제공 목적은 doGet 작업을함.
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("/todo/register, 글작성 폼 임시화면 get으로 요청 처리함. ");

        // 한줄로 표현한 내용.
        req.getRequestDispatcher("/WEB-INF/_0130_todo/todoReg.jsp").forward(req,resp);

    }

    //순서4, 글쓰기 로직 처리.
    // post 처리 담당.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("todo/register 글쓰기 로직 처리하는 곳입니다.");
        System.out.println("PRG 패턴으로 글쓰기 post 작업 후, 리다이렉트 목록 화면으로 이동하기.");
        resp.sendRedirect("/todo/list");

    }

}
