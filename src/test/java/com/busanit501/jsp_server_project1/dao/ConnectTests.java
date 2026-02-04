package com.busanit501.jsp_server_project1.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {

    @Test
    public void test1() {
        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1,v2);

    } //

    @Test
    public void testConnection() throws Exception{
        // 1 드라이버 연결.
        Class.forName("org.mariadb.jdbc.Driver");

        // 2 연결 커넥션 객체 도구 이용.
        // 접근 하는 디비 서버 1) 주소 2) 계정 3) 패스워드
        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );

        // 3. 연결 도구의 객체가 유효한지, 체크
        Assertions.assertNotNull(connection);

        // 4. 확인 후, 자원 반납
        connection.close();


    }
}
