package com.busanit501.jsp_server_project1._0203_todo;

import com.busanit501.jsp_server_project1._0203_todo.dto._3_TodoDTO;
import com.busanit501.jsp_server_project1._0203_todo.service._4_TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


//순서2, 서블릿 라우팅 경로 및 이름 설정, 고정, 이름과 경로는 동적(변경이됨)
@WebServlet(name="_1_todoListController_0202", urlPatterns = "/todo/list_0202")
//순서1 , 클래스 생성 후, 상속 받기, 고정.
public class _1_TodoListController extends HttpServlet {
//    화면제공 목적
        // 순서3, 화면 제공 목적은 doGet 작업을함.
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        System.out.println("여기 왔다는 건, 클라이언트, url 주소 요청하고, 서버가 응답을 한다. ");
        System.out.println("서버가 일을 하고 있다. 조금 있다 화면을 웹브라우저에게 던져준다. ");
        System.out.println("/todo/list_0202, get으로 요청 처리함. ");

        // 0202_모델클래스_서비스_컨트롤러를_이용한_로직 처리_순서1
        // _4_TodoService , 기능에서, 데이터를 조회하는 기능
        // 지금은 더미 데이터, 나중에, 데이터베이스를 붙이기.
        List<_3_TodoDTO> dtoList = _4_TodoService.INSTANCE.getList();
        // 서버 -> 클라이언트 , 응답, 방금 메서드 호출해서, 받아온, 임시 더미 데이터 10개를 전달.
        req.setAttribute("list", dtoList);

        // 한줄로 표현한 내용.
        req.getRequestDispatcher("/WEB-INF/_0202_todo/list.jsp").forward(req,resp);
        // 0202_모델클래스_서비스_컨트롤러를_이용한_로직 처리_순서1


        }
}
