package com.busanit501.jsp_server_project1;

import com.busanit501.jsp_server_project1._0203_todo.dao._0203_4_TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _0203_5_TodoDAOTests {

    //준비물
    // 1) 디비 서버에 연결해서, 시간을 가져오는 기능을 가지고 있는 클래스 이용하기.
    // 주입.
    private _0203_4_TodoDAO todoDAO;

    // 2) 테스트를 할 때, 항상 todoDAO 객체 필요해서,
    // 각 메서드가 실행되기 전에, 미리 생성하는 코드
    @BeforeEach
    public void ready() {
        // 각 각의 단위테스트 메서드가 실행되기전에, 생성자 호출, 객체를 인스턴스화를 한다.
        todoDAO = new _0203_4_TodoDAO();
    }

    // 실제 테스트, 메서드
    @Test
    public void testTime() throws Exception {
        System.out.println("현재 시간 : " + todoDAO.getTime2());
    }

}
