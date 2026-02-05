package com.busanit501.jsp_server_project1._0205_todo.listener;

import com.busanit501.jsp_server_project1._0205_todo.dao._0205_9_ConnectionUtil;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Log4j2
@WebListener // 톰캣에게 "나를 감시자로 등록해줘"라고 알림
public class _0205_10_TodoContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("웹 애플리케이션 시작! (여기서 DB 미리 연결 등을 할 수도 있음)");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("웹 애플리케이션 종료 감지! 자원을 해제합니다.");
        // ★ 여기서 ConnectionUtil의 풀 종료 기능을 호출
        _0205_9_ConnectionUtil.INSTANCE.closePool();
    }
}
