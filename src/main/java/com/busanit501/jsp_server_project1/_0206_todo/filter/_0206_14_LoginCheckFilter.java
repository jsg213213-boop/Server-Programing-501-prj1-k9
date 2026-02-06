package com.busanit501.jsp_server_project1._0206_todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"})
public class _0206_14_LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        // 여기서, 실제 동작을 정의 및 체크.
        log.info("로그인 체크 필터 1, 테스트");

        // 기존 글쓰기 폼화면에서 작업 하던 코드를 그대로 복붙 했다.
        // servletRequest : 범위가 좀더 커서, 기능이 추상적이라서,
        // 좀더 구체적인 타입으로 변경해서 작업, HttpServletRequest 으로 타입을 변경.
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //0206 , 글쓰기 화면에 접근하기 전에, 세션에서 로그인 유저를 체크를해서,
        // JSESSIONID 를 체크. 있으면 진행. 없으면 로그인 페이지로 이동시키자.

        // 세션를 이용하기 위해서, 도구가 필요함. 객체를 이용하기.
        HttpSession session = req.getSession();

        // 기존에 접근 이용자인지? 새로운 이용자 인지? 여부 확인을 JSESSIONID
        if(session.isNew()){
            // 새로운 이용자이니, 서버 : JSESSIONID 생성해서, 서버 메모리에 가지고 있고,
            // 그리고, 웹 브라우저에게, 쿠키에 담아서, 보내기.
            log.info("JSESSIONID 쿠키가 새롭게 만들어진 사용자");
            // 새로 오셨네요? , 로그인 페이지로 가서, 로그인 해주세요. -> 아직 없음, 곧 만들 예정.
            resp.sendRedirect("/login");
        }

        // 임시 로그인 처리라서,
        // JSESSIONID 있어요, 해당 서버에 완전 최초 접속자는 아니예요.
        // 세션이라는 공간에 loginInfo 라는 이름으로 저장을 할예정, 로그인한 유저를 .
        if(session.getAttribute("loginInfo") == null) {
            log.info("로그인 정보가 없는 사용자입니다.");
            resp.sendRedirect("/login");
            return;
        }

        // JSESSIONID 있고, loginInfo(명단), 로그인한 유저 정보가 있어요, -> 로그인 되었다고 가정.

        // 통과후, 원래 과정으로 진행하기. 컨트롤러에 가서, 라우팅 및 원래 하던 일 처리하기.
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
